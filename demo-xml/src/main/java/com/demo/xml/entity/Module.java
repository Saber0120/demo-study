package com.demo.xml.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 模块框
 * Created by sheng on 2018/6/22.
 */
public class Module implements Serializable {

    private static final long serialVersionUID = 7192372531996914887L;

    private String name;//名称

    private double top;//绝对定位上位移

    private double left;//绝对定位左位移

    private double width;//宽度

    private double height;//高度

    private String type = "module";//模块类型，"input"|"output"|"module"

    private List<Module> sourceModule = new ArrayList<>();//所连接的其他模块框

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTop() {
        return top;
    }

    public void setTop(double top) {
        this.top = top;
    }

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Module> getSourceModule() {
        return sourceModule;
    }/*

    public void setSourceModule(List<Module> sourceModule) {
        this.sourceModule = sourceModule;
    }*/
}
