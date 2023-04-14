package exceptions_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExceptionsSeminar1 {

// Задание  1
    // Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

    //NullPointerException (если на вход получаем NULL)
    public void printList(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    //NullPointerException
    //IndexOutOfBoundsException
    public ArrayList<Integer> createOddList(ArrayList<Integer> arrayList){
        int arrayListLength = arrayList.size();
        for (int i = 0; i < arrayListLength; i++) {
            if (arrayList.get(i)%2 == 0) {
                arrayList.remove(i);
                i = 0;
            }
        }
        return arrayList;
    }

    //UnsupportedOperationException
    public void a(){
        String array[] = {"apple", "banana", "cucumber"};
        List<String> list = Arrays.asList(array);
        list.add("watermelon");
    }

// Задание  2
    // Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
    public int sum2d(String[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }
    // Здесь могут возникнуть следующие исключения:
    // - ArrayIndexOutOfBoundsException (внутренний цикл ограничен цифрой пять, размер массива может быть меньше)
    // - NullPointerException (передали NULL в функцию)
    // - NumberFormatException (ошибка конвертации строки в число)

// Задание  3
    // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
    // и возвращающий новый массив, каждый элемент которого равен разности элементов
    // двух входящих массивов в той же ячейке. Если длины массивов не равны,
    // необходимо как-то оповестить пользователя.
    public int[] diff2arrays(int[] a, int[] b){
        if (a.length != b.length) {
            throw new RuntimeException("Exception! Arrays are different by length.");
        }

        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] - b[i];
        }
        return result;
    }

// Задание  4
    // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
    // и возвращающий новый массив, каждый элемент которого равен частному элементов
    // двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо
    // как-то оповестить пользователя. Важно: При выполнении метода единственное
    // исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.

    public double[] division2arrays(int[] a, int[] b){
        if (a.length != b.length) {
            throw new RuntimeException("Exception! Arrays are different by length.");
        }

        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = (double) a[i] / (double) b[i];
        }
        return result;
    }


}
