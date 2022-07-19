package yg0r2.example.spring.jpa.onetomany.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import yg0r2.example.spring.jpa.onetomany.api.CreateItemRequest;
import yg0r2.example.spring.jpa.onetomany.dao.ItemDao;
import yg0r2.example.spring.jpa.onetomany.dao.exception.ItemNotFoundException;
import yg0r2.example.spring.jpa.onetomany.dao.model.ItemEntity;

@Service
public class ItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemService.class);

    @Autowired
    private ItemDao itemDao;

    public ItemEntity create(CreateItemRequest createItemRequest) {
        var item = new ItemEntity();

        return itemDao.create(item);
    }

    public void deleteById(long id) {
        try {
            itemDao.deleteById(id);
        }
        catch (EmptyResultDataAccessException exception) {
            LOGGER.warn("Failed to delete Cart with id: {}", id);
        }
    }

    public ItemEntity getById(long id) {
        return itemDao.getById(id)
            .orElseThrow(() -> new ItemNotFoundException(id));
    }

}
