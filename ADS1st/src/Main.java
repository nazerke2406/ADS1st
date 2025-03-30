import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose task number (1-10):");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> task1();
            case 2 -> task2();
            case 3 -> task3();
            case 4 -> task4();
            case 5 -> task5();
            case 6 -> task6();
            case 7 -> task7();
            case 8 -> task8();
            case 9 -> task9();
            case 10 -> task10();
            default -> System.out.println("Invalid task number");
        }
    }

    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        System.out.println(Min(arr, n - 1));
    }

    // Time: O(n), Space: O(n)
    private static int Min(int[] arr, int index) {
        if (index == 0) return arr[0];
        return Math.min(arr[index], Min(arr, index - 1));
    }

    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        double total = Sum(arr, n - 1);
        System.out.println(total / n);
    }

    // Time: O(n), Space: O(n)
    private static int Sum(int[] arr, int index) {
        if (index < 0) return 0;
        return arr[index] + Sum(arr, index - 1);
    }

    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (CheckPC(n, 2)) System.out.println("Prime");
        else System.out.println("Composite");
    }

    // Time: O(sqrt(n)), Space: O(n)
    private static boolean CheckPC(int n, int i) {
        if (n <= 2) return n == 2;
        if (n % i == 0) return false;
        if (i * i > n) return true;
        return CheckPC(n, i + 1);
    }

    public static void task4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Factorial(n));
    }

    // Time: O(n), Space: O(n)
    private static int Factorial(int n) {
        if (n == 0) return 1;
        return n * Factorial(n - 1);
    }

    public static void task5() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibonacci(n));
    }

    // Time: O(2^n), Space: O(n)
    private static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void task6() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(power(a, n));
    }

    // Time: O(n), Space: O(n)
    private static int power(int a, int n) {
        if (n == 0) return 1;
        return a * power(a, n - 1);
    }

    public static void task7() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        printPermutations(s.toCharArray(), 0);
    }

    // Time: O(n!), Space: O(n)
    private static void printPermutations(char[] arr, int index) {
        if (index == arr.length - 1) {
            System.out.println(new String(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swapLetters(arr, index, i);
            printPermutations(arr, index + 1);
            swapLetters(arr, index, i);
        }
    }

    private static void swapLetters(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void task8() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if (onlyDigits(s, 0)) System.out.println("Yes");
        else System.out.println("No");
    }

    // Time: O(n), Space: O(n)
    private static boolean onlyDigits(String s, int index) {
        if (index == s.length()) return true;
        if (!Character.isDigit(s.charAt(index))) return false;
        return onlyDigits(s, index + 1);
    }

    public static void task9() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(binomial(n, k));
    }

    // Time: O(2^n), Space: O(n)
    private static int binomial(int n, int k) {
        if (k == 0 || k == n) return 1;
        return binomial(n - 1, k - 1) + binomial(n - 1, k);
    }

    public static void task10() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(GCD(a, b));
    }

    // Time: O(log(min(a, b))), Space: O(log(min(a, b)))
    private static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}
