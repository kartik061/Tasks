package hashMapExample;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class WordFrequencyCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text:");
        String inputText = scanner.nextLine();
        Map<String, Integer> wordFrequencyMap = countWordFrequencies(inputText);
        displayWordFrequencies(wordFrequencyMap);
    }

    private static Map<String, Integer> countWordFrequencies(String text) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();


        String[] words = text.split("\\s+");


        for (String word : words) {

            String lowercaseWord = word.toLowerCase();

            wordFrequencyMap.put(lowercaseWord, wordFrequencyMap.getOrDefault(lowercaseWord, 0) + 1);
        }

        return wordFrequencyMap;
    }

    private static void displayWordFrequencies(Map<String, Integer> wordFrequencyMap) {
 
        Map<String, Integer> sortedWordFrequencyMap = wordFrequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));

         System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : sortedWordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
