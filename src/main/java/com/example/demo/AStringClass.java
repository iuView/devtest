package com.example.demo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AStringClass {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        List<Character> allvows = getAllVows();

        List<Character> vows = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (allvows.contains(chars[i])) {
                vows.add(chars[i]);
            }
        }

        int location = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (allvows.contains(chars[i])) {
                chars[i] = vows.get(vows.size() - location - 1);
                location++;
            }
            stringBuilder.append("" + chars[i]);
        }

        // return chars back to string
        return stringBuilder.toString();
    }

    List<Character> getAllVows() {
        List<Character> allvows = new ArrayList<>();
        allvows.add('u');
        allvows.add('U');
        allvows.add('a');
        allvows.add('A');
        allvows.add('i');
        allvows.add('I');
        allvows.add('o');
        allvows.add('O');
        allvows.add('e');
        allvows.add('E');
        return allvows;
    }

    /*public boolean isAlienSorted(String[] words, String order) {
        boolean retval = true;

        List<String> sortedWords = sortWords(words, order);
        for (int i = 0; i < sortedWords.size(); i++) {
            if (sortedWords.get(i).equals(words[i])) {
                continue;
            } else {
                retval = false;
                break;
            }
        }
        return retval;
    }*/

    public boolean isAlienSorted(String[] words, String order) {
        boolean retval = true;

        if (words.length <= 1) {
            return retval;
        }

        int sortval = 0;
        for (int i = 0; i < words.length; i++) {
            sortval = sortit(order, words[i], words[i + 1]);
            if (sortval == 1) {
                return false;
            } else {
                // sorted or equal
                if (i == words.length - 1 - 1) // the last already
                    return true;
                else
                    continue;
            }
        }
        return retval;
    }

    public List<String> sortWords(String[] words, String order) {
        return Arrays.stream(words).sorted((s1, s2) -> {
            return sortit(order, s1, s2);
        }).collect(Collectors.toList());
    }

    private static int sortit(String order, String s1, String s2) {
        int retval = 0; // the same
        int s1l = s1.length();
        int s2l = s2.length();
        int length = Math.min(s1l, s2l);
        for (int i = 0; i < length; i++) {
            int order1 = order.indexOf(s1.charAt(i));
            int order2 = order.indexOf(s2.charAt(i));
            if (order1 > order2) {
                return 1;
            } else if (order1 < order2) {
                return -1;
            } else {
                // need to keep going unless one of them is done
                if (s1l == i + 1 && s2l == i + 1)
                    return 0;
                else if (s1l == i + 1) {
                    return -1;
                } else if (s2l == i + 1) {
                    return 1;
                }
            }
        }
        return retval;
    }


    public int[] numberOfLines(int[] widths, String s) {
        int[] retval = new int[2];

        String all = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = all.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            int w = widths[all.indexOf(chars[i])];
            map.put(chars[i], w);
        }

        char[] sc = s.toCharArray();

        int allp = 0;
        int numberline = 0;
        for (int i = 0; i < sc.length; i++) {
            int w = map.get(sc[i]);
            if (allp + w > 100) {
                allp = 0;
                numberline++;
            } else {
                allp += w;
            }
        }

        retval[0] = numberline;
        retval[1] = allp;

        return retval;
    }


    public char findTheDifference(String s, String t) {
        Map<Character, Integer> charCountMap1 = new HashMap<>();
        Map<Character, Integer> charCountMap2 = new HashMap<>();

        Function<Character, Integer> valueMapper = x -> 1;

        charCountMap1 = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), valueMapper, Integer::sum));

        charCountMap2 = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), valueMapper, Integer::sum));

        // in the map2 there is something map1 doesn't have
        for (Character character : charCountMap2.keySet()) {
            Integer val1 = charCountMap1.get(character);
            Integer val2 = charCountMap2.get(character);
            if (val1 == null)
                return character.charValue();
            if (val1 != val2) {
                return character.charValue();
            }
        }
        return '0';
    }

    public String[] findWords(String[] words) {
        String firstRow = "qwertyuiop" + "qwertyuiop".toUpperCase(); // 0
        String secondRow = "asdfghjkl" + "asdfghjkl".toUpperCase(); // 1
        String thirdRow = "zxcvbnm" + "zxcvbnm".toUpperCase(); // 2

        Map<Character, Integer> map = new HashMap<>();
        List<String> retval = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int row = 0;
            boolean skipit = false;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                Integer temp = map.get(c);
                if (temp == null) {
                    temp = getWhichRow(c, firstRow, secondRow, thirdRow);
                    map.put(c, temp);
                }
                if (j == 0)
                    row = temp;
                else {
                    if (temp != row) {
                        skipit = true;
                        break;
                    }
                }
            }
            if (!skipit) {
                retval.add(word);
            }
        }
        return retval.toArray(new String[retval.size()]);
    }

    private int getWhichRow(char c, String firstRow, String secondRow, String thirdRow) {
        if (firstRow.indexOf(c) >= 0)
            return 0;
        else if (secondRow.indexOf(c) >= 0)
            return 1;
        else
            return 2;
    }

    // Characters ('a' to 'i') are represented by ('1' to '9') respectively.
    //          Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
    public String freqAlphabets(String s) {
        char[] chars = s.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        // searching backwards
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (c == '#') {
                char c1 = chars[i - 1];
                char c2 = chars[i - 2];
                String string = "" + c2 + c1;
                int i1 = Integer.parseInt(string);
                char c3 = (char) ('j' + (i1 - 10));
                stringBuilder.append(c3 + "");
                i = i - 2;
            } else {
                char c2 = chars[i];
                String string = "" + c2;
                int i1 = Integer.parseInt(string);
                char c3 = (char) ('a' + (i1 - 1));
                stringBuilder.append(c3 + "");
            }
        }

        return stringBuilder.reverse().toString();
    }

    public String reorderSpaces(String text) {
        char[] chars = text.toCharArray();
        int numberOfSpaces = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                numberOfSpaces++;
            }
        }

        String[] strings = text.trim().split("\\s+");
        int needSpaces = strings.length - 1;
        int between = numberOfSpaces / needSpaces;
        int leftover = numberOfSpaces % needSpaces;
        System.out.println("between: " + between);
        System.out.println("leftover: " + leftover);
        StringBuilder stringBuilder = new StringBuilder();
        String body = String.join(" ".repeat(between), strings);
        stringBuilder.append(body);
        if (leftover != 0)
            stringBuilder.append(" ".repeat(leftover));
        return stringBuilder.toString();
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int retval = 0;
        retval = items.stream().mapToInt(item -> {
            switch (ruleKey) {
                case "type":
                    if (item.get(0).equals(ruleValue))
                        return 1;
                    else
                        return 0;

                case "color":
                    if (item.get(1).equals(ruleValue))
                        return 1;
                    else
                        return 0;

                case "name":
                    if (item.get(2).equals(ruleValue))
                        return 1;
                    else
                        return 0;

                default:
                    return 0;
            }

        }).sum();

        return retval;
    }

    public boolean isAcronym(List<String> words, String s) {
        boolean retval = false;
        String acronym = words.stream().map(x -> String.valueOf(x.charAt(0))).collect(Collectors.joining());
        return acronym.equals(s);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    List<String> vals = map.get(i + j);
                    if (vals == null) {
                        vals = new ArrayList<>();
                    }
                    vals.add(list1[i]);
                    map.put(i + j, vals);
                }
            }
        }
        List<String> strings = map.firstEntry().getValue();
        return strings.toArray(new String[strings.size()]);
    }


}
