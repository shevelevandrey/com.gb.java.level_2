package com.gb.java.level_2.lesson_3.FruitsBasket;

import java.util.List;
import java.util.Map;

public interface Basket {
    void add(String element);
    List<String> find(String element);
    Map<String, Integer> calculate();
    List<String> getUnique();
}
