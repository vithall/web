package com.PushBox.UI;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;


public class MainFrame extends JFrame implements KeyListener {
    private JLabel lab_wolf;
    private JLabel[][]  sheeps = new JLabel[12][16];
    private int[][]  datas = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,1,1,1,0,0,1,1,1,0,1},
            {1,0,1,0,1,0,0,0,1,0,0,0,0,1,0,1},
            {1,0,1,0,1,0,0,0,1,0,0,1,1,1,0,1},
            {1,0,1,0,0,0,1,1,1,0,0,0,0,1,0,1},
            {1,0,1,0,1,0,0,0,1,0,0,0,0,1,0,1},
            {1,0,1,0,1,0,0,0,1,0,0,1,1,1,0,1},
            {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    };
    private int wx;
    private int wy;
    private int num = 0;//当前有多少个箱子移动到了目标中
    private int total = 3;//箱子的总数
    private MainFrame(){
        wolfInit();
        TargetInit();
        SheepInit();
        treeInit();
        Background();
        setUI();

        this.addKeyListener(this);//键盘监听
    }

    private void setUI(){ //主界面
        this.setLayout(null);
        this.setTitle("推箱子");
        this.setLocation(500,250);
        this.setSize(840,670);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void wolfInit(){ //初始化灰太狼
        wx = 4;
        wy = 5;
        Icon i = new ImageIcon("image/-10.png");
        lab_wolf = new JLabel(i);
        lab_wolf.setBounds(12+wx*50,12+wy*50,50,50);
        this.add(lab_wolf);
    }
    private void treeInit(){ //障碍物
        Icon ic = new ImageIcon("image/1.png");
        for (int i = 0;i<datas.length;i++){
            for (int j = 0;j<datas[i].length;j++){
                if (datas[i][j] == 1){
                    JLabel lab_tree = new JLabel(ic);
                    lab_tree.setBounds(12+50*j,12+50*i,50,50);
                    this.add(lab_tree);
                }
            }
        }
    }
    private void TargetInit(){//笼子
        Icon i = new ImageIcon("image/8.png");
        JLabel lab_target1 = new JLabel(i);
        lab_target1.setBounds(712,212,50,50);
        this.add(lab_target1);
        datas[4][14] = 8;

        Icon j = new ImageIcon("image/8.png");
        JLabel lab_target2 = new JLabel(j);
        lab_target2.setBounds(712,262,50,50);
        this.add(lab_target2);
        datas[5][14] = 8;

        Icon k = new ImageIcon("image/8.png");
        JLabel lab_target3 = new JLabel(k);
        lab_target3.setBounds(712,312,50,50);
        this.add(lab_target3);
        datas[6][14] = 8;
    }

    private void SheepInit(){//小羊
        Icon i = new ImageIcon("image/4.png");
        JLabel lab_sheep1 = new JLabel(i);
        lab_sheep1.setBounds(312,212,50,50);
        this.add(lab_sheep1);
        datas[4][6] = 4; //羊的数组位置
        sheeps[4][6] = lab_sheep1; //放进羊的数组中

        Icon j = new ImageIcon("image/4.png");
        JLabel lab_sheep2 = new JLabel(j);
        lab_sheep2.setBounds(312,312,50,50);
        this.add(lab_sheep2);
        datas[6][6] = 4;
        sheeps[6][6] = lab_sheep2;

        Icon k = new ImageIcon("image/4.png");
        JLabel lab_sheep3 = new JLabel(k);
        lab_sheep3.setBounds(312,412,50,50);
        this.add(lab_sheep3);
        datas[8][6] = 4;
        sheeps[8][6] = lab_sheep3;
    }

    private void Background(){ //背景图
        Icon i = new ImageIcon("image/floor.png");
        JLabel lab_bg = new JLabel(i);
        lab_bg.setBounds(12,12,800,600);
        this.add(lab_bg);
    }
    public void keyPressed(KeyEvent e){

    }
    public void keyReleased(KeyEvent e){ //监听键盘的输入,灰太狼作出反应（松开按键判定）
        int key = e.getKeyCode();        //灰太狼移动

        if (key == 37){                                //左移
            if (datas[wy][wx-1]==1){
                return;
            }
            if (datas[wy][wx-1] == 4 && datas[wy][wx-2] == 1){
                return;
            }
            if (datas[wy][wx-1] == 4 && datas[wy][wx-2] == 4){
                return;
            }
            if (datas[wy][wx-1] == 4 && datas[wy][wx-2] == 12){
                return;
            }
            if (datas[wy][wx-1] == 12 && datas[wy][wx-2] == 1){
                return;
            }
            if (datas[wy][wx-1] == 12 && datas[wy][wx-2] == 4){
                return;
            }
            if (datas[wy][wx-1] == 12 && datas[wy][wx-2] == 12){
                return;
            }
            if (datas[wy][wx-1]==0  || datas[wy][wx-1]==8){//正常移动
                wx = wx - 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x-50,y);
                Icon i = new ImageIcon("image/01.png");
                lab_wolf.setIcon(i);
                return;
            }
            if (datas[wy][wx-1]==4 && datas[wy][wx-2]==0){ //左方是小羊，小羊左方是空地
                sheeps[wy][wx-1].setLocation(12+wx*50-100,12+wy*50); //小羊向左方移动一位
                sheeps[wy][wx-2] = sheeps[wy][wx-1];
                sheeps[wy][wx-1] = null; //小羊原位置清空
                datas[wy][wx-1] = 0; //改变数组中的属性
                datas[wy][wx-2] = 4; //改变数组中的属性

                wx = wx - 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x-50,y);
                Icon i = new ImageIcon("image/01.png");
                lab_wolf.setIcon(i);
                win();
                return;
            }
            if (datas[wy][wx-1]==4 && datas[wy][wx-2]==8){ //左方是小羊，小羊左方是笼子
                sheeps[wy][wx-1].setLocation(12+wx*50-100,12+wy*50); //小羊向左方移动一位
                sheeps[wy][wx-2] = sheeps[wy][wx-1];
                sheeps[wy][wx-1] = null; //小羊原位置清空
                datas[wy][wx-1] = 0; //改变数组中的属性
                datas[wy][wx-2] = 12; //改变数组中的属性
                num++;


                wx = wx - 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x-50,y);
                Icon i = new ImageIcon("image/01.png");
                lab_wolf.setIcon(i);
                Icon i2 = new ImageIcon("image/40.png"); //改变羊的图片
                sheeps[wy][wx-1].setIcon(i2);
                win();
                return;
            }
            if (datas[wy][wx-1]==12 && datas[wy][wx-2]==0){ //左方是小羊在笼子里，笼子左方是空地
                sheeps[wy][wx-1].setLocation(12+wx*50-100,12+wy*50); //小羊向左方移动一位
                sheeps[wy][wx-2] = sheeps[wy][wx-1];
                sheeps[wy][wx-1] = null; //小羊原位置清空
                datas[wy][wx-1] = 8; //改变数组中的属性
                datas[wy][wx-2] = 4; //改变数组中的属性
                num--;

                wx = wx - 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x-50,y);
                Icon i = new ImageIcon("image/01.png");
                lab_wolf.setIcon(i);
                Icon i2 = new ImageIcon("image/4.png"); //改变羊的图片
                sheeps[wy][wx-1].setIcon(i2);
                win();
                return;
            }
            if (datas[wy][wx-1]==12 && datas[wy][wx-2]==8){ //左方是小羊在笼子里，笼子左方是笼子
                sheeps[wy][wx-1].setLocation(12+wx*50-100,12+wy*50); //小羊向左方移动一位
                sheeps[wy][wx-2] = sheeps[wy][wx-1];
                sheeps[wy][wx-1] = null; //小羊原位置清空
                datas[wy][wx-1] = 8; //改变数组中的属性
                datas[wy][wx-2] = 12; //改变数组中的属性

                wx = wx - 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x-50,y);
                Icon i = new ImageIcon("image/01.png");
                lab_wolf.setIcon(i);
                Icon i2 = new ImageIcon("image/40.png"); //改变羊的图片
                sheeps[wy][wx-1].setIcon(i2);
                win();
            }

        }
        else if(key == 38){                                 //上移

            if (datas[wy-1][wx]==1){ //上方有障碍物
                return;
            }
            if (datas[wy-1][wx] == 4 && datas[wy-2][wx] == 1){
                return;
            }
            if (datas[wy-1][wx] == 4 && datas[wy-2][wx] == 4){
                return;
            }
            if (datas[wy-1][wx] == 4 && datas[wy-2][wx] == 12){
                return;
            }
            if (datas[wy-1][wx] == 12 && datas[wy-2][wx] == 1){
                return;
            }
            if (datas[wy-1][wx] == 12 && datas[wy-2][wx] == 4){
                return;
            }
            if (datas[wy-1][wx] == 12 && datas[wy-2][wx] == 12){
                return;
            }
            if (datas[wy-1][wx]==0 || datas[wy-1][wx] == 8){ //正常移动
                wy = wy - 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x,y-50);
                Icon i = new ImageIcon("image/10.png");
                lab_wolf.setIcon(i);
                win();
                return;
            }
            if (datas[wy-1][wx]==4 && datas[wy-2][wx]==0){//上方是小羊，小羊上方是空地
                sheeps[wy-1][wx].setLocation(12+wx*50,12+wy*50-100); //小羊向上方移动一位
                sheeps[wy-2][wx] = sheeps[wy-1][wx];
                sheeps[wy-1][wx] = null; //小羊原位置清空
                datas[wy-1][wx] = 0; //改变数组中的属性
                datas[wy-2][wx] = 4; //改变数组中的属性

                wy = wy - 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x,y-50);
                Icon i = new ImageIcon("image/10.png");
                lab_wolf.setIcon(i);
                win();
                return;
            }
            if (datas[wy-1][wx] == 4 && datas[wy-2][wx] == 8){ //上方是小羊，小羊上方是笼子
                sheeps[wy-1][wx].setLocation(12+wx*50, 12+wy*50-100); //小羊向上方移动一位
                //箱子在地图上移动
                sheeps[wy-2][wx] = sheeps[wy-1][wx];
                //箱子原位置清空
                sheeps[wy-1][wx] = null;
                datas[wy-1][wx] = 0;
                datas[wy-2][wx] = 12;
                num++;

                wy = wy - 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x,y-50);
                Icon i = new ImageIcon("image/10.png"); //改变狼的图片
                lab_wolf.setIcon(i);
                Icon i2 = new ImageIcon("image/40.png"); //改变羊的图片
                sheeps[wy-1][wx].setIcon(i2);
                win();
                return;
            }
            if (datas[wy-1][wx] == 12 && datas[wy-2][wx] == 0){ //上方是小羊在笼子里，笼子上方是空地
                sheeps[wy-1][wx].setLocation(12+wx*50, 12+wy*50-100); //小羊向上方移动一位
                sheeps[wy-2][wx] = sheeps[wy-1][wx];
                sheeps[wy-1][wx] = null;
                datas[wy-1][wx] = 8;
                datas[wy-2][wx] = 4;
                num--;

                wy = wy - 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x,y-50);
                Icon i = new ImageIcon("image/10.png");
                lab_wolf.setIcon(i);
                Icon i2 = new ImageIcon("image/4.png"); //改变羊的图片
                sheeps[wy-1][wx].setIcon(i2);
                win();
                return;
            }
            if (datas[wy-1][wx] == 12 && datas[wy-2][wx] == 8){ //上方是小羊在笼子里，笼子上方是笼子
                sheeps[wy-1][wx].setLocation(12+wx*50, 12+wy*50-100); //小羊向上方移动一位
                sheeps[wy-2][wx] = sheeps[wy-1][wx];
                sheeps[wy-1][wx] = null;
                datas[wy-1][wx] = 8;
                datas[wy-2][wx] = 12;

                wy = wy - 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x,y-50);
                Icon i = new ImageIcon("image/10.png");
                lab_wolf.setIcon(i);
                Icon i2 = new ImageIcon("image/40.png"); //改变羊的图片
                sheeps[wy-1][wx].setIcon(i2);
                win();
            }


        }
        else if(key == 39){                             //右移
            if (datas[wy][wx+1]==1){
                return;
            }
            if (datas[wy][wx+1] == 4 && datas[wy][wx+2] == 1){
                return;
            }
            if (datas[wy][wx+1] == 4 && datas[wy][wx+2] == 4){
                return;
            }
            if (datas[wy][wx+1] == 4 && datas[wy][wx+2] == 12){
                return;
            }
            if (datas[wy][wx+1] == 12 && datas[wy][wx+2] == 1){
                return;
            }
            if (datas[wy][wx+1] == 12 && datas[wy][wx+2] == 4){
                return;
            }
            if (datas[wy][wx+1] == 12 && datas[wy][wx+2] == 12){
                return;
            }
            if (datas[wy][wx+1]==0 || datas[wy][wx+1]==8) {//正常移动
                wx = wx + 1;
                int x = (int) lab_wolf.getLocation().getX();
                int y = (int) lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x+50, y);
                Icon i = new ImageIcon("image/0-1.png");
                lab_wolf.setIcon(i);
                win();
                return;
            }
            if (datas[wy][wx+1]==4 && datas[wy][wx+2]==0){ //右方是小羊，小羊右方是空地
                sheeps[wy][wx+1].setLocation(12+wx*50+100,12+wy*50); //小羊向右方移动一位
                sheeps[wy][wx+2] = sheeps[wy][wx+1];
                sheeps[wy][wx+1] = null; //小羊原位置清空
                datas[wy][wx+1] = 0; //改变数组中的属性
                datas[wy][wx+2] = 4; //改变数组中的属性

                wx = wx + 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x+50,y);
                Icon i = new ImageIcon("image/0-1.png");
                lab_wolf.setIcon(i);
                win();
                return;
            }
            if (datas[wy][wx+1]==4 && datas[wy][wx+2]==8){ //右方是小羊，小羊右方是笼子
                sheeps[wy][wx+1].setLocation(12+wx*50+100,12+wy*50); //小羊向右方移动一位
                sheeps[wy][wx+2] = sheeps[wy][wx+1];
                sheeps[wy][wx+1] = null; //小羊原位置清空
                datas[wy][wx+1] = 0; //改变数组中的属性
                datas[wy][wx+2] = 12; //改变数组中的属性
                num++;

                wx = wx + 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x+50,y);
                Icon i = new ImageIcon("image/0-1.png");
                lab_wolf.setIcon(i);
                Icon i2 = new ImageIcon("image/40.png"); //改变羊的图片
                sheeps[wy][wx+1].setIcon(i2);
                win();
                return;
            }
            if (datas[wy][wx+1]==12 && datas[wy][wx+2]==0){  //右方是小羊在笼子里，笼子右方是空地
                sheeps[wy][wx+1].setLocation(12+wx*50+100,12+wy*50); //小羊向右方移动一位
                sheeps[wy][wx+2] = sheeps[wy][wx+1];
                sheeps[wy][wx+1] = null; //小羊原位置清空
                datas[wy][wx+1] = 8; //改变数组中的属性
                datas[wy][wx+2] = 4; //改变数组中的属性
                num--;

                wx = wx + 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x+50,y);
                Icon i = new ImageIcon("image/0-1.png");
                lab_wolf.setIcon(i);
                Icon i2 = new ImageIcon("image/4.png"); //改变羊的图片
                sheeps[wy][wx+1].setIcon(i2);
                win();
                return;
            }
            if (datas[wy][wx+1]==12 && datas[wy][wx+2]==8){  //右方是小羊在笼子里，笼子右方是笼子
                sheeps[wy][wx+1].setLocation(12+wx*50+100,12+wy*50); //小羊向右方移动一位
                sheeps[wy][wx+2] = sheeps[wy][wx+1];
                sheeps[wy][wx+1] = null; //小羊原位置清空
                datas[wy][wx+1] = 8; //改变数组中的属性
                datas[wy][wx+2] = 12; //改变数组中的属性

                wx = wx + 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x+50,y);
                Icon i = new ImageIcon("image/0-1.png");
                lab_wolf.setIcon(i);
                Icon i2 = new ImageIcon("image/40.png"); //改变羊的图片
                sheeps[wy][wx+1].setIcon(i2);
                win();
            }
        }
        else if(key == 40){                              //下移
            if (datas[wy+1][wx]==1){
                return;
            }
            if (datas[wy+1][wx] == 4 && datas[wy+2][wx] == 1){
                return;
            }
            if (datas[wy+1][wx] == 4 && datas[wy+2][wx] == 4){
                return;
            }
            if (datas[wy+1][wx] == 4 && datas[wy+2][wx] == 12){
                return;
            }
            if (datas[wy+1][wx] == 12 && datas[wy+2][wx] == 1){
                return;
            }
            if (datas[wy+1][wx] == 12 && datas[wy+2][wx] == 4){
                return;
            }
            if (datas[wy+1][wx] == 12 && datas[wy+2][wx] == 12){
                return;
            }
            if (datas[wy+1][wx]==0 || datas[wy+1][wx]==8) { //正常移动
                wy = wy + 1;
                int x = (int) lab_wolf.getLocation().getX();
                int y = (int) lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x, y+50);
                Icon i = new ImageIcon("image/-10.png");
                lab_wolf.setIcon(i);
                win();
                return;
            }
            if (datas[wy+1][wx]==4 && datas[wy+2][wx]==0){//下方是小羊，小羊下方是空地
                sheeps[wy+1][wx].setLocation(12+wx*50,12+wy*50+100); //小羊向下方移动一位
                sheeps[wy+2][wx] = sheeps[wy+1][wx];
                sheeps[wy+1][wx] = null; //小羊原位置清空
                datas[wy+1][wx] = 0; //改变数组中的属性
                datas[wy+2][wx] = 4; //改变数组中的属性

                wy = wy + 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x,y+50);
                Icon i = new ImageIcon("image/-10.png");
                lab_wolf.setIcon(i);
                win();
                return;
            }
            if (datas[wy+1][wx]==4 && datas[wy+2][wx]==8){ //下方是小羊，小羊下方是笼子
                sheeps[wy+1][wx].setLocation(12+wx*50,12+wy*50+100); //小羊向下方移动一位
                sheeps[wy+2][wx] = sheeps[wy+1][wx];
                sheeps[wy+1][wx] = null; //小羊原位置清空
                datas[wy+1][wx] = 0; //改变数组中的属性
                datas[wy+2][wx] = 12; //改变数组中的属性
                num++;

                wy = wy + 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x,y+50);
                Icon i = new ImageIcon("image/-10.png");
                lab_wolf.setIcon(i);
                Icon i2 = new ImageIcon("image/40.png"); //改变羊的图片
                sheeps[wy+1][wx].setIcon(i2);
                win();
                return;
            }
            if (datas[wy+1][wx]==12 && datas[wy+2][wx]==0){ //下方是小羊在笼子里，笼子下方是空地
                sheeps[wy+1][wx].setLocation(12+wx*50,12+wy*50+100); //小羊向下方移动一位
                sheeps[wy+2][wx] = sheeps[wy+1][wx];
                sheeps[wy+1][wx] = null; //小羊原位置清空
                datas[wy+1][wx] = 8; //改变数组中的属性
                datas[wy+2][wx] = 4; //改变数组中的属性
                num--;

                wy = wy + 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x,y+50);
                Icon i = new ImageIcon("image/-10.png");
                lab_wolf.setIcon(i);
                Icon i2 = new ImageIcon("image/4.png"); //改变羊的图片
                sheeps[wy+1][wx].setIcon(i2);
                win();
                return;
            }
            if (datas[wy+1][wx]==12 && datas[wy+2][wx]==8){ //下方是小羊在笼子里，笼子下方是笼子
                sheeps[wy+1][wx].setLocation(12+wx*50,12+wy*50+100); //小羊向下方移动一位
                sheeps[wy+2][wx] = sheeps[wy+1][wx];
                sheeps[wy+1][wx] = null; //小羊原位置清空
                datas[wy+1][wx] = 8; //改变数组中的属性
                datas[wy+2][wx] = 12; //改变数组中的属性

                wy = wy + 1;
                int x = (int)lab_wolf.getLocation().getX();
                int y = (int)lab_wolf.getLocation().getY();
                lab_wolf.setLocation(x,y+50);
                Icon i = new ImageIcon("image/-10.png");
                lab_wolf.setIcon(i);
                Icon i2 = new ImageIcon("image/40.png"); //改变羊的图片
                sheeps[wy+1][wx].setIcon(i2);
                win();
            }
        }
    }
    public void keyTyped(KeyEvent e){

    }
    private void win(){
        if (total == num){
            this.removeKeyListener(this); //移除窗体键盘事件，避免用户多余操作
            JDialog dialog = new JDialog(this,"屌丝逆袭成功");
            dialog.setSize(450,350);
            dialog.setLocationRelativeTo(null);
            dialog.setLayout(null);

            JLabel goodgame = new JLabel(new ImageIcon("image/gg.jpg"));
            goodgame.setBounds(2,2,400,300);
            dialog.add(goodgame);
            goodgame.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    try {
                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://www.oneplus.cn");
                    }
                    catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }


                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            dialog.setVisible(true);
        }
    }

    public static void main(String[] args){
        new MainFrame();
    }
}