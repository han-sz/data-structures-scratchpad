package com.hshersy.algorithm;

import java.util.Objects;

public class BinarySearch<T extends Comparable<T>> {
    public int binarySearch(T[] arr, T target) {
        Objects.requireNonNull(arr);
        Objects.requireNonNull(target);

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid].equals(target)) {
                return mid;
            }
            if (arr[mid].compareTo(target) > 0) {
                right = mid - 1;
            } else if (arr[mid].compareTo(target) < 0) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
