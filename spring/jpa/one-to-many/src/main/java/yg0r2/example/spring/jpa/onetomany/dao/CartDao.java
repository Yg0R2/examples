package yg0r2.example.spring.jpa.onetomany.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import yg0r2.example.spring.jpa.dao.ExampleDao;
import yg0r2.example.spring.jpa.onetomany.dao.model.CartEntity;
import yg0r2.example.spring.jpa.onetomany.dao.repository.CartRepository;
import yg0r2.example.spring.jpa.onetomany.dao.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class CartDao implements ExampleDao<CartEntity> {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemDao itemDao;

    public CartEntity create(CartEntity cart, List<Long> itemIds) {
        cart.setItems(itemDao.getAllByIds(itemIds));

        return cartRepository.save(cart);
    }

    public void deleteById(long id) {
        cartRepository.deleteById(id);
    }

    public Optional<CartEntity> getById(long id) {
        return cartRepository.findById(id);
    }

}
