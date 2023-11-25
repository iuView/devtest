package com.example.demo.heap;

import java.util.*;
import java.util.stream.Collectors;

public class StoneGame4 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int retval = 0;


        int[] scores = new int[2];
        scores[0] = 0;
        scores[1] = 0;
        getScores(aliceValues, bobValues, true, scores);

        if (scores[0] > scores[1])
            retval = 1;
        else if (scores[0] < scores[1])
            retval = -1;

        return retval;
    }

    private void getScores(int[] aliceValues, int[] bobValues, boolean isAliceTurn, int[] scores) {

        // need to create these queues each time, hope this is not too much of a drag on perf
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        PriorityQueue<Integer> aliceQ = new PriorityQueue<>(comparator);
        aliceQ.addAll(Arrays.stream(aliceValues).mapToObj(x -> x).collect(Collectors.toList()));

        PriorityQueue<Integer> bobQ = new PriorityQueue<>(comparator);
        bobQ.addAll(Arrays.stream(bobValues).mapToObj(x -> x).collect(Collectors.toList()));


        // brute force now with alice turn, will refactor later
        if (isAliceTurn) {
            handleAliceTurn(aliceValues, bobValues, isAliceTurn, scores, aliceQ, bobQ);
        } else {
            // handle Bob's turn
            // could be the same logic
            handleBobTurn(aliceValues, bobValues, isAliceTurn, scores, aliceQ, bobQ);
        }

    }

    private void handleBobTurn(int[] aliceValues, int[] bobValues, boolean isAliceTurn, int[] scores, PriorityQueue<Integer> aliceQ, PriorityQueue<Integer> bobQ) {
        int aliceTop = aliceQ.peek();
        int bobTop = bobQ.peek();
        if (bobTop >= aliceTop) {

            int tempAliceValue = 0;
            int theindex = -1;
            for (int i = 0; i < bobValues.length; i++) {
                if (bobValues[i] == bobTop) {
                    int aliceValue = aliceValues[i];
                    if (aliceValue > tempAliceValue) {
                        tempAliceValue = aliceValue;
                        theindex = i;
                    }
                }
            }

            scores[1] = scores[1] + bobTop;
            if (aliceValues.length > 1) {
                int[] newaliceVals = new int[aliceValues.length - 1];
                int[] newbobVals = new int[bobValues.length - 1];
                int newarrayind = 0;
                for (int i = 0; i < bobValues.length; i++) {
                    if (i == theindex) {
                        continue;
                    } else {
                        newaliceVals[newarrayind] = aliceValues[i];
                        newbobVals[newarrayind] = bobValues[i];
                        newarrayind++;
                    }
                }
                getScores(newaliceVals, newbobVals, !isAliceTurn, scores);
            }
        } else {
            int tempBobValue = 0;
            int theindex = -1;
            for (int i = 0; i < aliceValues.length; i++) {
                if (aliceValues[i] == aliceTop) {
                    int bobValue = bobValues[i];
                    if (bobValue > tempBobValue) {
                        tempBobValue = bobValue;
                        theindex = i;
                    }
                }
            }

            scores[1] = scores[1] + tempBobValue;
            if (aliceValues.length > 1) {
                int[] newaliceVals = new int[aliceValues.length - 1];
                int[] newbobVals = new int[bobValues.length - 1];
                int newarrayindex = 0;
                for (int i = 0; i < aliceValues.length; i++) {
                    if (i == theindex) {
                        continue;
                    } else {
                        newaliceVals[newarrayindex] = aliceValues[i];
                        newbobVals[newarrayindex] = bobValues[i];
                        newarrayindex++;
                    }
                }
                getScores(newaliceVals, newbobVals, !isAliceTurn, scores);
            }
        }
    }

    private void handleAliceTurn(int[] aliceValues, int[] bobValues, boolean isAliceTurn, int[] scores, PriorityQueue<Integer> aliceQ, PriorityQueue<Integer> bobQ) {
        int aliceTop = aliceQ.peek();
        int bobTop = bobQ.peek();
        if (aliceTop >= bobTop) {
            // use aliceTop because it is aliceTurn, and alice is larger
            // now it is the harder part: look for the index in aliceValues for this aliceTop
            int tempBobValue = 0;
            int theindex = -1;
            for (int i = 0; i < aliceValues.length; i++) {
                if (aliceValues[i] == aliceTop) {
                    int bobValue = bobValues[i];
                    if (bobValue > tempBobValue) {
                        tempBobValue = bobValue;
                        theindex = i;
                    } else {
                        ;
                    }
                }
            }

            // now theindex is the index that alice is taking
            // now is time to create the new arrays
            // we are removing theindex from both aliceValues and bobValues
            // first add the scores
            scores[0] = scores[0] + aliceTop;
            if (aliceValues.length > 1) {
                int[] newaliceVals = new int[aliceValues.length - 1];
                int[] newbobVals = new int[bobValues.length - 1];
                int newarrayindex = 0;
                for (int i = 0; i < aliceValues.length; i++) {
                    if (i == theindex) {
                        continue;
                    } else {
                        newaliceVals[newarrayindex] = aliceValues[i];
                        newbobVals[newarrayindex] = bobValues[i];
                        newarrayindex++;
                    }
                }
                getScores(newaliceVals, newbobVals, !isAliceTurn, scores);
            }
        } else {
            // the goal here is to get rid of bob's value, and maximize alice's value
            int tempAliceValue = 0;
            int theindex = -1;
            for (int i = 0; i < bobValues.length; i++) {
                if (bobValues[i] == bobTop) {
                    int aliceValue = aliceValues[i];
                    if (aliceValue > tempAliceValue) {
                        tempAliceValue = aliceValue;
                        theindex = i;
                    }
                }
            }

            scores[0] = scores[0] + tempAliceValue;
            if (aliceValues.length > 1) {
                int[] newaliceVals = new int[aliceValues.length - 1];
                int[] newbobVals = new int[bobValues.length - 1];
                int newarrayindex = 0;
                for (int i = 0; i < aliceValues.length; i++) {
                    if (i == theindex) {
                        continue;
                    } else {
                        newaliceVals[newarrayindex] = aliceValues[i];
                        newbobVals[newarrayindex] = bobValues[i];
                        newarrayindex++;
                    }
                }
                getScores(newaliceVals, newbobVals, !isAliceTurn, scores);
            }
        }
    }

