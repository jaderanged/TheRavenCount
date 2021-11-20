package com.example.javafxpractice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class builds the poem word counter
 *
 * @author Jade Boone
 */
class Poem {
    /**
     * This method reads the file and goes through a for loop in order
     * to count word frequencies and output the words from most occurred to least
     */
    public void poemMain() {
        String line;
        int lineNum = 0;
        Map<String, Integer> wordFreq = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/jade.boone/Documents/Fall Semester 2021/Software Development/raven.txt"));
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split(" ");
                line.replaceAll("[0-10]", " ");
                lineNum++;
                if (lineNum <= 32 && lineNum >= 17) {
                    for (int i = 0; i < words.length; i++) {
                        if (wordFreq.get(words[i]) == null) {
                            wordFreq.put(words[i], 1);
                        } else {
                            int newValue = Integer.parseInt(String.valueOf(wordFreq.get(words[i])));
                            newValue++;
                            wordFreq.put(words[i], newValue);
                        }
                    }
                }
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        List<Map.Entry<String, Integer>> list = wordFreq.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(20).collect(Collectors.toList());

        for (Map.Entry<String, Integer> key : list) {

                System.out.println("Word: " + "'" + key.getKey() + "'" + " Counts: " + key.getValue());
        }

    }
}




