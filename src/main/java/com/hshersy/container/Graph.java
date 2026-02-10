package com.hshersy.container;

import java.util.Map;


public record Graph<T>(Map<Integer, Map.Entry<Vertex<T>, Integer>[]> adjacencyList) { }