//    public int stoneGameVI2(int[] aliceValues, int[] bobValues) {
//        int retval = 0;
//
//        Map<Integer, List<Integer>> aliceValuesMap = getTheMap(aliceValues);
//        Map<Integer, List<Integer>> bobValuesMap = getTheMap(bobValues);
//
//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        };
//        PriorityQueue<Integer> aliceQ = new PriorityQueue<>(comparator);
//        aliceQ.addAll(Arrays.stream(aliceValues).mapToObj(x -> x).collect(Collectors.toList()));
//
//        PriorityQueue<Integer> bobQ = new PriorityQueue<>(comparator);
//        bobQ.addAll(Arrays.stream(bobValues).mapToObj(x -> x).collect(Collectors.toList()));
//
//        List<Integer> availableSlots = IntStream.range(0, aliceValues.length).mapToObj(x -> x).collect(Collectors.toList());
//
//        return doCalc(aliceValuesMap, bobValuesMap, availableSlots, aliceQ, bobQ, aliceValues, bobValues);
//    }
//
//    private int doCalc(Map<Integer, List<Integer>> aliceValuesMap, Map<Integer, List<Integer>> bobValuesMap,
//                       List<Integer> availableSlots,
//                       PriorityQueue<Integer> aliceQ, PriorityQueue<Integer> bobQ,
//                       int[] aliceValues, int[] bobValues
//    ) {
//        int retval = 0;
//
//        int aliceMaxVal = 0;
//        int bobMaxVal = 0;
//        boolean aliceTurn = true;
//
//        int aliceScore = 0;
//        int bobScore = 0;
//        while (availableSlots.size() > 0) {
//            if (!aliceQ.isEmpty()) {
//                aliceMaxVal = aliceQ.peek();
//            }
//            if (!bobQ.isEmpty()) {
//                bobMaxVal = bobQ.peek();
//            }
//
//            if (aliceTurn) {
//                //  - do aliceStuff
//                int newaliceScore = getMyScore(aliceValuesMap, bobValuesMap, availableSlots, aliceQ, bobQ, aliceValues, aliceMaxVal, bobMaxVal, aliceScore);
//                if (newaliceScore == -1) {
//                    aliceMaxVal = 0;
//                    bobMaxVal = 0;
//                    continue;
//                } else
//                    aliceScore = newaliceScore;
//
//                aliceTurn = false;
//            } else {
//                //  - do bob stuff
//                int newbobScore = getMyScore(bobValuesMap, aliceValuesMap, availableSlots, bobQ, aliceQ, bobValues, bobMaxVal, aliceMaxVal, bobScore);
//                if (newbobScore == -1) {
//                    aliceMaxVal = 0;
//                    bobMaxVal = 0;
//                    continue;
//                } else
//                    bobScore = newbobScore;
//
//                aliceTurn = true;
//            }
//            aliceMaxVal = 0;
//            bobMaxVal = 0;
//        }
//
//        retval = (aliceScore > bobScore) ? 1 : ((aliceScore == bobScore) ? 0 : -1);
//        return retval;
//    }
//
//    // if myScore returns -1, then it is a missing index, should start from beginning
//    // but still his turn.
//    private static int getMyScore(Map<Integer, List<Integer>> myValuesMap, Map<Integer, List<Integer>> yourValuesMap,
//                                  List<Integer> availableSlots, PriorityQueue<Integer> myQ, PriorityQueue<Integer> yourQ,
//                                  int[] myValues, int myMaxValue, int yourMaxValue, int myScore) {
//        if (myMaxValue >= yourMaxValue) {
//            myQ.poll();
//            int index = getAndRemoveIndex(myValuesMap, myMaxValue);
//            if (index == -1)
//                return -1;
//            Integer valueOfIndex = Integer.valueOf(index);
//
//            if (availableSlots.contains(valueOfIndex)) {
//                myScore += myMaxValue;
//                availableSlots.remove(valueOfIndex);
//            } else {
//                return -1;
//            }
//
//        } else {
//            //yourQ.poll();
//            int index = getAndRemoveIndex(yourValuesMap, yourMaxValue);
//            if (index == -1)
//                return -1;
//
//            Integer valueOfIndex = Integer.valueOf(index);
//
//            if (availableSlots.contains(valueOfIndex)) {
//                yourQ.poll(); // because this is taking place
//                int mytempvalue = myValues[index];
//                myScore += mytempvalue;
//                availableSlots.remove(Integer.valueOf(index));
//                myQ.remove(Integer.valueOf(mytempvalue));
//            } else {
//                return -1;
//            }
//        }
//        return myScore;
//    }
//
//    // for this implementation, lets take just the first one
//    private static int getAndRemoveIndex(Map<Integer, List<Integer>> myValuesMap, int myMaxValue) {
//        List<Integer> vals = myValuesMap.get(myMaxValue);
//        int index = -1;
//        if (vals.size() > 0) {
//            index = vals.get(0);
//            // also need to remove it from the list
//            vals.remove(0);
//            myValuesMap.put(myMaxValue, vals);
//        }
//
//        return index;
//    }
//
//    // unfortunately there are duplicates
//    private Map<Integer, List<Integer>> getTheMap(int[] aliceValues) {
//        // this is the value -> index map, it will give such as:
//        // 1 -> 0 if alice values index 0 to be worth 1 point
//        Map<Integer, List<Integer>> retval = new HashMap<>();
//
//        for (int i = 0; i < aliceValues.length; i++) {
//            List<Integer> vals = retval.get(aliceValues[i]);
//            if (vals == null)
//                vals = new ArrayList<>();
//            vals.add(i);
//            retval.put(aliceValues[i], vals);
//        }
//        return retval;
//    }
}
