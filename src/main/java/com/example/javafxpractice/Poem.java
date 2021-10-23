package com.example.javafxpractice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Poem {

    public void main(){
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
                            int newValue = Integer.valueOf(String.valueOf(wordFreq.get(words[i])));
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
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordFreq.entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        for (Map.Entry<String, Integer> key : list) {
            System.out.println("Word: " + "'" + key.getKey() + "'" + " Counts: " + key.getValue());
        }
    }


}




