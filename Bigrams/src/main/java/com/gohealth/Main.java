package com.gohealth;

import com.gohealth.Read;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Read read = new Read(System.in, System.out);
        String input = read.read();
        // The quick brown fox and the quick blue hare.
        List<String> bigrams = read.getBigrams(input);
        LinkedHashMap<String, Integer> histogram = read.getHistogram(bigrams);
        read.print(histogram);
    }
}