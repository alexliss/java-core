package com.redspot;

import com.redspot.exceptions.MyArrayDataException;
import com.redspot.exceptions.MyArraySizeException;

public class Main {

    public static void main(String[] args) {
        // First task
        /*Movable[] contestants = new Movable[] { new Human(), new Cat(), new Robot() };
        Obstacle[] obstacles = new Obstacle[] {
                new Wall(0.5F),
                new Treadmill(200),
                new Wall(2.5F),
                new Treadmill(700)};
        for (Movable contestant: contestants) {
            for (Obstacle obstacle: obstacles) {
                obstacle.goThough(contestant);
            }
        }*/

        // Second task
        String[][] array = new String[][] {
                {"2", "8", "16", "32"},
                {"13", "7", "3", "1"},
                {"25", "2", "4", "3"},
                {"3", "9", "5", "0"}
        };
        String[][] array2 = new String[][]{
                {"2", "8", "16", "32"},
                {"13", "7", "3", "1"},
                {"25", "2", "4", "3"}
        };
        String[][] array3 = new String[][]{
                {"2", "8", "16", "32"},
                {"13", "7", "3"},
                {"25", "2", "4", "3"},
                {"3", "9", "5", "0"}
        };
        String[][] array4 = new String[][] {
                {"2", "8", "16", "32"},
                {"13", "7", "3", "1"},
                {"25", "2", "4", "3"},
                {"3", "9", "meh", "0"}
        };
        try {
            System.out.println(ArrayProcess.myArraySum(array));
        } catch (MyArraySizeException e) {
            System.out.println("Неподходящий размер массива, должен быть 4х4");
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка: в ячейке [" + e.getI() + "][" + e.getJ() + "] некорректное значение {" + e.getValue() + "}, должно быть целое число");
        }
        try {
            System.out.println(ArrayProcess.myArraySum(array2));
        } catch (MyArraySizeException e) {
            System.out.println("Неподходящий размер массива, должен быть 4х4");
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка: в ячейке [" + e.getI() + "][" + e.getJ() + "] некорректное значение {" + e.getValue() + "}, должно быть целое число");
        }
        try {
            System.out.println(ArrayProcess.myArraySum(array3));
        } catch (MyArraySizeException e) {
            System.out.println("Неподходящий размер массива, должен быть 4х4");
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка: в ячейке [" + e.getI() + "][" + e.getJ() + "] некорректное значение {" + e.getValue() + "}, должно быть целое число");
        }
        try {
            System.out.println(ArrayProcess.myArraySum(array4));
        } catch (MyArraySizeException e) {
            System.out.println("Неподходящий размер массива, должен быть 4х4");
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка: в ячейке [" + e.getI() + "][" + e.getJ() + "] некорректное значение {" + e.getValue() + "}, должно быть целое число");
        }
    }
}
