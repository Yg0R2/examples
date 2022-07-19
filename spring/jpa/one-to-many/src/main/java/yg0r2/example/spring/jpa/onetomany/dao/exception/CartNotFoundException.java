package yg0r2.example.spring.jpa.onetomany.dao.exception;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(long id) {
        super("Cart not found with id: " + id);
    }

}
