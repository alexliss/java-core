package com.redspot;

public class Cat implements Movable {
    final static float jumpHeight = 1.5F;
    final static int runDistance = 150;
    boolean ableToContinue = true;
    @Override
    public void run(int distance) {
        if (ableToContinue) {
            if (distance <= runDistance) {
                System.out.println("Котик пробежал");
            } else {
                System.out.println("Котик не смог :с");
                ableToContinue = false;
            }
        } else {
            System.out.println("Котик не может продолжать");
        }
    }

    @Override
    public void jump(float height) {
        if (ableToContinue) {
            if (height <= jumpHeight) {
                System.out.println("Котик прыгнул!");
            } else {
                System.out.println("Котик не смог :с");
                ableToContinue = false;
            }
        } else {
            System.out.println("Котик не может продолжать");
        }
    }
}
