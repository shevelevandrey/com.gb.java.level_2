package com.geekbrains.java.level_2.lesson_1;

public class Cat implements Sportsman {
    private String name;
    private float runLimit;
    private float jumpLimit;
    private boolean active;

    public Cat(String name, float runLimit, float jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.active = true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run(Track track) {
        if (active) {
            if (track.getSize() >= runLimit) {
                System.out.printf("%s[%s] не смог пробежать трэк. Длина трека: %.2f, предел спортсмена: %.2f.%n", this.getClass().getSimpleName(), getName(), track.getSize(), runLimit);
                active = false;
            } else {
                System.out.printf("%s[%s] успешно пробежал трэк. Длина трека: %.2f, предел спортсмена: %.2f.%n", this.getClass().getSimpleName(), getName(), track.getSize(), runLimit);
            }
        }
    }

    @Override
    public void jump(Wall wall) {
        if (active) {
            if (wall.getSize() > jumpLimit) {
                System.out.printf("%s[%s] не смог перепрыгнуть стену. Высота стены: %.2f, предел спортсмена: %.2f.%n", this.getClass().getSimpleName(), getName(), wall.getSize(), jumpLimit);
                active = false;
            } else {
                System.out.printf("%s[%s] успешно перепрыгнул стену. Высота стены: %.2f, предел спортсмена: %.2f.%n", this.getClass().getSimpleName(), getName(), wall.getSize(), jumpLimit);
            }
        }
    }

    @Override
    public boolean isActive() {
        return active;
    }
}
