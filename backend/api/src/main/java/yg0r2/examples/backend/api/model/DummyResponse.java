package yg0r2.examples.backend.api.model;

public final class DummyResponse {

    private final long id;
    private final String title;

    private DummyResponse(Builder builder) {
        id = builder.id;
        title = builder.title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private long id;
        private String title;

        private Builder() {
        }

        public Builder withId(long id) {
            this.id = id;

            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;

            return this;
        }

        public DummyResponse build() {
            return new DummyResponse(this);
        }

    }

}
