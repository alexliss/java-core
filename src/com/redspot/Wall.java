package com.redspot;

public class Wall extends Obstacle {
    final float height;

    public Wall(float height) {
        if (height > 0) {
            this.height = height;
        } else {
            this.height = 1;
        }
    }

    @Override
    void goThough(Movable someone) {
        System.out.println("Впереди стена высотой " + height + " метров!");
        someone.jump(height);
    }
}
