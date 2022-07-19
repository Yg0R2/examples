package yg0r2.example.spring.jpa.onetomany.api;

public class CreateItemRequest {

    private CreateItemRequest(Builder builder) {
    }

    public static Builder createItemRequestBuilder() {
        return new Builder();
    }

    public static class Builder {

        protected Builder() {
        }

        public CreateItemRequest build() {
            return new CreateItemRequest(this);
        }

    }

}
