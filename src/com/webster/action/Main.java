package com.webster.action;

import com.webster.frame.ContainerWindow;
import com.webster.service.SaxResolveXML;

import javax.swing.*;
import java.util.List;

/**
 * Created by chory on 2015/8/28 0028.
 */
public class Main {

    public static void main(String[] args) {
        /*ContainerWindow window = new ContainerWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      //关闭按钮
        window.setVisible(true);*/

        SaxResolveXML resolver = new SaxResolveXML();
        try {
            List<Object> activities =  resolver.parserXml("D:\\Users\\chory\\Desktop\\节庆-月历.xml");
            for(Object activity : activities){
                System.out.println("name:"+activity.toString());
            }
        } catch (Exception e) {
            System.out.println("小伙子,发生了异常你晓得么!!就是它----->"+e.getMessage()+",exceptionName:");
        }
    }
}
