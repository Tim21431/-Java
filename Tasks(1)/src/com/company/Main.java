package com.company;
public class Main {
    public static void main(String[] args) {
        //1.1
        System.out.println("1:   " + remainder(6, 6));
        //1.2
        System.out.println("2:   " + triArea(7, 4));
        //1.3
        System.out.println("3   " + animals(2,3,5));
        //1.4
        System.out.println("4   " + profitableGamble(0.9, 1, 2));
        //1.5
        System.out.println("5   " + operation(24,5,91));
        //1.6
        System.out.println("6   " + ctoa('m'));
        //1.7
        System.out.println("7   " + addUpTo(10));
        //1.8
        System.out.println("8   " + nextEdge(8,10));
        //1.9
        System.out.println("9   " + sumOfCubes(new int[]{3,4,5}));
        //1.10
        System.out.println("10   " + abcmath(42,5,10));

    }
    public static int remainder(int x, int y) {
        return (x % y);
    }
        public static double triArea(double a,double h){

        return (a*h*0.5);
    }
    public static int animals(int x, int y, int z){

        return(x*2+y*4+z*4);
    }
    public static boolean profitableGamble(double prob, int prize, int pay){
        if (prob*prize>pay)
        {return true;}
        else {return false;}
    }
    public static String operation(int N, int a, int b){
        if (a+b == N)
        {return "Сложить";}
        else if (a - b == N)
        {return "Вычесть";}
        else if (a*b == N)
        {return "Умножить";}
        else if (a/b == N)
        {return "Делить";}
        else {return "None";}
    }
    public static int ctoa(char x){

        return x;
    }
    public static int addUpTo(int x){
        int summ = 0;
        for (int z = 1;z<=x; ++z){
            summ+=z;
        }
        return summ;
    }
    public static int nextEdge(int x, int y){

        return x+y-1;
    }
    public static int sumOfCubes(int[] mas){
        int summ = 0;
        for (int i = 0; i<mas.length;i++){
            summ = summ + mas[i]*mas[i]*mas[i];
        }
        return summ;
    }
    public static boolean abcmath(int x, int y, int z){
       int p = x;
       for (int q = 1; q<=y; ++q){
           p +=x;
       }
       return p%z == 0;
    }

}
