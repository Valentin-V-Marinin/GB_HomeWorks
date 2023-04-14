package exceptions_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ExceptionsSeminar1 es = new ExceptionsSeminar1();

// Задача 1.1
        //NullPointerException
//        ArrayList<Integer> someList = null;
//        es.printList(someList);

        // или
        //NullPointerException
//        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(5,10,null,4,3,1,0,8,7));
//        ArrayList<Integer> alOdd = es.createOddList(al);

// Задача 1.2
          //IndexOutOfBoundsException
//        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(5,10,12,4,3,1,0,8,7));
//        ArrayList<Integer> alOdd = new ArrayList<>();
//        alOdd = es.createOddList(al);
//        for (int i = 0; i < alOdd.size(); i++) {
//            System.out.print(alOdd.get(i) + " ");
//        }

// Задача 1.3
          //UnsupportedOperationException
//        es.a();



// Задача 3
//        int a[] = {5,15,48,2};
//        int b[] = {2,19,48};
//        int c[] = es.diff2arrays(a, b);
//        for (int i = 0; i < c.length; i ++) {
//            System.out.print(c[i]+" ");
//        }
//    }

// Задача 4
        int a[] = {5,15,48,};
        int b[] = {2,19,48,-6};
        double c[] = es.division2arrays(a, b);
            for (int i = 0; i < c.length; i ++) {
            System.out.print(c[i]+" ");
        }
    }
}
