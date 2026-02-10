package com.hshersy.container;

public record Vertex<T>(int id, T value, Vertex<T>... children) { }