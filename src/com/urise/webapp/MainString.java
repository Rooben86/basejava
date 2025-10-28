package com.urise.webapp;

public class MainString {
    public static void main(String[] args) {
        String[] strArr = new String[]{"1", "2", "3", "4", "5"};
//        String result = "";
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str).append(", ");
        }
        System.out.println(sb);

        String str1 = "abc";
        String str3 = "c";
        String str2 = ("ab" + str3).intern();
        System.out.println(str1 == str2);

        char[] chardata = {'h','e','l','l','o','.'};
        String str4 = new String(chardata);
        System.out.println(str4);
    }
}
