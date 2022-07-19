package yg0r2.example.spring.jpa.onetomany;

import yg0r2.example.spring.jpa.onetomany.dao.model.ItemEntity;

public final class ItemFixtures {

    public static final long ITEM_ID = 234L;

    private ItemFixtures() {
    }

    public static ItemEntity itemEntity() {
        var item = new ItemEntity();

        item.setId(ITEM_ID);

        return item;
    }

}
