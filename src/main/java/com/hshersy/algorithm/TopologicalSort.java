package com.hshersy.algorithm;

import com.hshersy.container.Vertex;

import java.util.*;

public class TopologicalSort<T> {
    public List<Vertex<T>> topologicalSort(Map<Vertex<T>, Vertex<T>[]> adjacency) {
        final Set<Vertex<T>> visited = new HashSet<>();
        final List<Vertex<T>> ordered = new ArrayList<>();

        for (Vertex<T> vertex : adjacency.keySet()) {
            if (visited.contains(vertex)) {
                continue;
            }
            topologicalSortDfsHelper(adjacency, vertex, ordered, visited);

        }
        return ordered.reversed();
    }

    private void topologicalSortDfsHelper(Map<Vertex<T>, Vertex<T>[]> adjacency, Vertex<T> vertex, List<Vertex<T>> ordered, Set<Vertex<T>> visited) {
        if (visited.contains(vertex)) {
            return;
        }
        visited.add(vertex);
        for (Vertex<T> next : adjacency.get(vertex)) {
            topologicalSortDfsHelper(adjacency, next, ordered, visited);
        }
        ordered.add(vertex);

    }
}
