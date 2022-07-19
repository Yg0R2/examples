package yg0r2.example.spring.jpa.onetomany;

import yg0r2.example.spring.jpa.onetomany.api.CreateCartRequest;
import yg0r2.example.spring.jpa.onetomany.dao.model.CartEntity;

import java.util.List;

import static yg0r2.example.spring.jpa.onetomany.ItemFixtures.ITEM_ID;
import static yg0r2.example.spring.jpa.onetomany.ItemFixtures.itemEntity;
import static yg0r2.example.spring.jpa.onetomany.api.CreateCartRequest.createCartRequestBuilder;

public final class CartFixtures {

    public static final long CART_ID = 123L;

    private CartFixtures() {
    }

    public static CartEntity cartEntity() {
        var cart = new CartEntity();

        cart.setId(CART_ID);
        cart.setItems(List.of(itemEntity()));

        return cart;
    }

}
