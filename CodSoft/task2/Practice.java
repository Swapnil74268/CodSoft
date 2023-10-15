
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class Practice{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Demo d = new Demo();

         String in = d.getInputText(sc);
         String[] words = d.tokenizeText(in);
        

        int totalWords = words.length;
        System.out.println("Total words: " + totalWords);

        // Optional: Count unique words and their frequencies
        Map<String, Integer> wordFrequency = d.getWordFrequency(words);
        System.out.println("Unique words: " + wordFrequency.size());

        // Optional: Display word frequencies
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

class Demo {
    
      String getInputText(Scanner scan) {
        System.out.println("Enter '1' to input text or '2' to provide a file:");
        int choice = scan.nextInt();
        scan.nextLine(); // Consume the newline character

        String inputText = "";
        if (choice == 1) {
            System.out.println("Enter the text:");
            inputText = scan.nextLine();
        } else if (choice == 2) {
            System.out.println("Enter the file path:");
            String filePath = "E:\\GitHub\\CodSoft\\New Text Document.txt\\";
            try {
                inputText = readFile(filePath);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid choice. Please enter '1' or '2'.");
            System.exit(1);
        }
        return inputText;
    }

      String readFile(String filePath) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        }
        return text.toString();
    }

      String[] tokenizeText(String inputText) {
        return inputText.split("[\\s\\p{Punct}]+");
    }

      Map<String, Integer> getWordFrequency(String[] words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }
}
