package com.gohealth;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Read {

    private InputStream is;
    private PrintStream ps;

    public Read(InputStream is, PrintStream ps) {
        this.is = is;
        this.ps = ps;
    }

    public String read() {
        Scanner scanner = new Scanner(is);
        ps.println("Input:");

        String text = scanner.nextLine();
        text = text.toLowerCase();
        text = text.replaceAll("\\p{Punct}", "");

        return text;
    }

    public List<String> getBigrams(String input) throws Exception {
        List<String> bigrams = new ArrayList<>();
        String[] words = input.split(" ");

        if(words.length <= 1){
            ps.println("Wrong number of words must be at least 2");
            //throw new Exception("Wrong number of words");
        }

        for(int i=1; i<words.length; i++){
            bigrams.add(words[i-1] + " " + words[i]);
        }

        return bigrams;
    }

    public LinkedHashMap<String, Integer> getHistogram(List<String> bigrams){
        LinkedHashMap<String, Integer> histogram = new LinkedHashMap<>();

        for(String bigram : bigrams) {
            if(histogram.containsKey(bigram)) {
                histogram.replace(bigram, histogram.get(bigram)+1);

            }
            else {
                histogram.put(bigram, 1);
            }
        }

        return histogram;
    }

    public void print(LinkedHashMap<String, Integer> histogram) {
        for(Map.Entry<String, Integer> entry: histogram.entrySet()){
            ps.println("\"" + entry.getKey() +"\" " + entry.getValue());
        }
    }
}
