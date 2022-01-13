package com.company;
import java.util.Arrays;

import static java.lang.Math.abs;
public class Main {

    public static void main(String[] args) {
        // 2.1
        System.out.println("1:   " + repeat("readme", 5));
        // 2.2
        System.out.println("2:   " + differenceMaxMin(new int[] {44, 32, 86, 19}));
        // 2.3
        System.out.println("3:   " + isAvgWhole(new int[] {1, 2, 3, 4}));
        // 2.4
        System.out.println("4:   " + Arrays.toString(cumulativeSum(new int[]{3, 3, -2, 408, 3, 3})));
        // 2.5
        System.out.println("5:   " + getDecimalPlaces("43.20"));
        // 2.6
        System.out.println("6:   " + Fibonacci(12));
        // 2.7
        System.out.println("7:   " + isValid("732 32"));
        // 2.8
        System.out.println("8:   " + isStrangePair("", "") );
        // 2.9.1
        System.out.println("9.1: " + isPrefix("retrospect", "sub-"));
        // 2.9.2
        System.out.println("9.2: " + isSuffix("arachnophobia", "-phobia"));
        // 2.10
        System.out.println("10:  " + boxSeq(1));
    }
    //2.1
    public static String  repeat(String x, int y)
    {
        String xx ="";
        for (int i=0;i<x.length();i++){
            for (int n = 1; n <= y; n++) {
                xx = xx + x.charAt(i);
            }
        }
        return xx;
    }
    // 2.2
    public static int differenceMaxMin(int[] mas) {
        int b = mas[0];
        int m = mas[0];
        for (int i: mas) {
            if (i > b)
                b= i;
            else if (i < m)
                m= i;
        }
        return abs(b - m);
    }
    // 2.3
    public static boolean isAvgWhole(int[] mas) {
        int sum = 0;
        int num = 0;
        for (int i: mas) {
            sum += i;
            num++;
        }
        return (sum % num == 0);
    }

    // 2.4
    public static int[] cumulativeSum(int[] mas) {
        int[] z = new int[mas.length];
        int a = 0;
        for (int i = 0; i < mas.length; i++) {
            z[i] = mas[i] + a;
            a += mas[i];
        }
        return z;
    }
    // 2.5
    public static int getDecimalPlaces(String num) {
        if (num.contains("."))
            return num.length()-(num.indexOf(".") + 1);
        else
            return 0;
    }
    // 2.6
    public static int Fibonacci(int a) {
        int x = 0;
        int y = 1;
        for (int i = 2; i <= a; i++) {
            int h = x + y;
            x = y ;
            y = h;
        }
        return y;
    }
    // 2.7
    public static boolean isValid(String ind) {
        return ind.length() == 5 && ind.indexOf(' ') == -1 && ind.matches("[0-9]*");
    }
    // 2.8
    public static boolean isStrangePair(String a, String z) {
        if ((a.length() == 0) && (z.length() == 0))
            return true;
        else
            return (a.charAt(0) == z.charAt(z.length() - 1)) && (a.charAt(a.length() - 1) == z.charAt(0));
    }

    // Девятая задача часть 1
    public static boolean isPrefix(String word, String prefix) {
        String new_prefix = prefix.replace("-", "");
        String new_word = "";
        for (int i = 0; i < new_prefix.length(); i++)
            new_word = new_word + word.charAt(i);
        return new_word.equals(new_prefix);
    }

    // 2.9
    public static boolean isSuffix(String word, String suffix) {
        String new_suffix = suffix.replace("-", "");
        String new_word = "";
        for (int i = new_suffix.length(); i > 0; i--)
            new_word = new_word + word.charAt(word.length() - i);
        return new_word.equals(new_suffix);
    }
    // 2.10
    public static int boxSeq(int a) {
        int b=0;
        int s=0;
        if (a==0)
            return 0;
        for (int i = 1; i <= a; i++) {
            if (i % 2 == 0)
                b=b+1;
            else s=s+1;
        }
        return s*3-b;
    }
}

