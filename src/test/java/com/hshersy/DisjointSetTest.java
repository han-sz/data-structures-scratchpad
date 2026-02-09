package com.hshersy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DisjointSetTest {
    @Test
    public void should_setParents_whenUnion() {
        final DisjointSet<Integer> ds = new DisjointSet<>(List.of(1,2,3,4));
        ds.union(1, 2);
        ds.union(3, 2);
        ds.union(4, 3);

        assertEquals(1, ds.parent.get(1));
        assertEquals(1, ds.parent.get(2));
        assertEquals(1, ds.parent.get(3));
        assertEquals(1, ds.parent.get(4));
    }

    @Test
    public void should_returnCorrectRoot_whenFind() {
        final DisjointSet<Integer> ds = new DisjointSet<>(List.of(1, 2, 3));
        ds.union(1, 2);
        ds.union(2, 3);

        assertEquals(1, ds.find(1));
        assertEquals(1, ds.find(2));
        assertEquals(1, ds.find(3));
    }
}
