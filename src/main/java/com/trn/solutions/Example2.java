package com.trn.solutions;

import java.util.Arrays;

public class Example2 {
    public static void main(String[] args) {

        int array[]=new int[]{5,6,3,1,4,7,8,9,2,11,12,2,4,6,9,4,1};
        int array22[]=new int[]{5,4,0,3,1,6,2};

        int k = solutionB(array22);
        System.out.print(k);
    }

    private static boolean contains(int[] A, int val) {

        for (int i = 0; i < A.length; i++) {
            if (A[i] == val)
                return true;

        }
        return false;
    }

    private static int size(int[] A) {
        int ctr = 0;
        for (int i = 0; i < A.length; i++) {

            if (A[i] != -1) {
                ctr += A[i];
            }
        }
        return ctr;
    }

    public static int solutionB(int[] A) {
        int len = A.length;
        if (len == 0)
            return 0;

        int max = -1,  size = 0, tempVal = 0, ctr = 0;
        boolean cond = false;
        int[] numsA = new int[len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(numsA, -1);
            ctr = 0;
            tempVal = i;
            while (ctr < len) {
                tempVal = A[tempVal];
                cond = (tempVal >= 0 && tempVal < len);
                if (!cond)
                    break;
                if (!contains(numsA, tempVal))
                    numsA[A[tempVal]]++;
                ctr++;
            }
            size = size(numsA);
            if (size > max)
                max = size;
        }
        return max;
    }
}
