public class Primess {
    //Основная функция
    public static void main(String[] args) {
        int n = 100;
        for (int i = 3; i <= n; i++) {
            if (isPrime(i))
            { System.out.println(i); }
        }
    }
    //Функция, проверяющая является-ли число простым
     public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) { return false; }
        } return true;
    }
}
