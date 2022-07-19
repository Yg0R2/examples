package yg0r2.example.spring.jpa.onetomany.service;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yg0r2.example.spring.jpa.onetomany.ItemFixtures;
import yg0r2.example.spring.jpa.onetomany.api.CreateItemRequest;
import yg0r2.example.spring.jpa.onetomany.dao.exception.ItemNotFoundException;
import yg0r2.example.spring.jpa.onetomany.dao.model.CartEntity;
import yg0r2.example.spring.jpa.onetomany.dao.model.ItemEntity;
import yg0r2.example.spring.jpa.onetomany.dao.repository.CartRepository;
import yg0r2.example.spring.jpa.onetomany.dao.repository.ItemRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static yg0r2.example.spring.jpa.onetomany.CartFixtures.CART_ID;
import static yg0r2.example.spring.jpa.onetomany.CartFixtures.cartEntity;
import static yg0r2.example.spring.jpa.onetomany.ItemFixtures.ITEM_ID;
import static yg0r2.example.spring.jpa.onetomany.api.CreateCartRequest.createCartRequestBuilder;
import static yg0r2.example.spring.jpa.onetomany.api.CreateItemRequest.createItemRequestBuilder;

@SpringBootTest
class CartServiceIntegrationTest {

    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemRepository itemRepository;

    private CartEntity cart;
    private ItemEntity item;

    @BeforeEach
    void setUp() {
        var createItemRequest = createItemRequestBuilder()
            .build();

        item = itemService.create(createItemRequest);

        var createCartRequest = createCartRequestBuilder()
            .withItemIds(List.of(item.getId()))
            .build();

        cart = cartService.create(createCartRequest);
    }

    @Test
    void test_create() {
        var createCartRequest = createCartRequestBuilder()
            .withItemIds(List.of(item.getId()))
            .build();

        var actual = cartService.create(createCartRequest);

        assertThat(actual.getId()).isGreaterThan(0);
        assertThat(actual.getItems())
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(item);
    }

    @Test
    void test_create_shouldFail_whenItemDoesNotExist() {
        var createCartRequest = createCartRequestBuilder()
            .withItemIds(List.of(ITEM_ID))
            .build();

        assertThatThrownBy(() -> cartService.create(createCartRequest))
            .isInstanceOf(ItemNotFoundException.class)
            .hasMessage("Item not found with id(s): [" + ITEM_ID + "]");
    }

    @Test
    void test_create_withoutItems() {
        var createCartRequest = createCartRequestBuilder()
            .withItemIds(List.of())
            .build();

        var actual = cartService.create(createCartRequest);

        assertThat(actual.getId()).isGreaterThan(0);
        assertThat(actual.getItems()).isEmpty();
    }

    @Test
    void test_delete() {
        cartService.deleteById(cart.getId());

        assertThat(cartRepository.findById(cart.getId())).isEmpty();
        assertThat(itemRepository.findById(item.getId())).isEmpty();
    }

    @Test
    void test_delete_whenCartDoesNotExist() {
        cartService.deleteById(CART_ID);

        assertThat(cartRepository.findById(CART_ID)).isEmpty();
    }

}