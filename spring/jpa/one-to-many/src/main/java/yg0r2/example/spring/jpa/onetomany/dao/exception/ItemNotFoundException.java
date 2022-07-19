package yg0r2.example.spring.jpa.onetomany.dao.exception;

import java.util.Arrays;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(long... id) {
        super("Item not found with id(s): " + Arrays.toString(id));
    }

}
