package knut_morris_pratt;

public class Auto {

    private String alphabet = "ABC";
    private String pattern;
    //матрица изменений
    private int[][] delta;

    public Auto(String pattern) {
        this.pattern = pattern;
        delta = new int[pattern.length()][alphabet.length()];
        createDelta(pattern);
    }

    /**
     * Собираем массив для дальнейшего поиска совпадений
     *
     * @param pattern искомы паттерн
     */
    public void createDelta(String pattern) {

        for (int i = 0; i < pattern.length(); i++) {
            for (char c : alphabet.toCharArray()) {
                String line = StringGetter.fromLeft(pattern, i) + c;
                //следующий номер состояния
                int k = i + 1;
                while (!StringGetter.fromLeft(pattern, k).equals(StringGetter.fromRigth(line, k))) {
                    k--;
                }
                //c - alphabet.toCharArray()[0] - поиск индекса текущего символа в массиве
                //alphabet.toCharArray()[0] - первый символ в алфавите (А)
                //если ищем индекс для символа Б (представим, что символ Б соответствует числу 2, символ А - 1)
                //с - текущий символ (Б)
                //c - alphabet.toCharArray()[0] == 1 - первый элемент массива, то есть Б
                delta[i][c - alphabet.toCharArray()[0]] = k;
            }
        }
    }

    public int search(String text) {
        int q = 0;
        for (int i = 0; i < text.length(); i++) {
            q = delta[q][text.toCharArray()[i] - alphabet.toCharArray()[0]];
            if(q == pattern.length()){
                return i - pattern.length() + 1;
            }
        }
        return -1;
    }

}
