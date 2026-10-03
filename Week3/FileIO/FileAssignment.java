package myPackage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Integer> frequency = new HashMap<>();

        try {
            FileReader reader = new FileReader("student.txt");

            String word = "";
            int ch;

            while ((ch = reader.read()) != -1) {

                if (Character.isLetterOrDigit((char) ch)) {
                    word += (char) ch;
                } 
                else if (!word.isEmpty()) {

                    word = word.toLowerCase();

                    frequency.put(word, frequency.getOrDefault(word, 0) + 1);

                    word = "";
                }
            }

            // Process the last word
            if (!word.isEmpty()) {
                word = word.toLowerCase();
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }

            reader.close();

            FileWriter writer = new FileWriter("newstudent.txt");

            for (String key : frequency.keySet()) {
                writer.write(key + " : " + frequency.get(key) + "\n");
            }

            writer.close();

            System.out.println("Word frequency written to newstudent.txt");

        } 
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
