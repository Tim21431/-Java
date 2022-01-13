package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //4.1
        System.out.println("1:  " + essay(10, 7, "hello my name is Bessie and this is my essay"));
        //4.2
        System.out.println("2:  " + Arrays.toString(split("()()()")));
        //4.3.1
        System.out.println("3.1:  " +toSnakeCase("helloEdabit"));
        //4.3.2
        System.out.println("3.2:  " +toCamelCase("hello_edabit"));
        //4.4
        double[] mas3 = {13.25, 15, 30, 1.5};
        System.out.println("4:  " + overTime(mas3));
        //4.5
        System.out.println("5:  " + BMI("154 pounds", "2 meters"));
        //4.6
        System.out.println("6:  " + bugger(729));
        // 4.7
        System.out.println("7: " + toStarShorthand("aaabbbccco"));
        // 4.8
        System.out.println("8: " + doesRhyme("Sam I amo!", "Jek I aro ."));
        // 4.9
        System.out.println("9: " + trouble("451999277", "411772289"));
        // 4.10
        System.out.println("10: " + countUniqueBooks("ZZABCDEF", "Z"));
    }
    //4.1
    public static String essay(int n, int k, String str) {
        String[] word = str.split(" ");
        String currentString = "";
        String res = "";
        if ((n > 100) || ((n & k) < 1) || (k > 80))
            return "ERROR";
        for (int i = 0; i < word.length; i++) {
            String w = word[i];
            if ((w.length() > 15) || (w.length() < 1))
                return "ERROR";
            if (currentString.replace(" ", "").length() + w.length() <= k)
                currentString += w + " ";
            else {
                res += currentString + "\n";
                currentString = w + " ";
            }
        }
        if (currentString.length() > 0) {
            res += currentString + "\n";
        }
        return res;

    }

    //4.2
    public static String[] split(String str) {
        List<String> list = new ArrayList<>();
        int count = 0;
        int lastIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                list.add(str.substring(lastIndex, i + 1));
                lastIndex = i + 1;
            }
        }
        String[] strs = new String[list.size()];
        return strs = list.toArray(strs);
    }

    //4.3.1
    public static String toCamelCase(String str) {
        String[] arr = str.split("_");
        String new_str = arr[0];
        for (int i = 1; i < arr.length; i++) {
            new_str += (arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1));
        }
        return new_str;
    }

    //4.3.2
    public static String toSnakeCase(String str) {
        String new_str = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).matches("[A-Z]")) {
                new_str = new_str + "_" + str.substring(i, i + 1).toLowerCase();
            } else {
                new_str += str.substring(i, i + 1);
            }
        }
        return new_str;
    }

    //4.4
    public static String overTime(double[] mas) {
        double zp = 0.0;
        double a = mas[0];
        double b = mas[1];
        if (a <= 24 && b <= 9) {
            b += 24;
        }
        for (double i = mas[0]; i < b; i = i + 0.25) {
            if (i >= 9 && i < 17) {
                zp += 0.25 * mas[2];
            } else if (i >= 17 && i <= 33) {
                zp += 0.25 * mas[2] * mas[3];
            }
        }

        return String.format("$%.2f", zp);

    }

    //4.5
    public static String BMI(String v, String r) {
        String[] ve = v.split(" ");
        String[] ro = r.split(" ");
        String res = "";
        double kilos = 0;
        double meters = 0;

        if (ve[1].equals("pounds")) {
            kilos = Double.parseDouble(ve[0]) * 0.454;
        } else kilos = Double.parseDouble(ve[0]);
        if (ro[1].equals("inches")) {
            meters = Double.parseDouble(ro[0]) * 0.0254;
        } else meters = Double.parseDouble(ro[0]);
        double imt = kilos / (meters * meters);
        imt = Math.round(imt * 10.0) / 10.0;
        if (imt < 18.5) res += imt + " Underweight";
        if (imt >= 18.5 && imt <= 24.5) res += imt + " Normal weight";
        if (imt >= 25 && imt <= 29.9) res += imt + " Overweight";
        if (imt >= 30) res += imt + " Obesity";
        return res;
    }

    //4.6
    public static int bugger(int h) {
        int f = h;
        int o = 1;
        int j = 0;
        List<Integer> arr = new ArrayList<Integer>();
        do {
            arr.add(h % 10);
            h /= 10;
        } while (h > 0);
        {
            if (f > 9) {
                do {
                    o = 1;
                    for (int i = 0; i < arr.size(); i++) {
                        o = arr.get(i) * o;

                    }
                    j = j + 1;
                    arr.clear();
                    h = o;
                    do {
                        arr.add(h % 10);
                        h /= 10;
                    } while (h > 0);
                }
                while (o > 9);
                return j;
            } else {
                return 0;
            }
        }
    }

    //4.7
    public static String toStarShorthand(String s) {
        char[] str1 = s.toCharArray();
        String str2 = "";
        int count = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (str1[i] == str1[i + 1]) {
                count++;
            } else if
            (str1[i - 1] != str1[i] && str1[i] != str1[i + 1]) {
                str2 += str1[i];
            } else {
                str2 += str1[i] + "*" + count;
                count = 1;
            }
        }
        return str2 + str1[s.length() - 1] + "*" + count;
    }

    //4.8
    public static boolean doesRhyme(String str1, String str2) {
        String vowels1 = "";
        String vowels2 = "";
        str1 = str1.replaceAll("\\p{Punct}", "");
        str2 = str2.replaceAll("\\p{Punct}", "");
        String[] arr1 = str1.split(" ");
        String[] arr2 = str2.split(" ");
        int o = arr1.length - 1;
        int a = arr2.length - 1;
        String qwe = arr1[o];
        String ewq = arr2[a];
        for (int i = 0; i < qwe.length(); i++) {
            char q = Character.toLowerCase(qwe.charAt(i));
            if (q == 'a' || q == 'e' || q == 'i' || q == 'o' || q == 'u') {
                vowels1 += q;
            }
        }
        for (int i = 0; i < ewq.length(); i++) {
            char q = Character.toLowerCase(ewq.charAt(i));
            if (q == 'a' || q == 'e' || q == 'i' || q == 'o' || q == 'u') {
                vowels2 += q;
            }
        }

        return vowels1.equals(vowels2);
    }

    //4.9
    public static boolean trouble(String num1, String num2) {
        int count1 = 0;
        int count2 = 0;
        String a = "";
        String b = "";
        for (int i = 0; i < num1.length() - 3; i++) {
            a = String.valueOf(num1.charAt(i));
            if (a.equals(String.valueOf(num1.charAt(i + 1)))
                    && a.equals(String.valueOf(num1.charAt(i + 2)))
                    && !a.equals(String.valueOf(num1.charAt(i + 3))))
                count1 = 3;
        }
        if (count1 == 3) {
            for (int j = 0; j < num2.length() - 1; j++) {
                b = String.valueOf(num2.charAt(j));
                if (a.equals(String.valueOf(num2.charAt(j)))
                        && b.equals(String.valueOf(num2.charAt(j)))
                        && !b.equals(String.valueOf(num2.charAt(j + 1)))) {
                    count2 = 2;
                }
            }
            if (count2 == 2) return true;

        }

        return false;
    }


    //4.10
    public static int countUniqueBooks(String str1, String str2) {
        String s = "";
        int c = 0;
        int in = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                c++;
            }
        }
        for (int j = 0; j < c / 2; j++) {
            in = str1.indexOf(str2, in);// 1 индекс str2
            int next = str1.indexOf(str2, in + 1);//2 индекс str2
            s += str1.substring(in + 1, next);
            in = next + 1;
        }
        c = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) j++;
                else {
                    c = c + 1;
                    i++;
                }
            }
        }
        int d = s.length() - c;
        return d;
    }
}
