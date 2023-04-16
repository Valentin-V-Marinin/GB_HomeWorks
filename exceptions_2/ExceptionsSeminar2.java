package exceptions_2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionsSeminar2 {

// Задача 1
    // Реализуйте метод, который запрашивает у пользователя ввод дробного числа
    // (типа float), и возвращает введенное значение. Ввод текста вместо числа
    // не должно приводить к падению приложения, вместо этого, необходимо повторно
    // запросить у пользователя ввод данных.

    public float checkFloat() {
        float result = 0.0f;
        String checkObj = "";
        boolean status = false;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.println("Input float number: ");
                checkObj = sc.nextLine();
                result = Float.parseFloat(checkObj);
                status = true;
            } catch (NumberFormatException e) {
                System.out.println("This is not a float number: " + checkObj);
            }
        } while (!status);
        return result;
    }

// Задача 2
    // Если необходимо, исправьте данный код (задание 2)

//    public void secondTask(){
//        try {
//            int d = 0;
//            double catchedRes1 = intArray[8] / d;
//            System.out.println("catchedRes1 = " + catchedRes1);
//        } catch (ArithmeticException e) {
//            System.out.println("Catching exception: " + e);
//        }
//    }
    // в исходном коде массив не объявлен и не заполнен
    // - в качестве решения передаём одномерный массив типа Integer в функцию
    // - делить на ноль бессмысленно, так что делитель (d) также можно передать в функцию параметром
    // - поскольку (Делимое) всегда имеет индекс 8, то функция очень ограничена, можно
    //     индекс также передавать в функцию, назначив 8 индексом по умолчанию
    // - внесенные изменения расширяют список возможных исключений, дополняем список исключений
    // - в соответствии с принципом ООП №1 SRP убираем функцию печати и возвращаем значение из функции

    // Функция secondTask() после редактирования
    public double secondTask(int[] intArray, double d, int ... idx) {
        double catchedRes1;
        int index = 8;
        try {
            if (idx.length > 0) {
                if (idx[0] > 0) index = idx[0];
            }
            catchedRes1 = intArray[index] / d;
            return catchedRes1;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Catching exception: " + e.getClass().getName());
            System.exit(1);
        }
        return 0.0; // эта строка никогда не выполняется
    }

// Задача 3
    // Дан следующий код, исправьте его там, где требуется (задание 3)

//    public static void main(String[] args) throws Exception {
//        try {
//            int a = 90;
//            int b = 3;
//            System.out.println(a / b);
//            printSum(23, 234);
//            int[] abc = { 1, 2 };
//            abc[3] = 9;
//        } catch (Throwable ex) {
//            System.out.println("Что-то пошло не так...");
//        } catch (NullPointerException ex) {
//            System.out.println("Указатель не может указывать на null!");
//        } catch (IndexOutOfBoundsException ex) {
//            System.out.println("Массив выходит за пределы своего размера!");
//        }
//    }
//    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
//        System.out.println(a + b);
//    }

    // Изменения исходного кода:
    // - сумма (a) и (b) печатается отдельной функцией, в то время как частное - нет, добавляем функцию печати частного (принцип SRP)
    // - объявлен одномерный массив из двух элементов, а присвоение происходит для четвертого (это будет IndexOutOfBoundsException)
    // - секции catch расположены так, что 2 последних не будут работать, однако после внесенных изменений можно отказаться
    //              от блока try-catch
    // - функция печати декларирует исключение, которое там никогда не случится, убираем это
    // - правильно было бы вынести этот код в отдельный класс в соответствии с принципами SOLID,
    //              разделить суммирование, деление, присвоение и печать на отдельные функции

    // код после редактирования

    public static void main(String[] args) {
            int a = 90;
            int b = 3;
            printDivision(a, b);
            printSum(23, 234);
            int[] abc = new int[4];
            abc[0] = 1;
            abc[1] = 2;
            abc[3] = 9;
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    public static void printDivision(Integer a, Integer b)  {
        if (b != 0) System.out.println(a / b); else System.out.println("Division by zero is not permitted!");
    }

// Задача 4
    // Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    //  Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

    public String getString() {
        boolean status = false;
        String str = "";
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.println("Input new string:");
                str = sc.nextLine();
                // строку из пробелов считаем пустой
                // если нет, то меняем условие на такое: if (str.length() == 0)
                if (str.length() == 0 || checkWhitespace(str)) {
                    throw new RuntimeException("Exception! String can't be empty! Try again.");
                } else {
                    status = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!status);
        return str;
    }

    public boolean checkWhitespace(String str){
        if (str.length() > 0) {
            for (int i = 0; i < str.length(); i++) {
                if (!Character.toString(str.charAt(i)).equals(" ")) return false;
            }
        }
        return true;
    }

}
