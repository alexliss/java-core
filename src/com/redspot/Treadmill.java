package com.redspot;

public class Treadmill extends Obstacle {
    final int distance;

    public Treadmill(int distance) {
        if (distance > 0) {
            this.distance = distance;
        } else {
            this.distance = 200;
        }
    }

    @Override
    void goThough(Movable someone) {
        System.out.println("Впереди беговая дорожка! Нужно пробежать " + distance + " метров");
        someone.run(distance);
    }
}
