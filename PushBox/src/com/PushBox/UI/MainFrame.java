package com.PushBox.UI;

import javax.swing.*;


public class MainFrame extends JFrame{
    public MainFrame(){
        Background();
        this.setTitle("推箱子");
        this.setLocation(400,300);
        this.setSize(800,600);
        this.setVisible(true);
    }
    public void Background(){
        Icon i = new ImageIcon("image/floor.png");
        JLabel lab_bg = new JLabel(i);
        lab_bg.setBounds(12,36,800,600);
        this.add(lab_bg);
    }
    public static void main(String[] args){
    }
}