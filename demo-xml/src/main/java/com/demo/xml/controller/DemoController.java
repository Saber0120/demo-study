package com.demo.xml.controller;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by sheng on 2018/6/19.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping
    public ResponseEntity<Void> findAll() {
        return ResponseEntity.noContent().build();
    }

    public static void main(String[] args) {
//        Resource resource = new ClassPathResource("xml/Demo.xml");
//        File file = null;
//        try {
//            file = resource.getFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (!file.exists()) {
//            System.out.println("xml文件不存在！");
//            return;
//        }
//
//        SAXReader saxReader = new SAXReader();
//        try {
//            Document document = saxReader.read(file);
//            Element users = document.getRootElement();
//            System.out.println(users.element("Instance").getName());
//            showEle(users, 0);
//        } catch (DocumentException e) {
//            System.out.println(e.getMessage());
//        }

        showDraw();
    }

    private static void showEle(Element ele, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
        System.out.print(ele.getName() + "(");
        for (Iterator l = ele.attributeIterator(); l.hasNext(); ) {
            Attribute a = (Attribute) l.next();
            System.out.print(a.getName() + "->" + a.getValue());
            if (l.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
        count += 2;
        for (Iterator i = ele.elementIterator(); i.hasNext(); ) {
            showEle((Element) i.next(), count);
        }
    }

    private static void showDraw() {
        Resource resource = new ClassPathResource("xml/Demo.xml");
        File file = null;
        try {
            file = resource.getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!file.exists()) {
            System.out.println("xml文件不存在！");
            return;
        }

        double totalWidth = 28600;
        double totalHeight = 19240;
        StringBuilder drawingSb = new StringBuilder();
        String drawingName = "";

        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(file);
            List<Element> drawingEles = (List<Element>) document.getRootElement().element("Instance").elements("Drawing");
            Element inputs = document.getRootElement().element("Instance").element("Inputs");
            Element params = document.getRootElement().element("Instance").element("Parameters");
            Element outputs = document.getRootElement().element("Instance").element("Outputs");
            String inputsStr = analysInputs(inputs);
            String paramsStr = analysParams(params);
            String outputsStr = analysOutputs(outputs);
            for (int i = 0; i < drawingEles.size(); i++) {
                Element drawing = drawingEles.get(i);
                drawingName = drawing.attribute("DiagramName").getValue();
                List<Element> modules = (List<Element>) drawing.elements("Module");
                drawingSb = new StringBuilder();
                String template = loadTemplate();
                template = template.replace("###inputs###", inputsStr);
                template = template.replace("###parameters###", paramsStr);
                template = template.replace("###outputs###", outputsStr);
                for (int j = 0; j < modules.size(); j++) {
                    Element module = modules.get(j);
                    double left = Double.valueOf(module.element("Layout").element("Left").attribute("value").getValue()) / totalWidth * 2000;
                    double top = Double.valueOf(module.element("Layout").element("Top").attribute("value").getValue()) / totalHeight * 1000;
                    double width = Double.valueOf(module.element("Layout").element("Width").attribute("value").getValue()) / totalWidth * 2000;
                    double height = Double.valueOf(module.element("Layout").element("Height").attribute("value").getValue()) / totalHeight * 1000;
                    drawingSb.append("<div style=\"background-color: #FFF68F;border: 1px solid black; position: absolute; top: " + top + "px; left: " + left + "px; width: " + width + "px; height: " + height + "px;\">");
                    String moduleName = module.attribute("ModuleName").getValue();
                    drawingSb.append("<div style=\"height: 50%; text-align: center;\"><span style=\"margin-top: 5px; display: inline-block;\">");
                    drawingSb.append(moduleName);
                    drawingSb.append("</span></div>");
                    drawingSb.append("<div style=\"height: 50%;\">");
                    Element parameters = module.element("Parameters");
                    List<Element> parameterList = (List<Element>) parameters.elements("Parameter");
                    if (parameterList != null && parameterList.size() > 0) {
                        for (int k = 0; k < parameterList.size(); k++) {
                            Element parameter = parameterList.get(k);
                            drawingSb.append("<div style=\"width:50%; text-align: center; float:left; color:green;\"><b>");
                            drawingSb.append(parameter.attribute("SourceValue").getValue());
                            drawingSb.append("</b></div>");
                        }
                    }
                    drawingSb.append("</div>");
                    drawingSb.append("</div>");
                }
                String html = template.replace("###drawing###", drawingSb.toString());
                saveHtml(html, file.getName().substring(0, file.getName().lastIndexOf(".")) + "-" + drawingName);
            }
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String analysParams(Element params) {
        StringBuilder sb = new StringBuilder();
        List<Element> parameterList = params.elements("Parameter");
        if (parameterList != null && parameterList.size() > 0) {
            for (int i = 0; i < parameterList.size(); i++) {
                Element parameter = parameterList.get(i);
                sb.append("<div class=\"form-group\">");
                sb.append("<label class=\"control-label col-sm-3\">" + parameter.attribute("ParameterName").getValue() + "</label>");
                sb.append("<div class=\"col-sm-9\">");
                sb.append("<input class=\"form-control\" value=\"" + parameter.attribute("InitValue").getValue() + "\"/>");
                sb.append("</div>");
                sb.append("</div>");
            }
        }
        return sb.toString();
    }

    private static String analysOutputs(Element outputs) {
        StringBuilder sb = new StringBuilder();
        List<Element> outputList = outputs.elements("Output");
        if (outputList != null && outputList.size() > 0) {
            for (int i = 0; i < outputList.size(); i++) {
                Element output = outputList.get(i);
                sb.append("<div class=\"form-group\">");
                sb.append("<label class=\"control-label col-sm-3\">" + output.attribute("SignalName").getValue() + "</label>");
                sb.append("<div class=\"col-sm-9\">");
                sb.append("<input class=\"form-control\"/>");
                sb.append("</div>");
                sb.append("</div>");
            }
        }
        return sb.toString();
    }

    private static String analysInputs(Element inputs) {
        StringBuilder sb = new StringBuilder();
        List<Element> inputList = inputs.elements("Input");
        if (inputList != null && inputList.size() > 0) {
            for (int i = 0; i < inputList.size(); i++) {
                Element input = inputList.get(i);
                sb.append("<div class=\"form-group\">");
                sb.append("<label class=\"control-label col-sm-3\">" + input.attribute("SignalName").getValue() + "</label>");
                sb.append("<div class=\"col-sm-9\">");
                sb.append("<input class=\"form-control\"/>");
                sb.append("</div>");
                sb.append("</div>");
            }
        }
        return sb.toString();
    }

    private static String loadTemplate() {
        String templateStr = "";
        Resource resource = new ClassPathResource("static/html/template.html");
        FileInputStream inputStream = null;
        byte[] bytes = null;
        try {
            inputStream = new FileInputStream(resource.getFile());
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        templateStr = new String(bytes);
        return templateStr;
    }

    private static void saveHtml(String moduleHtml, String fileName) {
        Resource resource = new ClassPathResource("static/html");
        String path = "";
        FileOutputStream outputStream = null;
        try {
            path = resource.getFile().getPath();
            path = path + "/" + fileName + ".html";
            outputStream = new FileOutputStream(path);
            outputStream.write(moduleHtml.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
