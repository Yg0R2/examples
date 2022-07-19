package yg0r2.example.spring.jpa.onetomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import yg0r2.example.spring.jpa.LoggingHelper;
import yg0r2.example.spring.jpa.onetomany.dao.model.CartEntity;
import yg0r2.example.spring.jpa.onetomany.dao.model.ItemEntity;
import yg0r2.example.spring.jpa.onetomany.service.CartService;
import yg0r2.example.spring.jpa.onetomany.service.ItemService;

import java.util.Arrays;
import java.util.stream.Collectors;

import static yg0r2.example.spring.jpa.onetomany.api.CreateCartRequest.createCartRequestBuilder;
import static yg0r2.example.spring.jpa.onetomany.api.CreateItemRequest.createItemRequestBuilder;

@Component
@ComponentScan(basePackages = "yg0r2.example.spring.jpa")
public class SetupWizardApplicationRunner implements ApplicationRunner {

    @Autowired
    private CartService cartService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private LoggingHelper loggingHelper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var item = createItem();
        loggingHelper.logEntityCreation(() -> itemService.getById(item.getId()));

        var cart = createCart(item);
        loggingHelper.logEntityCreation(() -> cartService.getById(cart.getId()));
    }

    private CartEntity createCart(ItemEntity... items) {
        var itemIds = Arrays.stream(items)
            .map(ItemEntity::getId)
            .collect(Collectors.toList());

        var createCartRequest = createCartRequestBuilder()
            .withItemIds(itemIds)
            .build();

        return cartService.create(createCartRequest);
    }

    private ItemEntity createItem() {
        var createItemRequest = createItemRequestBuilder()
            .build();

        return itemService.create(createItemRequest);
    }

}
