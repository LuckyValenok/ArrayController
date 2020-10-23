package net.luckyvalenok.arraycontroller;

import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {
        Object[] array1 = {new Object[]{new int[]{1, 2, 3}, new int[]{2, 3}, new int[]{3}}, new Object[]{new int[]{13}}, new Object[]{new int[]{9}}};
        Object[] array2 = {new Object[]{new int[]{1, 2, 3}, new int[]{2, 3}, new int[]{3}}};
        System.out.println(checkArrays(array1, array2));
    }
    
    private static boolean checkArrays(Object[] oneArray, Object[] twoArray) {
        int count = 0;
        for (Object o : oneArray) {
            if (checkEquality(o, twoArray[count]))
                count++;
            else
                count = 0;
            if (count == twoArray.length)
                return true;
        }
        return false;
    }
    
    private static boolean checkEquality(Object one, Object two) {
        if (one instanceof int[] && two instanceof int[]) {
            int[] oneArray = (int[]) one;
            int[] twoArray = (int[]) two;
            return Arrays.equals(oneArray, twoArray);
        } else if (one instanceof Object[] && two instanceof Object[]) {
            Object[] oneArray = (Object[]) one;
            Object[] twoArray = (Object[]) two;
            int count = 0;
            for (Object o : oneArray) {
                if (!checkEquality(o, twoArray[count]))
                    return false;
                else
                    count++;
                if (count == twoArray.length)
                    return true;
            }
            return true;
        } else {
            return one.equals(two);
        }
    }
}
