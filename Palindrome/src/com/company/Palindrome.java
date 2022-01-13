package com.company;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverseS = reverseString(s);
        if (isPalindrome(s, reverseS)) {
            System.out.println("Palindrome!");
        } else {
            System.out.println("Not Palindrome!");
        }
    }
    public static String reverseString(String s) {
            String reverseS = "";
            for (int i =s.length()-1; i>=0; i--){
                reverseS += "" + s.charAt (i);
            }
            return reverseS;
        }
    public static boolean isPalindrome(String s, String reverseS){
        if (s.equals(reverseS)){
            return true;
        } else{
            return false;
        }
    }
}

