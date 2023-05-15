package exceptions_3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String flag = "y";
        while (!flag.equals("N")) {
            try {
                GetCheckData getCheckData = new GetCheckData(new Scanner(System.in));
                FileControl fileControl = new FileControl();
                System.out.println();
                System.out.println("Введите данные одной строкой ЧЕРЕЗ ПРОБЕЛ: \n" +
                        "ФИО, телефон (только цифры), дату рождения (формат: dd.mm.yyyy)\n" +
                        "пол (для обозначения пола используйте одну букву: f(female) или m(male)\n" +
                        "(образец: Сидоров Иван Петрович 89150123456 01.01.1900 m)\n");

                if (getCheckData.getData()) {
                    String path = "";
                    if (args.length > 0) path = args[0];
                    fileControl.addFile(getCheckData.getArray(), path);
                }
                System.out.println("Продолжаем? ENTER-ДА, N-НЕТ ");
                flag = scr.nextLine().toUpperCase();
                System.out.println();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Продолжаем? ENTER-ДА, N-НЕТ ");
                flag = scr.nextLine().toUpperCase();
                System.out.println();
            }
        }
        scr.close();
    }
}
