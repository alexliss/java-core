package com.redspot;

public class ArrayThread extends Thread {
    private final float[] array;
    private final int startIndex;

    public ArrayThread(float[] array, int startIndex) {
        this.array = array;
        this.startIndex= startIndex;
    }

    public float[] getArray() {
        return array;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + (i + startIndex) / 5) * Math.cos(0.2f + (i + startIndex) / 5) * Math.cos(0.4f + (i + startIndex) / 2));
        }
        System.out.println("Половина массива с " + startIndex + " элемента: " + (System.currentTimeMillis() - startTime) + " мс");
    }
}
