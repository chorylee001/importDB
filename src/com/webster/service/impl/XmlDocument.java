package com.webster.service.impl;

import java.util.List;

/**
 * Created by chory on 2015/8/27 0027.
 */
public interface XmlDocument {
    /**
     * 建立XML文档
     * @param fileName 文件全路径名称
     */
    public void createXml(String fileName);
    /**
     * 解析XML文档
     * @param fileName 文件全路径名称
     */
    public List<Object> parserXml(String fileName) throws Exception;


}
