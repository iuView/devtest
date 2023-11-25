package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Excel {

    // keeps the key: columnNumber/26 (call it sequence for now)
    // value: a list of the column titles
    Map<Integer, List<String>> map = new HashMap<>();

    int column = 0;

    public String convertToTitle(int columnNumber) {
        column = columnNumber;

        int i = (columnNumber - 1) / 26;

        List<String> coltitles = getColumnTitles(i);
        if (coltitles != null) {
            int modof = (columnNumber - 1) % 26;
            System.out.println("i is: " + i + " modof: " + modof);
            return coltitles.get(modof);
        }
        return "";
    }

    String convertIntToChar(int inval) {
        return Character.toString((char) (inval + 64));
    }

    List<String> createInitialSeq() {
        return IntStream.range(1, 27).mapToObj(x -> {
            return convertIntToChar(x);
        }).collect(Collectors.toList());
    }

    List<String> getColumnTitles(int seq) {
        // System.out.println("getColumnTitles seq: " + seq);
        List<String> retval = map.get(seq);
        if (retval != null)
            return retval;
        else {
            if (seq == 0) {
                retval = createInitialSeq();
            } else {
                List<String> prev = getColumnTitles(seq - 1);
                int colwidth = prev.get(0).length();
                boolean needToAddCol = false;
                int wanted_columns = getWantedColumnsCount(seq, colwidth);
                if (colwidth < wanted_columns) {
                    // System.out.println("so need to add a column");
                    needToAddCol = true;
                }
                if (needToAddCol) {
                    // need to add a new column
                    retval = prev.stream().map(x -> {
                        return "A" + x;
                    }).collect(Collectors.toList());
                } else {
                    int index = seq % 26;
                    // System.out.println("index is: " + index);
                    // System.out.println("map.get(0): " + map.get(0).toString());
                    if (index == 0) // it is the last char
                        index = 26;
                    String thechar = map.get(0).get(index - 1);
                    retval = prev.stream().map(x -> {
                        char[] chars = x.toCharArray();
                        chars[0] = thechar.charAt(0);
                        return new String(chars);
                    }).collect(Collectors.toList());
                }
            }
        }
        map.put(seq, retval);
        // if (retval != null)
        // System.out.println("created ColumnTitles: " + retval.toString());
        return retval;
    }

    int getWantedColumnsCount(int seq, int pre_col_count) {
        int wantedcount = pre_col_count;

        // try the next colcount to see if it is more than the asked:

        int base = 26;

        // nextMaxColNumd is not simply the pow, we need a loop
        int nextMaxColNum = 0;
        for (int i = 1; i <= pre_col_count; i++) {
            double nextMaxColNumd = Math.pow((double) base, (double) i);
            nextMaxColNum += (int) nextMaxColNumd;
        }

        System.out.println("nextMaxColumn is: " + nextMaxColNum);
        int columnIWant = seq * 26;
        // System.out.println("seq * 26 is: " + columnIWant);

        if (columnIWant < nextMaxColNum) { // I am ok with the situation
            ;// System.out.println("it is still within the range, so keep the column same");
        } else {
            wantedcount++;
            // System.out.println("will increase the column by 1, it becomes: " +
            // wantedcount);
        }
        return wantedcount;
    }

}

