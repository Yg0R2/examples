package yg0r2.example.spring.jpa.onetomany.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import yg0r2.example.spring.jpa.dao.ExampleDao;
import yg0r2.example.spring.jpa.onetomany.dao.exception.ItemNotFoundException;
import yg0r2.example.spring.jpa.onetomany.dao.model.ItemEntity;
import yg0r2.example.spring.jpa.onetomany.dao.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class ItemDao implements ExampleDao<ItemEntity> {

    @Autowired
    private ItemRepository itemRepository;

    public ItemEntity create(ItemEntity item) {
        return itemRepository.save(item);
    }

    public List<ItemEntity> getAllByIds(List<Long> ids) {
        var items = itemRepository.findAllById(ids);

        return verifyAllItemsFoundById(ids, items);
    }

    public Optional<ItemEntity> getById(long id) {
        return itemRepository.findById(id);
    }

    private List<ItemEntity> verifyAllItemsFoundById(List<Long> ids, List<ItemEntity> items) {
        if (ids.size() == items.size()) {
            return items;
        }

        var foundIds = items.stream()
            .map(ItemEntity::getId)
            .toList();

        var missingIds = ids.stream()
            .filter(id -> !foundIds.contains(id))
            .mapToLong(id  -> id)
            .toArray();

        throw new ItemNotFoundException(missingIds);
    }

    public void deleteById(long id) {
        itemRepository.deleteById(id);
    }

}
