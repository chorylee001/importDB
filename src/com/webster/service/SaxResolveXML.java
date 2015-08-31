package com.webster.service;

import com.webster.service.impl.XmlDocument;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by chory on 2015/8/27 0027.
 */
public class SaxResolveXML extends DefaultHandler implements XmlDocument {

    private List<Object> list = null;               //结果集
    private Object entity = null;       //对象
    private String preTag;              //记录上一个节点的名称
    private String firstNode;           //记录第一个节点,设置为表名称
    private Integer counter = 0;        //计数器
    private List<String> attrList;

    boolean hasAttribute = false;
    Attributes attributes = null;

    @Override
    public void createXml(String fileName) {
        System.out.println("filename------------------------->" + fileName);
    }

    @Override
    public List<Object> parserXml(String fileName) throws Exception{
        System.out.println("filename------------------------->" + fileName);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        InputStream inputStream = new FileInputStream(fileName);
        SaxResolveXML resolver = new SaxResolveXML();
        parser.parse(inputStream, resolver);

        return resolver.getList();
    }

    public void startDocument() throws SAXException {

        System.out.println("文档开始!");
        list = new ArrayList<Object>();
    }

    public void endDocument() throws SAXException {

        System.out.println("文档结束!");
    }
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if(counter == 0) {
            firstNode = qName;
        }
        if("row".equals(qName)){
            entity = new Object();
        }
        preTag = qName;//将正在解析的节点名称赋给preTag
        if (attributes.getLength() > 0) {
            this.attributes = attributes;
            this.hasAttribute = true;
        }
    }
    private void init(){
        preTag = "";
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if("row".equals(qName)){
            list.add(entity);
        }
        preTag = null;
        if (hasAttribute && (attributes != null)) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println(attributes.getQName(0)
                        + attributes.getValue(0));
            }
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if(preTag!=null){
            String content = new String(ch,start,length);
            /*if("title".equals(preTag)){
                entity.setTitle(content);
            }else if("url".equals(preTag)){
                entity.setSourceUrl(content);
            }else if("build_time".equals(preTag)){
                entity.setBuildTime(content);
            }else if("action_time".equals(preTag)){
                entity.setStartFrom("2015-" + content + "-01 00:00:00");

                entity.setEndTo("2015-" + content + "-31 23:59:59");

            }else if("area".equals(preTag)){
                entity.setRegionName(content);
            }else if("department".equals(preTag)){
                entity.setDepartment(content);
            }else if("smark".equals(preTag)){
                entity.setTxt(content);
            }else if("LastUpdated".equals(preTag)){
                entity.setLastUpdated(content);
            }*/

        }

    }

    public List<Object> getList() {
        return list;
    }

}
