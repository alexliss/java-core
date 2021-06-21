package com.redspot;

public class Main {

    public static void main(String[] args) {
        Movable[] contestants = new Movable[] { new Human(), new Cat(), new Robot() };
        Obstacle[] obstacles = new Obstacle[] {
                new Wall(0.5F),
                new Treadmill(200),
                new Wall(2.5F),
                new Treadmill(700)};
        for (Movable contestant: contestants) {
            for (Obstacle obstacle: obstacles) {
                obstacle.goThough(contestant);
            }
        }
    }
}
