
public class Netease { // 计算100以内奇数和与偶数和


    /**
     * 输入一个数，计算奇数和以及偶数和
     * param a 最大数 oddsum 奇数和 evensum 偶数和
     * return 偶数和、奇数和
     */
    public static void OddEven(int a){
        int oddsum = 0; //奇数和
        int evensum = 0; //偶数和
        for(int i = 0;i <= a;i++){
            if(i % 2 == 0){
                oddsum = oddsum + i;
            }else{
                evensum = evensum + i;
            }
        }
        System.out.println("偶数和为"+evensum);
        System.out.println("奇数和为"+oddsum);
    }

    public static int Add(int a, int b){ //“a、b”为形式参数
        int  sum = a + b;
        System.out.println("sum="+sum);
        return sum;
    }

    //static int num = 4;
    public static void Recursion(int num) { //递归方法（Recursion）
        System.out.print("抱着");
        if (num == 1) {
            System.out.print("我的小鲤鱼");
        } else {
            Recursion(--num);
        }
        System.out.print("的我");
    }

    public static void main(String[] args){
        OddEven(120); //直接调用奇数和方法（函数）
        //System.out.println("sum="+Add(7,9)); //手动输入值进行调用
                                               // 后面输入的“7、9”是实际参数
        Add(7,8);
        System.out.println("吓得我赶紧抱起了");
        Recursion(3);
    }
}