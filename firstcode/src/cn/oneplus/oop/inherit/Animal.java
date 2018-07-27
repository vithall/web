package cn.oneplus.oop.inherit;

public class Animal { //动物(主类)
    String eye;
    public void run(){
        System.out.println("跑");
    }
    public void  eat(){
        System.out.println("吃");
    }
    public Animal(){
    }
}

class Mammals extends Animal{ //哺乳动物
    public void run(){
        System.out.println("跑啊跑");
    }
        public void viviparity(){
        System.out.println("我是胎生的");
    }

}
class Reptile extends Animal{ //爬行动物
    public void oviparity(){
        System.out.println("我是卵生的");
    }
}
class Bird extends Animal{ //鸟类
    public void run(){ //重写
        System.out.println("我不会跑，我可以飞");
    } //重写
    public void fly(){
        System.out.println("飞");
    }
}
