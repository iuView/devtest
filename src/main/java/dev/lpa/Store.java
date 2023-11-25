package dev.lpa;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {

    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();

    public static void main(String[] args) {

        storeProducts.add(new ArtObject("Oil Painting", 1350,
                "Impressionistic work by ABF painted in 2010"));

        storeProducts.add(new ArtObject("Sculpture", 2000,
                "Bronze work by JKF, produced in 1950"));

        listProducts();
    }

    public static void listProducts() {

        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();

        for (var item : storeProducts) {
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }
}
