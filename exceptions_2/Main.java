package exceptions_2;

public class Main {
    public static void main(String[] args) {
        ExceptionsSeminar2 es2 = new ExceptionsSeminar2();
// Задача 1
        System.out.println(es2.checkFloat());

// Задача 2
        int[] arr = {3,2,5,9,4,7,54,47,555};
        System.out.println(es2.secondTask(arr, 3, 3));

// Задача 3
        String [] a = null;
        es2.main(a);

// Задача 4
        System.out.println(es2.getString());
    }
}
