package com.geekbrains.java.level_2.lesson_1;

public class Track implements Let {
    private float size;

    public Track(int size) {
        this.size = size;
    }

    @Override
    public void execute(Sportsman sportsman) {
        sportsman.run(this);
    }

    @Override
    public float getSize() {
        return size;
    }
}
