package com.redspot;

import com.redspot.exceptions.MyArrayDataException;
import com.redspot.exceptions.MyArraySizeException;

import static java.lang.Integer.parseInt;

public class ArrayProcess {
    public static int myArraySum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j ++) {
                try {
                    sum += parseInt(array[i][j]);
                } catch (NumberFormatException nfe) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }
        return sum;
    }
}
