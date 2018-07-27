package cn.oneplus.oop.inherit;

public class Animals { //main类
    public static void main( String[] args){
        Animal a = new Mammals(); //多态
        a.run();
        Mammals mammals = new Mammals();
        Reptile reptile = new Reptile();
        Bird bird = new Bird();
        mammals.viviparity();
        mammals.run();
        reptile.oviparity();
        bird.run();
        bird.eat();
    }
}
