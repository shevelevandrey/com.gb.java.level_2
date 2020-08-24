package com.geekbrains.java.level_2.lesson_1;

import java.util.Arrays;

public class Main {

    /**
     *
     * 1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
     * Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
     * 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые,
     * участники должны выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
     * 3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
     * * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
     * Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
     *
     * */

    public static void main(String[] args) {
        Sportsman[] sportsmens = new Sportsman[] {
                new Human("Mike", 2000f, 1.2f),
                new Human("Andrey", 1200f, 1.4f),
                new Human("Maria", 5000f, 2.1f),
                new Cat("Tom", 8000f, 1.9f),
                new Cat("Keetie", 5000f, 1.6f),
                new Android("Jupiter", 10000f, 2.2f)

        };
        Let[] lets = new Let[] {
                new Track(1000),
                new Wall(1),
                new Track(1500),
                new Wall(2),
                new Track(5)
        };

        System.out.println("На старт! Внимание! Марш!!!\n");

        for (Let let: lets) {
            for (Sportsman sportsman: sportsmens) {
                let.execute(sportsman);
            }
            System.out.println();
        }

        System.out.println("\nДо финиша дошли:");
        Arrays.stream(sportsmens).forEach(s -> {
            if (s.isActive()) System.out.printf("%s[%s];%n", s.getClass().getSimpleName(), s.getName());
        });
    }

}
