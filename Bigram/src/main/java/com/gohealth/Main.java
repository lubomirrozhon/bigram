package com.gohealth;

import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Read read = new Read(System.in, System.out);
        read.ask();
        String input = read.read();
        List<String> bigrams = read.getBigrams(input);
        LinkedHashMap<String, Integer> histogram = read.getHistogram(bigrams);
        read.print(histogram);
    }
}