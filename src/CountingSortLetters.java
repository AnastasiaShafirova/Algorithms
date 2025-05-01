import java.util.Map;
import java.util.TreeMap;
public class CountingSortLetters {
    public static void countLetters(String text) {
        String lowerText = text.toLowerCase();  //преобразуем в нижний регистр

        TreeMap<Character, Integer> letterCounts = new TreeMap<>();  //сортировка по алфавиту

        for (char c : lowerText.toCharArray()) { // проходим по каждому символу строки
            if (c >= 'a' && c <= 'z') {
                letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1); //если символ буква, то увеличивается счетчик
            }
        }

        for (Map.Entry<Character, Integer> entry : letterCounts.entrySet()) {  //вывод буквы и количества
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String text = "Hello World";
        countLetters(text);
    }
}
