package com.demo.xml.controller;

import com.demo.xml.entity.Module;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sheng on 2018/6/22.
 */
@RestController
public class Demo2Controller {

    @GetMapping("/findInfo")
    public ResponseEntity<Map<String, Object>> findInfo() {
        Map<String, Object> map = new HashMap<>();
        Resource resource = new ClassPathResource("xml/Demo.xml");
        File file = null;
        try {
            InputStream inputStream = resource.getInputStream();
            file = File.createTempFile("test", ".txt");
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            file = resource.getFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if (!file.exists()) {
            System.out.println("xml文件不存在！");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        Map<String, Object> result = getModules(file);
        if (result == null) {
            System.out.println("解析xml出错");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        map.putAll(result);
        return ResponseEntity.ok(map);
    }

    private Map<String, Object> getModules(File file) {
        double totalWidth = 28600;
        double totalHeight = 19240;
        Module m = null;
        Map<String, Object> result = new HashMap<>();
        List<Module> moduleList = null;
        List<String> drawingNameList = new ArrayList<>();

        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(file);
            List<Element> drawingEles = (List<Element>) document.getRootElement().element("Instance").elements("Drawing");
            for (int i = 0; i < drawingEles.size(); i++) {
                Element drawing = drawingEles.get(i);
                String drawingName = drawing.attribute("DiagramName").getValue();
                List<Element> modules = (List<Element>) drawing.elements("Module");
                moduleList = new ArrayList<>();
                for (int j = 0; j < modules.size(); j++) {
                    m = new Module();
                    Element module = modules.get(j);
                    String name = module.attribute("ModuleName").getValue();
                    name = name.substring(name.lastIndexOf("::") + 2, name.length());
                    String instNumber = module.attribute("InstNumber").getValue();
                    double left = Double.valueOf(module.element("Layout").element("Left").attribute("value").getValue()) / totalWidth * 5720;
                    double top = Double.valueOf(module.element("Layout").element("Top").attribute("value").getValue()) / totalHeight * 3848;
                    double width = Double.valueOf(module.element("Layout").element("Width").attribute("value").getValue()) / totalWidth * 5720;
                    double height = Double.valueOf(module.element("Layout").element("Height").attribute("value").getValue()) / totalHeight * 3848;
                    left = Double.valueOf(String.format("%.2f", left));
                    top = Double.valueOf(String.format("%.2f", top));
                    width = Double.valueOf(String.format("%.2f", width));
                    height = Double.valueOf(String.format("%.2f", height));
                    m.setName(name + instNumber);
                    m.setModuleName(name);
                    m.setLeft(left);
                    m.setTop(top);
                    m.setWidth(width);
                    m.setHeight(height);
                    List<Element> inputList = module.element("Inputs").elements("Input");
                    if (inputList.size() > 0) {
                        for (int k = 0; k < inputList.size(); k++) {
                            Element input = inputList.get(k);
                            String sourceModuleName = input.attribute("SourceModuleName").getValue();
                            String sourceInstNumber = input.attribute("SourceModuleInstNumber").getValue();
                            String sourceValue = input.attribute("SourceValue").getValue();
                            String inputName = input.attribute("InputName").getValue();
                            if (StringUtils.isNoneBlank(sourceInstNumber, sourceInstNumber)) {
                                sourceModuleName = sourceModuleName.substring(sourceModuleName.lastIndexOf("::") + 2, sourceModuleName.length());
                                Module sourceModule = new Module();
                                sourceModule.setName(sourceModuleName + sourceInstNumber);
                                sourceModule.setModuleName(sourceModuleName);
                                m.getSourceModule().add(sourceModule);
                            } else if (StringUtils.isNotBlank(sourceValue) && !sourceValue.startsWith("{")) {
                                if (!moduleExist(sourceValue, moduleList)) {
                                    Module source = new Module();
                                    source.setType("input");
                                    source.setName(sourceValue);
                                    source.setModuleName(sourceValue);
                                    int size = existInputSize(m.getSourceModule());
                                    source.setTop(top + 35 * size);
                                    source.setLeft(left - 400);
                                    source.setWidth(200);
                                    source.setHeight(30);
                                    m.getSourceModule().add(source);
                                    moduleList.add(source);
                                } else {
                                    Module source = new Module();
                                    source.setType("input");
                                    source.setName(sourceValue);
                                    m.getSourceModule().add(source);
                                }
                            } else if (StringUtils.isNotBlank(sourceValue) && sourceValue.startsWith("{")) {
                                Module source = new Module();
                                source.setType("inputSignal");
                                source.setName(m.getName() + "_" + inputName);
                                source.setModuleName("DIGITAL_");// 这块不知道显示什么名称，暂时固定显示DIGITAL_
                                int size = existInputSize(m.getSourceModule());
                                source.setTop(top + 35 * size);
                                source.setLeft(left - 400);
                                source.setWidth(200);
                                source.setHeight(30);
                                m.getSourceModule().add(source);
                                moduleList.add(source);
                            }
                        }
                    }
                    moduleList.add(m);
                    List<Element> outputList = module.element("Outputs").elements("Output");
                    if (outputList.size() > 0) {
                        for (int k = 0; k < outputList.size(); k++) {
                            Element output = outputList.get(k);
                            String targetTag = output.attribute("TargetTag").getValue();
                            String targetValue = output.attribute("TargetValue").getValue();
                            String outputName = output.attribute("OutputName").getValue();
                            if (StringUtils.equals("Output", targetTag)) {
                                Module target = new Module();
                                target.setType("output");
                                target.setName(targetValue);
                                target.setModuleName(targetValue);
                                int size = existOutputSize(m.getName(), moduleList);
                                target.setTop(top + 35 * size);
                                target.setLeft(left + width + 200);
                                target.setWidth(200);
                                target.setHeight(30);
                                target.getSourceModule().add(m);
                                moduleList.add(target);
                            } else if (StringUtils.equals("Terminator", targetTag)) {
                                Module target = new Module();
                                target.setType("outputTer");
                                target.setName(m.getName() + "_" + outputName);
                                target.setModuleName("");
                                int size = existOutputSize(m.getName(), moduleList);
                                target.setTop(top + 35 * size);
                                target.setLeft(left + width + 200);
                                target.setWidth(200);
                                target.setHeight(30);
                                target.getSourceModule().add(m);
                                moduleList.add(target);
                            }
                        }
                    }
                    List<Element> parameterList = module.element("Parameters").elements("Parameter");
                    if (parameterList.size() > 0) {
                        int size = parameterList.size();
                        double sepWidth = 5;
                        double oneParamWidth = Double.valueOf(String.format("%.2f", (width - (size - 1) * sepWidth) / size));
                        for (int k = 0; k < parameterList.size(); k++) {
                            Element parameter = parameterList.get(k);
                            String sourceValue = parameter.attribute("SourceValue").getValue();
                            Module param = new Module();
                            param.setType("parameter");
                            param.setName(sourceValue);
                            param.setModuleName(sourceValue);
                            param.setTop(top + height - 30);
                            param.setLeft(left + (sepWidth + oneParamWidth) * k);
                            param.setWidth(oneParamWidth);
                            param.setHeight(20);
                            moduleList.add(param);
                        }
                    }

                }
                result.put(drawingName + "~" + i, moduleList);
                drawingNameList.add(drawingName + "~" + i);
            }
            result.put("drawingName", drawingNameList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    private int existOutputSize(String sourceModuleName, List<Module> moduleList) {
        int count = 0;
        for (Module module : moduleList) {
            if ((StringUtils.equals("output", module.getType()) || StringUtils.equals("outputTer", module.getType())) && StringUtils.equals(sourceModuleName, module.getSourceModule().get(0).getName())) {
                count++;
            }
        }
        return count;
    }

    private int existInputSize(List<Module> sourceModule) {
        int count = 0;
        for (Module module : sourceModule) {
            if (StringUtils.equals("input", module.getType()) || StringUtils.equals("inputSignal", module.getType())) {
                count++;
            }
        }
        return count;
    }

    private boolean moduleExist(String sourceValue, List<Module> moduleList) {
        for (Module module : moduleList) {
            if (StringUtils.equals(module.getName(), sourceValue)) {
                return true;
            }
        }
        return false;
    }
}
