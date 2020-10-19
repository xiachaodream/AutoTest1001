package com.api.study;

public class MyThirdDemo {
    public static void main(String[] args) {
       /**
        * 【作业一】代码编写
        * 打印金字塔
        * *
        * ***
        * *****
        * *******
        * *********
        * */
       int rows=5;
       for(int i=0;i<rows;i++){
           for(int j=0;j<(2*i+1);j++){
               System.out.print("*");
           }
           System.out.println();
       }

        /*一串字符串： sunjavaoraclecodestudentjava
        打印输出 java 出现的次数。*/

        String str="javasunjavajavaoraclecodestudentjava";
        String subStr="java";
        int count=0;
        while (str.indexOf("java")!=-1){
            count++;
            int index = str.indexOf(subStr);
            str=str.substring(index+1,str.length());
        }
        System.out.println(count);


    }
}
