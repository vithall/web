import java.util.*;
import java.io.*;
import java.util.Date;
import java.text.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar.*;

/**
 *  做一个日历
 *
 */
public class MyCalender extends GregorianCalendar {
    void showCalender(int month) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int date = c.get(Calendar.DATE);
        c = new GregorianCalendar(year, month - 1, date);
        if ( (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && month == 2) {
            days[1]++;
        } //end if
        System.out.println("--------calendar:" + year + "-" + month + "------\n");
        System.out.println(" 日   一  二  三  四  五  六 ");
        c.set(DATE, 1);
        int first = c.get(Calendar.DAY_OF_WEEK);
        int i;
        for (i = 1; i < first; i++) {
            System.out.print("    "); //四个空格
        }
        for (i = 1; i <= days[month - 1]; i++) {
            if (i < 10) {
                System.out.print(" ");
            }
            System.out.print(" " + i);
            System.out.print(" ");
            if (first++ % 7 == 0) {
                System.out.println("");
            }
        } //end for
        System.out.println();
    } //end void showCalender(int month)

    String getDay(int month, int date) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        c = new GregorianCalendar(year, month - 1, date);
        int day = c.get(Calendar.DAY_OF_WEEK);
        String reday = "";
        switch (day) {
            case 1: {
                reday = "星期日";
                break;
            } //end case 1
            case 2: {
                reday = "星期一";
                break;
            } //end case 2
            case 3: {
                reday = "星期二";
                break;
            } //end case 3
            case 4: {
                reday = "星期三";
                break;
            } //end case 4
            case 5: {
                reday = "星期四";
                break;
            } //end case 5
            case 6: {
                reday = "星期五";
                break;
            } //end case 6
            default: {
                reday = "星期六";
            } //end deault
        } //end switch()
        return reday;
    } //end String getDay(int month,int date)

    int diffDate(java.util.Date date1, java.util.Date date2) {

        System.out.print(date1.getYear() + "-");
        System.out.print(date1.getMonth() + "-");
        System.out.println(date1.getDay());
        System.out.print(date2.getYear() + "-");
        System.out.print(date2.getMonth() + "-");
        System.out.println(date2.getDay());
        return Math.abs( (int) ( (date1.getTime() - date2.getTime()) /
                (24 * 3600 * 1000)));
    } //end int diffDate()
    int inputNum() { //输入选项号
        int pm = 0;
        try {
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader input = new BufferedReader(reader);
            pm = Integer.parseInt(input.readLine());
        } //end try
        catch (NumberFormatException e) {
            System.out.println(e);
        } //end catch
        catch (IOException e) {
            System.out.println(e);
        } //end catch
        return pm;
    } //end int inputNum()
    String inputDate() { //输入日期
        String pm = "";
        try {
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader input = new BufferedReader(reader);
            pm = input.readLine();
        } //end try
        catch (IOException e) {
            System.out.println(e);
        } //end catch
        return pm;
    } //end int inputNum()


    public static void main(String[] args) {
        MyCalender mc = new MyCalender();
        int count = 1;
        int mon, date2;
        boolean flag = true;
        while (count != 0) {
            System.out.print("请从一下几项选择一个 :(1,2,3,0)\n");
            System.out.print("1.显示今年你指定的某个月日历\n");
            System.out.print("2.显示指定的某月某日是星期几\n");
            System.out.print("3.计算指定的两天的天数的差\n");
            System.out.print("0.退出 \n");
            count = mc.inputNum();
            switch (count) {
                case 1: {
                    System.out.print("输入月份(1-12):");
                    mon = mc.inputNum();
                    if (mon <= 12 && mon > 0) {
                        System.out.println(mon);
                        mc.showCalender(mon);
                    } //end if
                    else {
                        System.out.println("月份输入有误！");
                    }
                    break;
                } //end case 1
                case 2: {
                    System.out.print("输入月份 :");
                    mon = mc.inputNum();
                    System.out.print("输入日期 :");
                    date2 = mc.inputNum();
                    System.out.println(mc.getDay(mon, date2));
                    System.out.println();
                    break;
                } //end case 2
                case 3: {
                    java.util.Date mydate1 = new java.util.Date();
                    java.util.Date mydate2 = new java.util.Date();
                    java.text.DateFormat myFormatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
                    try {
                        System.out.print("输入 date1 (格式:year-month-day):");
                        String d1 = mc.inputDate();
                        System.out.print("输入 date2 (格式:year-month-day):");
                        String d2 = mc.inputDate();
                        mydate1 = myFormatter.parse(d1);
                        mydate2 = myFormatter.parse(d2);
                    } //end try
                    catch (ParseException e) {
                        System.out.println(e);
                    } //end catch
                    System.out.println("以上两个日期相差 " + mc.diffDate(mydate1, mydate2) + " 天");
                    break;
                } //end case 3
                case 0: {
                    System.out.println("退出！");
                    System.exit(0);
                } //end case 0
                default: {
                    break;
                } //end default
            } //end switch
        } //end while
    } //end main()
} //end public class MyCalender
