package com.redspot;

public class Human implements Movable {
    float jumpHeight = 0.8F;
    int runDistance = 200;
    boolean ableToContinue = true;

    @Override
    public void run(int distance) {
        if (ableToContinue) {
            if (distance <= runDistance) {
                System.out.println("Человек пробежал");
            } else {
                System.out.println("Человек не смог :с");
                ableToContinue = false;
            }
        } else {
            System.out.println("Человек не может продолжать");
        }
    }

    @Override
    public void jump(float height) {
        if (ableToContinue) {
            if (height <= jumpHeight) {
                System.out.println("Человек прыгнул!");
            } else {
                System.out.println("Человек не смог :с");
                ableToContinue = false;
            }
        } else {
            System.out.println("Человек не может продолжать");
        }
    }
}
