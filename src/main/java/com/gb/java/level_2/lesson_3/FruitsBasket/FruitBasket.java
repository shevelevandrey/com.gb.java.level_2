package com.gb.java.level_2.lesson_3.FruitsBasket;

import java.util.*;

public class FruitBasket implements Basket {
    private List<String> fruits;

    public FruitBasket() {
        this.fruits = new ArrayList<>();
    }

    public FruitBasket(List<String> fruits) {
        this.fruits = fruits;
    }

    @Override
    public void add(String element) {
        fruits.add(element);
    }

    @Override
    public List<String> find(String element) {
        List<String> elements = new ArrayList<>();

        for (String fruit : fruits) {
            if (fruit.equals(element)) {
                elements.add(element);
            }
        }
        
        return elements;
    }

    @Override
    public Map<String, Integer> calculate() {
        Map<String, Integer> fruitsMap = new HashMap<>();

        for (String fruit: fruits) {
            if (fruitsMap.containsKey(fruit)) {
                fruitsMap.put(fruit, fruitsMap.get(fruit) + 1);
            } else {
                fruitsMap.put(fruit, 1);
            }
        }

        return fruitsMap;
    }

    @Override
    public List<String> getUnique() {
        List<String> fruits = new ArrayList<>();

        for (Map.Entry<String, Integer> fruit : calculate().entrySet()) {
            if (fruit.getValue() == 1) {
                fruits.add(fruit.getKey());
            }
        }

        return fruits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FruitBasket that = (FruitBasket) o;
        return Objects.equals(fruits, that.fruits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruits);
    }
}
