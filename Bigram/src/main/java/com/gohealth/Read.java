package com.gohealth;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class Read {

    private InputStream is;
    private PrintStream ps;
    private int mark;

    public Read(InputStream is, PrintStream ps) {
        this.is = is;
        this.ps = ps;
        this.mark = 1;
    }

    //write number 0 if you provide fullpath to file or any other number if you write filename from resource folder.
    public void ask() {
        Scanner scanner = new Scanner(is);
        ps.println("Write: number 0- full path to file | other number- name of file from resources folder");
        this.mark = Integer.parseInt(scanner.nextLine());
    }

    //read filename, then read content of file and return as String
    public String read() throws IOException, URISyntaxException {
        Scanner scanner = new Scanner(is);
        ps.print("Filename: ");

        String text = scanner.nextLine();

        File file;
        if(this.mark == 0) {
            file = new File(text);
        }
        else {
            ClassLoader cl = getClass().getClassLoader();
            URL url = cl.getResource(text);
            file = new File(url.toURI());
        }

        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder string= new StringBuilder();
        String st;
        while ((st = br.readLine()) != null)
            string.append(st).append(" ");

        return string.toString();
    }

    //convert input to lowercase and remove punctuations. Divide string into words by one or more spaces and add to list.
    public List<String> getBigrams(String input) {
        input = input.toLowerCase();
        input = input.replaceAll("\\p{Punct}", "");

        List<String> bigrams = new ArrayList<>();
        String[] words = input.split("\\s+");

        if(words.length <= 1) {
            ps.println("Wrong number of words must be at least 2");
            return bigrams;
        }

        for(int i=1; i<words.length; i++) {
            bigrams.add(words[i-1] + " " + words[i]);
        }

        return bigrams;
    }

    //add bigrams in hashmap. if bigram exists increment number of uses by 1.
    public LinkedHashMap<String, Integer> getHistogram(List<String> bigrams){
        LinkedHashMap<String, Integer> histogram = new LinkedHashMap<>();

        for(String bigram : bigrams) {
            if(histogram.containsKey(bigram)) {
                histogram.replace(bigram, histogram.get(bigram) + 1);
            }
            else {
                histogram.put(bigram, 1);
            }
        }

        return histogram;
    }

    //print hashmap
    public void print(LinkedHashMap<String, Integer> histogram) {
        for(Map.Entry<String, Integer> entry: histogram.entrySet()){
            ps.print("\"" + entry.getKey() +"\" " + entry.getValue() + "\n");
        }
    }

    public int getMark() {
        return this.mark;
    }
}
