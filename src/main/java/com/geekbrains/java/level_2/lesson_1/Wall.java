package com.geekbrains.java.level_2.lesson_1;

public class Wall implements Let {
    private float size;

    public Wall(int size) {
        this.size = size;
    }

    @Override
    public void execute(Sportsman sportsman) {
        sportsman.jump(this);
    }

    @Override
    public float getSize() {
        return size;
    }
}
