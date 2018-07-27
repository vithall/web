import java.io.*;

/**
 *  计算人民币的张数
 *
 */
class Moneycout {
    public static void main(String[] args) {
        int[]val={100,50,20,10,5,2,1};
        int count;
        int[]num=new int[7];
        int asval=0;
        System.out.println("请输入人民币币值（以分计）");
        try{
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader input = new BufferedReader(reader);
            asval=Integer.parseInt(input.readLine());
        }//end try
        catch(NumberFormatException e){
            System.out.println("输入有误");
        }
        catch(IOException e){
            e.printStackTrace();
        }//end catch
        if(asval!=0){
            int reval=asval;
            for(int i=0;i<7;i++){
                num[i]=asval/val[i];
                asval=asval%val[i];
            }//end for
            System.out.println("输入的人民币币值是 "+reval);
            for (int i = 0; i < 7; i++) {
                if(num[i] != 0) {
                    System.out.println(val[i] + "分的个数：" + num[i]);
                }//end if
            }//end for
        }//end if
    }//end main
}//end public class Moneycout
