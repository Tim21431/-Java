package com.company;
import java.util.Arrays;
import static java.lang.Math.abs;
public class Main {
    public static void main(String[] args) {
        // 3.1
        System.out.println("1: " + solutions(1, 0, -1));
        //3.2
        System.out.println("2:  " + findZip("all zip files ae compsed"));
        //3.3
        System.out.println("3:  " + checkPerfect(28));
        //3.4
        System.out.println("4:  " + flipEndChars("Cat, dog, and mouse."));
        //3.5
        System.out.println("5:  " + isValidHexCode("#CD5C5C"));
        //3.6
        int[] mas1 = {1, 3, 4, 4, 4};
        int[] mas2 = {2, 5, 7};
        System.out.println("6:   " + same(mas1, mas2));
        //3.7
        System.out.println("7:  " + isKaprekar(2));
        //3.8
        System.out.println("8:  " + longestZero("01110000100"));
        //3.9
        System.out.println("9:  " + nextPrime(24));
        //3.10
        System.out.println("10:  " + rightTriangle(145, 105, 100));
    }
    // 3.1
    public static int solutions(double a, double b, double c) {
        double D = Math.pow(b, 2) - 4 * a * c;
        if (D < 0) {
            return 0;
        } else if (D == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    //3.2
    public static int findZip(String S) {
        String str = "zip";
        int x = (S.indexOf(str));
        int y = (S.indexOf(str, x + 1));
        return y;
    }

    // 3,3
    public static boolean checkPerfect(int x) {
        int y = 0;
        for (int i = 1; i < x; i++) {
            if (x % i == 0) {
                y = y + i;
            }
        }
        return x == y;
    }

    //3.4
    public static String flipEndChars(String string) {

        if (string.length() < 2) {
            return "Incompatible.";
        } else if (string.charAt(0) == string.charAt(string.length() - 1)) {
            return "Two's a pair.";
        } else {
            char[] stroka = string.toCharArray();
            char symbol = stroka[0];
            stroka[0] = stroka[stroka.length - 1];
            stroka[stroka.length - 1] = symbol;
            return new String(stroka);
        }

    }

    //3.5
    public static boolean isValidHexCode(String code) {
        char a = '#';
        if (code.length() == 7 && code.charAt(0) == a && code.matches("#[0-9a-fA-F]+")) {
            return true;
        } else {
            return false;
        }
    }

    //3.6
    public static boolean same(int[] mas1, int[] mas2) {
        int k = 0;
        int n = 0;
        for (int i = 0; i < mas1.length; i++) {
            for (int j = i + 1; j < mas1.length; j++) {
                if (mas1[i] != mas1[j]) j++;
                else {
                    n = n + 1;
                    i++;
                }
            }
        }
        for (int i = 0; i < mas2.length; i++) {
            for (int j = i + 1; j < mas2.length; j++) {
                if (mas2[i] != mas2[j]) j++;
                else {
                    k = k + 1;
                    i++;
                }
            }
        }
        int d = mas1.length - n;
        int b = mas2.length - k;
        return d == b;
    }

    //3.7
    public static boolean isKaprekar(int num) {
        if (num == 1 || num == 0)
            return true;
        int t = num * num;
        int d = 0;
        while (t != 0) {
            d++;
            t /= 10;
        }
        t = num * num;
        for (int i = 1; i < d; i++) {
            int n = (int) Math.pow(10, i);
            int s = t / n;
            int m = t % n;
            int sum = s + m;
            if (sum == num && (m > s || m == s))
                return true;
        }
        return false;
    }

    //3.8
    public static String longestZero(String num) {

        int a = 0;
        int b = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                a++;
                if (a > b) {
                    b = a;
                    i++;
                }
            } else {
                a = 0;
            }
        }
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < b; i++) {
            str.insert(i, '0');
        }

        return new String(str);
    }

    //3.9
    public static int nextPrime(int h) {
        int k = 0;
        int v = 0;
        for (int i = 2; i < h; i++) {
            if (h % i == 0) {
                k = 1;
                i = h;
            }
        }
        if (k == 0) {
            return h;
        } else {
            while (v != 1) {
                h = h + 1;
                for (int i = 2; i < h; i++) {
                    if (h % i == 0) {
                        i = h;
                    } else {
                        if (h - i == 1)
                            v = 1;
                    }
                }
            }
        }
        return h;
    }

    //3.10
    public static boolean rightTriangle(int h, int a, int b) {
        if (a > b && a > h) {
            return a * a == b * b + h * h;
        } else if (b > a && b > h) {
            return b * b == a * a + h * h;
        } else if (h > b && h > a) {
            return h * h == b * b + a * a;
        } else {
            return false;
        }
    }
}