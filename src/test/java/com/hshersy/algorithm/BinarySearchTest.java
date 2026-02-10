package com.hshersy.algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    @ParameterizedTest
    @MethodSource("binarySearchTestCases")
    void should_findIndex_whenGivenArgs(TestInput testInput) {
        final BinarySearch<Integer> search = new BinarySearch<>();

        assertEquals(testInput.expected(), search.binarySearch(testInput.arr(), testInput.target()),
                "Wrong binary search result returned");
    }

    private static Stream<TestInput> binarySearchTestCases() {
        final Integer[] sortedPositiveNums = {1, 3, 6, 9, 12, 100};
        final Integer[] sortedNegativeNums = {-100, -12, -9, -6, -3, -1};

        return Stream.of(
                // Positive numbers
                new TestInput(sortedPositiveNums, 1, 0),
                new TestInput(sortedPositiveNums, 6, 2),
                new TestInput(sortedPositiveNums, 100, 5),
                // Negative numbers
                new TestInput(sortedNegativeNums, -100, 0),
                new TestInput(sortedNegativeNums, -6, 3),
                new TestInput(sortedNegativeNums, -1, 5)
        );
    }
}

record TestInput(Integer[] arr, int target, int expected) {}
