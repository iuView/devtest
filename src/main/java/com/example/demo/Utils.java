package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Utils {

    public List<Integer> readFile() throws IOException {
        // read just the file named data in the project directory
        return Files.lines(Path.of("data.txt")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public void writeDataToFile() {
        // add some data to each line of the data.txt file:
        List<Integer> readlines = null;
        try {
            readlines = readFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Path path = Paths.get("newdata.txt");
        String firstLine = readlines.get(0) + " firstline\n";
        try {
            Files.write(path, firstLine.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 1; i < readlines.size(); i++) {
            String line = readlines.get(i) + " text" + i + "\n";
            try {
                Files.write(path, line.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Integer> readMoreFile() throws IOException {
        // read the file that has more stuff in it
        Path path = Paths.get("newdata.txt");
        return Files.lines(path).map(line -> {
            String[] items = line.split("\\s");
            return Integer.parseInt(items[0]);
        }).collect(Collectors.toList());

    }

    // return the longest first item from this list:
    public String getFirstFromList(List<String> s) {
        return s.stream().sorted((o1, o2) -> {
            return Integer.compare(o2.length(), o1.length());
        }).findFirst().orElse("");
    }

    public String getFromList(List<String> s) {
        return s.stream().sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).findFirst().orElse("");
    }

    public void addNumberToTreeSet() {

        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.add(12);
        integerTreeSet.add(12);
        integerTreeSet.add(2);
        integerTreeSet.add(34);
        System.out.println(integerTreeSet.toString());
        System.out.println("first is: " + integerTreeSet.first());
        System.out.println("last is: " + integerTreeSet.last());

    }

    public boolean isTidy(int mynum) {
        String strval = String.valueOf(mynum);
        char[] chars = strval.toCharArray();
        int prev = 0;
        boolean tidy = true;
        for (int i = 0; i < chars.length; i++) {
            int digitint = chars[i] - '0';
            if (i == 0) {
                prev = digitint;
            }
            if (digitint >= prev) {
                continue;
            } else {
                tidy = false;
                break;
            }
        }
        return tidy;
    }
}