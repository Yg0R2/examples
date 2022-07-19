package yg0r2.example.spring.jpa.onetomany.service;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yg0r2.example.spring.jpa.onetomany.dao.exception.ItemNotFoundException;
import yg0r2.example.spring.jpa.onetomany.dao.model.CartEntity;
import yg0r2.example.spring.jpa.onetomany.dao.model.ItemEntity;
import yg0r2.example.spring.jpa.onetomany.dao.repository.CartRepository;
import yg0r2.example.spring.jpa.onetomany.dao.repository.ItemRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static yg0r2.example.spring.jpa.onetomany.CartFixtures.CART_ID;
import static yg0r2.example.spring.jpa.onetomany.ItemFixtures.ITEM_ID;
import static yg0r2.example.spring.jpa.onetomany.api.CreateCartRequest.createCartRequestBuilder;
import static yg0r2.example.spring.jpa.onetomany.api.CreateItemRequest.createItemRequestBuilder;

@SpringBootTest
class ItemServiceIntegrationTest {

    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemRepository itemRepository;

    private ItemEntity item;

    @BeforeEach
    void setUp() {
        var createItemRequest = createItemRequestBuilder()
            .build();

        item = itemService.create(createItemRequest);
    }

    @Test
    void test_create() {
        var createItemRequest = createItemRequestBuilder()
            .build();

        var actual = itemService.create(createItemRequest);

        assertThat(actual.getId()).isGreaterThan(0);
    }

    @Test
    void test_delete() {
        itemService.deleteById(item.getId());

        assertThat(itemRepository.findById(item.getId())).isEmpty();
    }

    @Test
    void test_delete_whenItemDoesNotExist() {
        itemService.deleteById(ITEM_ID);

        assertThat(itemRepository.findById(ITEM_ID)).isEmpty();
    }

    @Test
    void test_delete_whenItemAssignedToCart() {
        var createCartRequest = createCartRequestBuilder()
            .withItemIds(List.of(item.getId()))
            .build();

        var cart = cartService.create(createCartRequest);

        itemService.deleteById(item.getId());

        assertThat(itemRepository.findById(item.getId())).isEmpty();
        assertThat(cartRepository.findById(cart.getId()))
            .map(CartEntity::getItems)
            .get()
            .asList()
            .isEmpty();
    }

}