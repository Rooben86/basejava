package com.urise.webapp;

public class MainString {

    public static void main(String[] args) {
        String[] strArray = new String[]{"1","2","3","4","5"};
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str).append(",");
        }
        System.out.println(sb);

        String str1 = "abc";
        String str2 = "c";
        //String str3 = ("ab" + str2).intern();
        String str3 = ("ab" + str2);
        System.out.println(str3.equals(str1));
    }
}
