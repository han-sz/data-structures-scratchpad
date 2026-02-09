package com.hshersy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class DisjointSet<T extends Integer> {
    protected Map<T, Integer> ranks;
    protected Map<T, T> parent;

    public DisjointSet(List<T> items) {
        this.ranks = new HashMap<>(items.size());
        this.parent = new HashMap<>(items.size());

        items.forEach((item) -> {
            this.ranks.computeIfAbsent(item, (k) -> 0);
            this.parent.computeIfAbsent(item, Function.identity());
        });
    }

    public T find(T item) {
        T current = item;
        while (true) {
            if (Objects.equals(parent.get(current), current)) {
                return current;
            }
            parent.compute(current, (k, v) -> Objects.requireNonNullElse(parent.get(v), parent.get(k)));
            current = parent.get(current);
        }
    }

    public void union(T first, T second) {
        if (!this.parent.containsKey(first) || !this.parent.containsKey(second)) {
            throw new IllegalArgumentException("Item in set doesn't exist");
        }
        final T firstRoot = find(first);
        final T secondRoot = find(second);
        final int firstRank = ranks.get(firstRoot);
        final int secondRank = ranks.get(secondRoot);
        if (firstRank < secondRank) {
            parent.put(firstRoot, secondRoot);
        } else if (firstRank > secondRank) {
            parent.put(secondRoot, firstRoot);
        } else {
            parent.put(secondRoot, firstRoot);
            ranks.compute(firstRoot, (k, rank) -> rank + 1);
        }

    }
}
