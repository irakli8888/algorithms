package knut_morris_pratt;

public class StringGetter {

    /**
     * получить символы до указанного индекса
     * @param str строка
     * @param x индекс
     * @return символы от 0 до length
     */
    static String fromLeft(String str, int x){
        return str.substring(0, x);
    }

    /**
     * получить символы после указанного индекса
     * @param str строка
     * @param x индекс
     * @return символы str.length() - x
     */
    static String fromRigth(String str, int x){
        return str.substring(str.length() - x);
    }
}
