import java.util.Scanner;

/**
 * 计算1分到100元人民币的张数
 * @author vit
 */
public class rmb {
    public static void main(String [] args){
        float rmb;
        double i;
        int h,fifty,twenty,ten,five,one,fcor,tcor,ocor,fcent,tcent,ocent;
        Scanner scan = new Scanner(System.in);
        System.out.println("输入一个金额：");
        rmb = scan.nextFloat();

        h = (int) (rmb / 100);
        i = rmb % 100;
        if(h!=0){
            System.out.println("100元" +h+"个");
        }else{}

        fifty = (int) (i / 50);
        i = i % 50;
        if(fifty!=0){
            System.out.println("50元" +fifty+"个");}
        else{}
        twenty = (int) (i / 20);
        i = i % 20;
        if(twenty!=0){
            System.out.println("20元" +twenty+"个");}
        else{}
        ten = (int) (i / 10);
        i = i % 10;
        if(ten!=0){
            System.out.println("10元" +ten+"个");}
        else{}
        five = (int) (i / 5);
        i = i % 5;
        if(five!=0){
            System.out.println("5元" +five+"个");}
        else{}
        one = (int) (i / 1);
        i = i % 1;
        if(one!=0){
            System.out.println("1元" +one+"个");}
        else{}
        fcor = (int) (i / 0.5);
        i = i % 0.5;
        if(fcor!=0){
            System.out.println("5角" +fcor+"个");}
        else{}
        tcor=(int) (i/0.2);
        i=i%0.2;
        if(tcor!=0){
            System.out.println("2角" +tcor+"个");}
        else{}
        ocor=(int) (i/0.1);
        i=i%0.1;
        if(ocor!=0){
            System.out.println("1角" +ocor+"个");}
        else{}
        fcent=(int) (i/0.05);
        i=i%0.05;
        if(fcent!=0){
            System.out.println("5分" +fcent+"个");}
        else{}
        tcent=(int) (i/0.02);
        i=i%0.02;
        if(tcent!=0){
            System.out.println("2分" +tcent+"个");}
        else{}
        ocent=(int) (i/0.01);
        i=i%0.01;
        if(ocent!=0){
            System.out.println("1分" +ocent+"个");}
        else{}
    }
}