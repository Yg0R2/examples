package org.examples.supermarket.service;

import org.examples.supermarket.exceptions.NoSuchItemException;
import org.examples.supermarket.exceptions.NotEnoughItemException;
import org.examples.supermarket.model.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Supermarket {

    private final Map<Item, Integer> inventory;

    private double money;

    public Supermarket(Map<Item, Integer> inventory) {
        this.inventory = new HashMap<>(Objects.requireNonNull(inventory));
    }

    public double buy(Cart cart) {
        double price;
        synchronized(inventory) {

            price = cart.getItems().entrySet().stream()
                .collect(Collectors.summarizingDouble(entry -> buy(new HashMap<Item, Integer>(inventory), entry.getKey(), entry.getValue())))
                .getSum();

            ((Map<Item, Integer>) new HashMap<>(inventory))
                .forEach(inventory::replace);
        }

        money += price;

        return price;
    }

    public Map<Item, Integer> getInventory() {
        return inventory;
    }

    public double getMoney() {
        return money;
    }

    private double buy(Map<Item, Integer> inventory, Item item, int amount) {
        if (!inventory.containsKey(item)) {
            throw new NoSuchItemException("Supermarket does not have the required item: " + item.getName());
        }

        int inventoryAmount = inventory.get(item);
        if (inventoryAmount < amount) {
            throw new NotEnoughItemException("Supermarket does not have enough item: " + item.getName());
        }

        inventory.replace(item, inventoryAmount - amount);

        return amount * item.getBasePrice();
    }

}
