package com.redspot;

public interface Movable {
    default void run(int distance) {
        System.out.println("Что-то пробежало");
    }

    default void jump(float height) {
        System.out.println("Что-то прыгнуло");
    }
}
