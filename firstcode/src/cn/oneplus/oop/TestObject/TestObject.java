package cn.oneplus.oop.TestObject;

public class TestObject {
    public String toString(){
        return "我是帅比";
    }
    public static void main(String[] args){
        Object obj = new Object();
        Object obj0 = new Object();
        System.out.println(obj.toString());
        System.out.println(obj0.toString());

        TestObject test = new TestObject();
        System.out.println(test.toString());
    }
}
