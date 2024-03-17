import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Чтение файла
            File file = new File("C://ControlWorkTwo/ControlWorkTwo/input.txt");
            Scanner scanner = new Scanner(file);

            // Подсчет слов
            int wordCount = 0;
            while (scanner.hasNext()) {
                scanner.next();
                wordCount++;
            }
            System.out.println("Количество слов: " + wordCount);

            // Поиск самого длинного слова
            scanner = new Scanner(file);
            String longestWord = "";
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
            System.out.println("Самое длинное слово: " + longestWord);

            // Вычисление частоты слов
            scanner = new Scanner(file);
            Map<String, Integer> wordFrequency = new HashMap<>();
            while (scanner.hasNext()) {
                String word = scanner.next();
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
            System.out.println("Частота слов:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}