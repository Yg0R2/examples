package yg0r2.example.spring.jpa.onetomany.api;

import java.util.List;
import java.util.Objects;

public class CreateCartRequest {

    private final List<Long> itemIds;

    private CreateCartRequest(Builder builder) {
        itemIds = List.copyOf(Objects.requireNonNullElseGet(builder.itemIds, List::of));
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public static Builder createCartRequestBuilder() {
        return new Builder();
    }

    public static class Builder {

        private List<Long> itemIds;

        protected Builder() {
        }

        public Builder withItemIds(List<Long> itemIds) {
            this.itemIds = itemIds;

            return this;
        }

        public CreateCartRequest build() {
            return new CreateCartRequest(this);
        }

    }

}
