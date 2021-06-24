package com.redspot.exceptions;

public class MyArrayDataException extends Exception {
    private final int i, j;
    private final String value;

    public MyArrayDataException(int i, int j, String value) {
        super();
        this.i = i;
        this.j = j;
        this.value = value;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public String getValue() {
        return value;
    }
}
