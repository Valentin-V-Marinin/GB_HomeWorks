package exceptions_3;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class GetCheckData {

    private final int NUMBER_INCOMING_DATA = 6;
    private final int FIO_NUMBER = 3; // SURNAME + NAME + PATRONYMIC
    private HashMap<String, String> resultMap;
    private String[] array;
    private List<String> arrList;
    private String str;

    private Scanner sc;

    public GetCheckData(Scanner sc) {
        this.sc = sc;
        resultMap = new HashMap<>();
        array = new String[NUMBER_INCOMING_DATA];
    }


    public boolean getData(){
        boolean result = false;
        if (parseStr()) {
            result = check();
            if (result) printMap();
        }
        return result;
    }

    private boolean parseStr() {
        boolean result = true;
        str = sc.nextLine();

        if (str.length() == 0){
            throw new RuntimeException("Ошибка! Пустая строка! Введите данные.");
        }

        array = str.split(" ");
        try {
            if (array.length < NUMBER_INCOMING_DATA) {
                result = false;
                throw new WrongNumberOfData("Неполные данные! Попробуйте еще раз.");
            } else if (array.length > NUMBER_INCOMING_DATA){
                result = false;
                throw new WrongNumberOfData("Избыточные данные! Попробуйте еще раз.");
            }
        } catch (WrongNumberOfData e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    private boolean check() {
        boolean result;
        try {
            result = checkSex();
            if (result) result = checkBirthday();
            if (result) result = checkPhone();
            if (result) result = checkName();
        } catch (WrongFormatData e){
            result = false;
            System.out.println(e.getMessage());
        }
        return result;
    }


    // пол
    private boolean checkSex() throws WrongFormatData {
        boolean result = false;
        boolean parExist = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() == 1) {
                parExist = true;
                if (array[i].equals("f") || array[i].equals("m")) {
                    resultMap.put("sex", array[i]);
                    arrList = new ArrayList<>(Arrays.asList(array));
                    arrList.remove(i);
                    result = true;
                    break;
                } else {
                    throw new WrongFormatData("Некорректная литера для обозначения пола: " + array[i]);
                }
            }
        }
        if (!parExist)  throw new WrongFormatData("Отсутствует данные для обозначения пола!");
        return result;
    }


    // дата рождения
    private boolean checkBirthday() throws WrongFormatData {
        boolean result = false;
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i).contains(".")) {
                int fullLength = arrList.get(i).length();
                int cutLength  = arrList.get(i).replace(".","").length();

                if (arrList.get(i).indexOf(".") == 2 && arrList.get(i).lastIndexOf(".") == 5
                        && (fullLength-cutLength == 2)) {
                    try{
                        String ndate = arrList.get(i);
                        String sdate = ndate.substring(6,10).concat("-").concat(ndate.substring(3,5)).concat("-").concat(ndate.substring(0,2));
                        LocalDate date = LocalDate.parse(sdate);
                    } catch (DateTimeException e){
                        throw new WrongFormatData("Введённая дата некорректна: " + arrList.get(i) + " | " + e.getMessage());
                    }
                    resultMap.put("birthday", arrList.get(i));
                    arrList.remove(i);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    // телефон
    private boolean checkPhone() throws WrongFormatData {
        boolean result = false;
        int counter = 0;
        for (int i = 0; i < arrList.size(); i++) {
            try {
                Long.parseLong(arrList.get(i));
                resultMap.put("phone",arrList.get(i));
                arrList.remove(i);
                result = true;
                break;
            } catch (Exception e) {
                counter++;
                if (counter == arrList.size())
                    throw new WrongFormatData("Номер телефона отсутствует или некорректен.");
            }
        }
        return result;
    }

    // ФИО
    private boolean checkName() throws WrongFormatData {
        boolean result = false;

        if (arrList.size() == FIO_NUMBER){
            resultMap.put("surname",arrList.get(0));
            resultMap.put("name",arrList.get(1));
            resultMap.put("patronymic",arrList.get(2));
            result = true;
        } else {
            throw new WrongFormatData("Введённые данные имеют некорректный формат.");
        }
        return result;
    }

    private void printMap(){
        System.out.println( resultMap.get("surname") + " " +
                            resultMap.get("name") + " " +
                            resultMap.get("patronymic") + " " +
                            resultMap.get("birthday") + " " +
                            resultMap.get("phone") + " " +
                            resultMap.get("sex"));
    }

    public String[] getArray(){
        String[] result = new String[resultMap.size()];
        result[0] = resultMap.get("surname");
        result[1] = resultMap.get("name");
        result[2] = resultMap.get("patronymic");
        result[3] = resultMap.get("birthday");
        result[4] = resultMap.get("phone");
        result[5] = resultMap.get("sex");
        return result;
    }

}
