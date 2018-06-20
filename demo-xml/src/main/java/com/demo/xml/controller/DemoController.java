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

        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(file);
            Element users = document.getRootElement();
            showEle(users, 0);
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
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
}
