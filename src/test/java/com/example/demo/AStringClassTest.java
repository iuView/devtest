package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.array;
import static org.junit.jupiter.api.Assertions.*;

class AStringClassTest {

    @Test
    void getAllVows() {
        AStringClass aStringClass = new AStringClass();
        List<Character> vals = aStringClass.getAllVows();

        assertThat(vals).isNotEmpty();
        assertThat(vals.size()).isEqualTo(10);
    }

    @Test
    void getSolution() {
        AStringClass aStringClass = new AStringClass();

        String val = aStringClass.reverseVowels("hello");


        assertThat(val).isEqualTo("holle");
    }

    @Test
    void isAlienSorted() {
        AStringClass aStringClass = new AStringClass();
        String[] arr = {"ab", "cd"};
        assertThat(
                aStringClass.isAlienSorted(arr, "abcddef")).isTrue();


    }

    @Test
    void sortWords() {
        AStringClass aStringClass = new AStringClass();
        String[] arr = {"ab", "cd"};
        assertThat(aStringClass.sortWords(arr, "abcdefg")).
                containsExactlyElementsOf(Arrays.asList("ab", "cd"));

        String[] arr2 = {"ab", "cd"};
        assertThat(aStringClass.sortWords(arr2, "gfedcba")).
                containsExactlyElementsOf(Arrays.asList("cd", "ab"));

        String[] arr3 = {"abc", "ab"};
        assertThat(aStringClass.sortWords(arr3, "abcdefg")).
                containsExactlyElementsOf(Arrays.asList("ab", "abc"));
    }

    @Test
    void reverseVowels() {
    }

    @Test
    void findWords() {
        String[] input = {"Hello", "Alaska", "Dad", "Peace"};
        AStringClass aStringClass = new AStringClass();
        String[] retval = aStringClass.findWords(input);
        assertThat(retval).hasSameElementsAs(Arrays.asList("Alaska", "Dad"));
    }

    @Test
    void findRestaurant() {
        String[] listone = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] listtwo = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        AStringClass aStringClass = new AStringClass();

        String[] val = aStringClass.findRestaurant(listone, listtwo);
        assertThat(val).isNotNull();
    }

    @Test
    void freqAlphabets() {
        AStringClass aStringClass = new AStringClass();
        String input = "10#11#12";
        String expected = "jkab";
        String val = aStringClass.freqAlphabets(input);
        assertThat(val).isEqualTo(expected);
    }

    @Test
    void reorderSpaces() {
        AStringClass aStringClass = new AStringClass();
        String input = "  this   is  a sentence ";
        String val = aStringClass.reorderSpaces(input);
        assertThat(val).isNotNull();
    }

    @Test
    void isAcronym() {
        AStringClass aStringClass = new AStringClass();
        boolean val = aStringClass.isAcronym(Arrays.asList("apple", "banana"), "ab");
        assertThat(val).isTrue();
    }

    @Test
    void countMatches() {
        AStringClass aStringClass = new AStringClass();
        List<List<String>> items = Arrays.asList(Arrays.asList("phone", "blue", "pixel"),
                Arrays.asList("computer", "silver", "lenovo"),
                Arrays.asList("phone", "gold", "iphone"));
        String ruleKey = "color";
        String ruleValue = "silver";
        int val = aStringClass.countMatches(items, ruleKey, ruleValue);
        assertThat(val).isEqualTo(1);
    }
}