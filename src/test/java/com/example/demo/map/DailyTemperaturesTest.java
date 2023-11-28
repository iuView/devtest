package com.example.demo.map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

//@TestPropertySource("classpath:application-test.properties")
class DailyTemperaturesTest {

    @Value("${data}")
    public String values;

    DailyTemperatures dailyTemperatures = new DailyTemperatures();

    @Test
    void dailyTemperatures() {

        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] target = {1, 1, 4, 2, 1, 1, 0, 0};
        int[] result = dailyTemperatures.dailyTemperatures(temps);
        assertThat(result).isEqualTo(target);
    }

    @Test
    void setDailyTemperaturesLarge() {
        try {
            Properties configProps = new Properties();
            InputStream iStream = new ClassPathResource("application-test.properties").getInputStream();
            configProps.load(iStream);


            String[] strings = configProps.get("data").toString().split(",");
            List<Integer> integerList = Arrays.stream(strings).map(x -> {
                return Integer.parseInt(x.trim());
            }).collect(Collectors.toList());

            int[] a = new int[integerList.size()];
            for (int i = 0; i < integerList.size(); i++) {
                a[i] = integerList.get(i);
            }
            int[] result = dailyTemperatures.dailyTemperatures(a);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void setDailyTemperaturesLargeRepeat() {
        try {
            Properties configProps = new Properties();
            InputStream iStream = new ClassPathResource("application-test.properties").getInputStream();
            configProps.load(iStream);


            String[] strings = configProps.get("datatwo").toString().split(",");
            List<Integer> integerList = Arrays.stream(strings).map(x -> {
                return Integer.parseInt(x.trim());
            }).collect(Collectors.toList());

            int[] a = new int[integerList.size()];
            for (int i = 0; i < integerList.size(); i++) {
                a[i] = integerList.get(i);
            }
            int[] result = dailyTemperatures.dailyTemperatures(a);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}