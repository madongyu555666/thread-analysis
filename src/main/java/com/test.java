package com;

/**
 * @author madongyu
 * @projectName ems.git
 * @description: TODO
 * @date 2019/6/1513:56
 */
public class test {

    public static void main(String[] args) {
        String objectextent1 = "depart|inner_90&inner_82808";
        String objectextent2 = "depart|inner_90&inner_80862&inner_82808";



     /*   String[] split = objectextent1.split("&");
        for (int i=0;i<split.length;i++){
            String[] s = split[i].split("_");


            String[] split2 = objectextent2.split("&");
            for (int j=0;j<split2.length;j++){
                String[] s1 = split2[j].split("_");
                System.out.println("s---"+s[0]+"---"+s[1]);
                System.out.println("s1----"+s1[0]+"---"+s1[1]);
                if(!s[1].equals(s1[1])){
                    System.out.println(s1[1]);
                }
            }
        }*/


        /*String[] split2 = objectextent2.split("&");
        for (int i=0;i<split2.length;i++){
            String[] s = split2[i].split("_");
            System.out.println(s[1]);
        }*/



        /*int length = objectextent1.length();
        String substring = objectextent2.substring(length+1, objectextent2.length());
        String[] split = substring.split("&");
        for (int i=0;i<split.length;i++){
            String[] s = split[i].split("_");
            System.out.println(s[1]);
        }*/
    }
}
