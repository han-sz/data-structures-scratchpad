package com.hshersy.algorithm;

import com.hshersy.container.Vertex;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TopologicalSortTest {

    @Test
    public void should_returnACorrectOrder_whenTopologicallySorted() {
        final Map<Vertex<Void>, Vertex<Void>[]> adjacencyList = adjacencyList();

        final List<Vertex<Void>> result = new TopologicalSort<Void>()
                .topologicalSort(adjacencyList);

        // We can only check the last items of the result since Map keySet() order is not guaranteed,
        // but we expect the vertexes with out-degree of 0  to be at the end of the topologically ordered list
        assertArrayEquals(
                new Integer[]{3, 5},
                result.subList(result.size() - 2, result.size())
                        .stream()
                        .map(Vertex::id)
                        .toArray(Integer[]::new)
        );
    }

    private static Map<Vertex<Void>, Vertex<Void>[]> adjacencyList() {
        /*
         1 -> 3
         2 -> 3
         3 -> 5
         4 -> 2, 3
         5 -> (none)
         */
        Vertex<Void> nodeA = new Vertex<>(1, null);
        Vertex<Void> nodeB = new Vertex<>(2, null);
        Vertex<Void> nodeC = new Vertex<>(3, null);
        Vertex<Void> nodeD = new Vertex<>(4, null);
        Vertex<Void> nodeE = new Vertex<>(5, null);
        return Map.of(
                nodeA, new Vertex[]{nodeC},
                nodeB, new Vertex[]{nodeC},
                nodeC, new Vertex[]{nodeE},
                nodeD, new Vertex[]{nodeB, nodeC},
                nodeE, new Vertex[]{}
        );
    }
}
