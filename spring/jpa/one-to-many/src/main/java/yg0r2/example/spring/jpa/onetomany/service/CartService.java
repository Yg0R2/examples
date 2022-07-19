package yg0r2.example.spring.jpa.onetomany.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import yg0r2.example.spring.jpa.onetomany.api.CreateCartRequest;
import yg0r2.example.spring.jpa.onetomany.dao.CartDao;
import yg0r2.example.spring.jpa.onetomany.dao.exception.CartNotFoundException;
import yg0r2.example.spring.jpa.onetomany.dao.model.CartEntity;

@Service
public class CartService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);

    @Autowired
    private CartDao cartDao;

    public CartEntity create(CreateCartRequest createCartRequest) {
        var cart = new CartEntity();

        return cartDao.create(cart, createCartRequest.getItemIds());
    }

    public CartEntity getById(long id) {
        return cartDao.getById(id)
            .orElseThrow(() -> new CartNotFoundException(id));
    }

    public void deleteById(long id) {
        try {
            cartDao.deleteById(id);
        }
        catch (EmptyResultDataAccessException exception) {
            LOGGER.warn("Failed to delete Cart with id: {}", id);
        }
    }

}
