package com.gb.java.level_2.lesson_3;

import com.gb.java.level_2.lesson_3.FruitsBasket.FruitBasket;
import com.gb.java.level_2.lesson_3.PhoneBook.PhoneBook;
import com.gb.java.level_2.lesson_3.PhoneBook.PhoneContact;

public class Main {
    public static void main(String[] args) {

        /**
         *
         * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         * Посчитать сколько раз встречается каждое слово.
         *
         * */

        System.out.println("Task #1:");

        FruitBasket basket = new FruitBasket();

        basket.add("apple");
        basket.add("lemon");
        basket.add("orange");
        basket.add("avocado");
        basket.add("avocado");
        basket.add("blackberry");
        basket.add("lemon");
        basket.add("strawberry");
        basket.add("avocado");
        basket.add("kiwi");
        basket.add("orange");
        basket.add("blueberry");
        basket.add("blackberry");
        basket.add("raspberry");
        basket.add("coconut");
        basket.add("kiwi");
        basket.add("strawberry");
        basket.add("lemon");
        basket.add("banana");
        basket.add("peach");
        basket.add("apple");
        basket.add("banana");
        basket.add("coconut");
        basket.add("pineapple");
        basket.add("mango");
        basket.add("watermelon");
        basket.add("grapes");
        basket.add("apple");
        basket.add("pear");
        basket.add("mango");
        basket.add("cantaloupe");
        basket.add("mango");
        basket.add("cherries");
        basket.add("watermelon");

        System.out.printf("Number of apples in the basket: %s;%n", basket.find("apple").size());
        System.out.printf("Show unique fruits in the basket: %s;%n", basket.getUnique());
        System.out.printf("Count the fruits in the basket: %s.%n%n", basket.calculate());


        /**
         *
         * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
         * В этот телефонный справочник с помощью метода add() можно добавлять записи.
         * С помощью метода get() искать номер телефона по фамилии.
         * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
         * тогда при запросе такой фамилии должны выводиться все телефоны.
         *
         * Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять
         * еще дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.).
         * Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().
         *
         * */

        System.out.println("Task #2:");

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add(new PhoneContact("Иванов", "+78001000101"));
        phoneBook.add(new PhoneContact("Петров", "+78001000102"));
        phoneBook.add(new PhoneContact("Сидоров", "+78001000103"));
        phoneBook.add(new PhoneContact("Иванов", "+78001000104"));
        phoneBook.add(new PhoneContact("Фёдоров", "+78001000107"));
        phoneBook.add(new PhoneContact("Сидоров", "+78001000106"));
        phoneBook.add(new PhoneContact("Семенов", "+78001000108"));
        phoneBook.add(new PhoneContact("Макаров", "+78001000109"));
        phoneBook.add(new PhoneContact("Иванов", "+78001000105"));
        phoneBook.add(new PhoneContact("Козлов", "+78001000111"));
        phoneBook.add(new PhoneContact("Степанов", "+78001000110"));
        phoneBook.add(new PhoneContact("Иванова", "+78001000112"));

        System.out.printf("Find a contact with the occurrence of the name \"Иванов\": %s.%n", phoneBook.get("Иванов"));
    }
}
