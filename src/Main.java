import java.util.Scanner;

public class Main {
    public static final int MC_LENGTH_10 = 10;
    public static final int MC_LENGTH_11 = 11;
    public static final char MC_BEG_SYMB_7 = '7';
    public static final char MC_BEG_SYMB_8 = '8';
    public static final char MC_BEG_STR_7 = '7';

    public static void main(String[] args) {
//***
//        Реализуйте  удаление лишних символов при вводе номера телефона в консоли и
//        проверку соответствия номера формату мобильных номеров России.
//                Если введённую строку нельзя привести к формату мобильного номера —
//        выводите сообщение о неверном вводе. Телефон может быть введен не только в формате 79091234567,
//                но и с лишними символами.
// ***
        Scanner loScanner = new Scanner(System.in);
        System.out.println("Please enter your phone");

        String loPhone = loScanner.nextLine();
        loPhone = loPhone.replaceAll("[^0-9]", "");

        StringBuffer loSb = new StringBuffer(loPhone);

        //Проверка на валидность
        if (loPhone.length() == MC_LENGTH_11) {
            //Если 11 - проверяем первый символ, должен быть либо 7 либо 8(меняем на 7),
            //иначе ошибка "Неверный формат номера"
            //Избегать оператора switch
            switch (loPhone.charAt(0)) {
                case MC_BEG_SYMB_7:
                    break;
                case MC_BEG_SYMB_8:
                    //(меняем на 7 первый символ)
                    loSb.setCharAt(0, MC_BEG_SYMB_7);
                    loPhone = loSb.toString();
                    break;
                default:
                    System.out.println("Uncorrect number");
                    return;
            }
        } else if (loPhone.length() == MC_LENGTH_10) {
            //Если 10, добавляем 7
            loSb.insert(0, MC_BEG_STR_7);
            loPhone = loSb.toString();
        } else if ((loPhone.length() < MC_LENGTH_10) || (loPhone.length() > MC_LENGTH_11)) {
            //Если меньше 10 - "Неверный формат номера"
            //Если больше 11 - "Неверный формат номера"
            System.out.println("Uncorrect number");
            return;
        }
        System.out.println(loPhone);
    }
}