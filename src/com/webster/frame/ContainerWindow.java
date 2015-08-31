package com.webster.frame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by chory on 2015/8/28 0028.
 */
public class ContainerWindow extends JFrame implements ActionListener{

    private JLabel label;
    private JButton button;
    private JButton upButton;
    private JTextField fileRoute;
    private JComboBox comboBox;
    private JMenuBar menuBar;
    private JSlider slider;
    private JSpinner spinner;
    private JToolBar toolBar;


    public ContainerWindow(){
        super();
        this.setSize(300,500);
        this.getContentPane().setLayout(null);

//        this.getContentPane().setLayout(new FlowLayout());

//        this.getContentPane().setLayout(new GridLayout(1,2));

//        this.getContentPane().setLayout(new BorderLayout());

//        this.getContentPane().setLayout(new GridBagLayout());

        this.add(this.getFileRoute(),null);

        this.add(this.getButton(),null);

        this.add(this.getLabel(),null);

        this.add(this.getBox(),null);

        this.setJMenuBar(this.getMenu());

        this.add(this.getSlider(),null);
        this.add(this.getSpinner(),null);
        this.add(this.getToolBar(),null);
        this.setTitle("Xml格式文件数据库导入工具");
    }

    private JToolBar getToolBar(){
        if(toolBar==null){
            toolBar = new JToolBar();
            toolBar.setBounds(103, 260, 71, 20);
            toolBar.setFloatable(true);
        }
        return toolBar;
    }
    private JSpinner getSpinner(){
        if(spinner==null){
            spinner = new JSpinner();
            spinner.setBounds(103, 220, 80, 20);
            spinner.setValue(100);
        }
        return spinner;
    }
    private JSlider getSlider(){
        if(slider==null){
            slider = new JSlider();
            slider.setBounds(103,200,100, 20);
            slider.setMaximum(100);
            slider.setMinimum(0);
            slider.setOrientation(0);
            slider.setValue(0);
        }
        return slider;
    }

    private JMenuBar getMenu(){
        if(menuBar==null){
            menuBar = new JMenuBar();
            JMenu m1 = new JMenu();
            m1.setText("文件");
            JMenu m2 = new JMenu();
            m2.setText("编辑");
            JMenu m3 = new JMenu();
            m3.setText("帮助");

            JMenuItem item11 = new JMenuItem();
            item11.setText("打开");
            JMenuItem item12 = new JMenuItem();
            item12.setText("保存");
            JMenuItem item13 = new JMenuItem();
            item13.setText("退出");

            JMenuItem item21 = new JMenuItem();
            item21.setText("复制");
            JMenuItem item22 = new JMenuItem();
            item22.setText("拷贝");
            JMenuItem item23 = new JMenuItem();
            item23.setText("剪切");

            JMenuItem item31 = new JMenuItem();
            item31.setText("欢迎");
            JMenuItem item32 = new JMenuItem();
            item32.setText("搜索");
            JMenuItem item33 = new JMenuItem();
            item33.setText("版本信息");

            m1.add(item11);
            m1.add(item12);
            m1.add(item13);

            m2.add(item21);
            m2.add(item22);
            m2.add(item23);

            m3.add(item31);
            m3.add(item32);
            m3.add(item33);

            menuBar.add(m1);
            menuBar.add(m2);
            menuBar.add(m3);
        }
        return menuBar;
    }

    private JComboBox getBox(){
        if(comboBox==null){
            comboBox = new JComboBox();
            comboBox.setBounds(103, 140, 71, 27);
            comboBox.addItem("1");
            comboBox.addItem("2");
            comboBox.addActionListener(this);

        }
        return comboBox;
    }

    public JLabel getLabel() {
        if(label==null){
            label = new JLabel();
            label.setBounds(34,49,53,18);  //x y width height
            label.setText("明明");
            label.setToolTipText("标签");
        }
        return label;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    private JButton getButton(){
        if(button==null){
            button = new JButton();
            button.setBounds(103,110,71,27);
            button.setText("OK");
            button.setToolTipText("OK");
            button.addActionListener(this);

        }
        return button;
    }

    /**
     * 文件上传按钮设置
     * 该按钮中设置了事件监听,触发后可进行文件选择
     * @return
     */
    public JButton getUpButton() {

        if(upButton==null){
            upButton = new JButton();
            upButton.setBounds(103,125,112,27);
            button.setText("选择文件");
            button.setToolTipText("选择要上传的文件");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("请选择要上传的文件");
                    //设置文件过滤器
                    fileChooser.setFileFilter(new FileNameExtensionFilter("xml", "csv", "excel", "xls", "xlsx"));
                    int flag = fileChooser.showOpenDialog(null);
                    if(flag == JFileChooser.APPROVE_OPTION){
                        File file = fileChooser.getSelectedFile();
                        fileRoute.setText(file.getAbsolutePath());
                        file = null;
                    }

                }
            });
        }
        return upButton;
    }

    public JTextField getFileRoute() {

        if(fileRoute == null){

            fileRoute = new JTextField();
            fileRoute.setBounds(98,50,160,28);
        }
        return fileRoute;
    }

    /**
     * 事件跟踪
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        System.out.println(o.toString());
    }

}
