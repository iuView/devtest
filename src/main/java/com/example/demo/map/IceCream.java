package com.example.demo.map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IceCream {
    public List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here
        Map<Integer, Integer> map = IntStream.range(0, arr.size())
                .boxed()
                .collect(Collectors.toMap(arr::get, i -> i + 1));

        System.out.println(map.toString());

        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        };
        arr.sort(comparator);

        System.out.println(arr.toString());

        List<Integer> retval = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int target = m - arr.get(i);
            List<Integer> sb = arr.subList(i + 1, arr.size());
            int found = sb.indexOf(target);
            if (found != -1) {
                // found both of the values
                retval.add(map.get(arr.get(i)));
                retval.add(map.get(target));
                break;
            }
        }

        return retval.stream().sorted().collect(Collectors.toList());
    }
}
