package com.redspot;

import com.redspot.exceptions.MyArrayDataException;
import com.redspot.exceptions.MyArraySizeException;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    static final int SIZE = 10_000_001;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        // First task
        Movable[] contestants = new Movable[]{new Human(), new Cat(), new Robot()};
        Obstacle[] obstacles = new Obstacle[]{
                new Wall(0.5F),
                new Treadmill(200),
                new Wall(2.5F),
                new Treadmill(700)};
        for (Movable contestant : contestants) {
            for (Obstacle obstacle : obstacles) {
                obstacle.goThough(contestant);
            }
        }

        // Second task
        String[][] array = new String[][]{
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
        String[][] array4 = new String[][]{
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

        // Task 3

        final String[] array5 = new String[]{"hehe", "meow", "charger", "konserva", "sock", "charger", "hehe", "MEOW", "meow", "charger"};
        final HashMap<String, Integer> copy = new HashMap<>();

        System.out.println(Arrays.toString(array5) + "\n");

        int value = 0;
        for (String str : array5) {
            value = copy.getOrDefault(str, 0);
            copy.put(str, value + 1);
        }

        System.out.println(copy);

        Phonebook phonebook = new Phonebook();
        phonebook.add("Кукушкин", 88005553535L);
        phonebook.add("Кукушкин", 560049L);
        phonebook.add("Сова", 79131231234L);
        phonebook.add("Сова", 88003332211L);
        phonebook.add("Горемыкин", 322483L);
        phonebook.add("Кукушкин", 370049L);

        System.out.println("\n" + phonebook.get("Кукушкин"));
        System.out.println(phonebook.get("Сова"));
        System.out.println(phonebook.get("Горемыкин"));

        task5Fun();
        task5MultithreadedFun();

    }

    private static void task5Fun() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Метод в одном потоке: " + (System.currentTimeMillis() - startTime) + " мс");
    }

    private static void task5MultithreadedFun() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long startTime = System.currentTimeMillis();
        float[] leftHalf;
        float[] rightHalf;
        if (arr.length % 2 == 0) {
            leftHalf = new float[arr.length / 2];
            rightHalf = new float[arr.length / 2];
            System.arraycopy(arr, 0, leftHalf, 0, arr.length / 2);
            System.arraycopy(arr, arr.length / 2, rightHalf, 0, arr.length / 2);
            System.out.println("Деление на два массива: " + (System.currentTimeMillis() - startTime) + " мс");
        } else {
            leftHalf = new float[arr.length / 2];
            rightHalf = new float[arr.length / 2 + 1];
            System.arraycopy(arr, 0, leftHalf, 0, arr.length / 2);
            System.arraycopy(arr, arr.length / 2, rightHalf, 0, arr.length / 2 + 1);
            System.out.println("Деление на два массива: " + (System.currentTimeMillis() - startTime) + " мс");
        }
        ArrayThread thread1 = new ArrayThread(leftHalf, 0);
        ArrayThread thread2 = new ArrayThread(rightHalf, arr.length / 2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long copyTimeStart = System.currentTimeMillis();
        System.arraycopy(thread1.getArray(), 0, arr, 0, HALF);
        System.arraycopy(thread2.getArray(), 0, arr, HALF, HALF);
        long endTime = System.currentTimeMillis();
        System.out.println("Вставка результатов: " + (endTime - copyTimeStart) + " мс");
        System.out.println("Общее время: " + (endTime - startTime) + " мс");
    }
}
