package com.api.study;

public class MySecondDemo {
    public static void main(String[] args) {
        /*【作业一】代码编写
        字符串分割后做加法运算。
        其中，字符串为 1234；
        运算表达式 为 1+2+3+4*/
        String str="1234";
        String express="";
        int total = 0;
        for(int i=0;i<str.length();i++){
            if(i!=str.length()-1){
                express=express+str.substring(i,i+1)+"+";
            }else {
                express=express+str.substring(i,i+1);
            }
            total+=Integer.parseInt(str.substring(i,i+1));
        }
        System.out.println(express+"="+total);

//        【作业二】代码编写
//        根据月份（1,2,3，......，10,11,12），输出季节（3 4 5春季、6 7 8夏季、9 10 11秋季、12 1 2冬季）
        int month=12;
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println(month + "月份是冬天");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println(month + "月份是春天");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println(month + "月份是夏天");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println(month + "月份是秋天");
                break;
            default:
                System.out.println("不合法的输入");
        }

        /*【作业三】代码编写
        使用while循环语句。
        学号1到50同学，打印输出 学号：你真棒，例如 学号：1，你真棒！
        全部同学，打印输出 全体同学，聪明不绝"顶"*/
        int num=1;
        while (num<=50){
            System.out.printf("学号：%d，你真棒！",num);
            System.out.println();
            num++;
        }
        System.out.println("全体同学，聪明不绝\"顶\"");
    }
}
