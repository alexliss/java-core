package com.redspot;

public class Robot implements Movable {
    final static float jumpHeight = 3;
    final static int runDistance = 1000;
    boolean ableToContinue = true;
    @Override
    public void run(int distance) {
        if (ableToContinue) {
            if (distance <= runDistance) {
                System.out.println("Робот пробежал");
            } else {
                System.out.println("Робот не смог :с");
                ableToContinue = false;
            }
        } else {
            System.out.println("Робот не может продолжать");
        }
    }

    @Override
    public void jump(float height) {
        if (ableToContinue) {
            if (height <= jumpHeight) {
                System.out.println("Робот прыгнул!");
            } else {
                System.out.println("Робот не смог :с");
                ableToContinue = false;
            }
        } else {
            System.out.println("Робот не может продолжать");
        }
    }
}
