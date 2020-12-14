package org.examples.supermarket;

import org.examples.supermarket.model.Item;
import org.examples.supermarket.service.Cart;
import org.examples.supermarket.service.Supermarket;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SupermarketMain {

    private static final Random RND = new Random();

    public static void main(String[] args) {
        Map<Item, Integer> inventory = IntStream.range(0, 20)
            .mapToObj(i -> createItem())
            .collect(Collectors.toMap(
                Function.identity(),
                item -> (RND.nextInt(50) + 10)
            ));

        Supermarket supermarket = new Supermarket(inventory);

        IntStream.range(0, 5)
            .parallel()
            .forEach(i -> sell(supermarket));
    }

    private static void sell(Supermarket supermarket) {
        Cart cart = new Cart();
        IntStream.range(0, 5)
            .mapToObj(i -> getItem(supermarket.getInventory()))
            .forEach(item -> cart.addItem(item, RND.nextInt(5) + 1));

        System.out.printf("Supermarket sell: %.2f EUR for %s%n", supermarket.buy(cart), itemsToString(cart.getItems()));
        System.out.printf("Supermarket inventory: %s%n", itemsToString(supermarket.getInventory()));
        System.out.printf("Supermarket new balance: %.2f EUR%n", supermarket.getMoney());
        System.out.println();
    }

    private static Item createItem() {
        return new Item.Builder()
            .withBasePrice(RND.nextDouble() * 5)
            .withName(UUID.randomUUID().toString())
            .build();
    }

    private static Item getItem(Map<Item, Integer> inventory) {
        Set<Item> items = inventory.keySet();

        return (Item) items.toArray()[RND.nextInt(items.size())];
    }

    private static String itemsToString(Map<Item, Integer> items) {
        return items.entrySet().stream()
            .map(entry -> String.format("%s - %d", entry.getKey().getName(), entry.getValue()))
            .collect(Collectors.joining(", ", "[", "]"));
    }

}
