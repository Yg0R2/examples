package org.examples.supermarket.service;

import org.examples.supermarket.exceptions.NoSuchItemException;
import org.examples.supermarket.model.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cart {

    private final Map<Item, Integer> items = new HashMap<>();

    public void addItem(Item item, int amount) {
        items.compute(item, (k, v) -> Objects.requireNonNullElse(v, 0) + amount);
    }

    public Map<Item, Integer> getItems() {
        return Map.copyOf(items);
    }

    public void removeItem(Item item, int amount) {
        if (!items.containsKey(item)) {
            throw new NoSuchItemException("Cart does not contains the requested item:" + item.getName());
        }
    }

}
