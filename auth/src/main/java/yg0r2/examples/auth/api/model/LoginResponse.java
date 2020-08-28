package yg0r2.examples.auth.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

@JsonDeserialize(builder = LoginRequest.Builder.class)
public final class LoginResponse {

    private final String userName;

    private LoginResponse(Builder builder) {
        userName = Objects.requireNonNull(builder.userName);
    }

    public String getUserName() {
        return userName;
    }

    public static class Builder {

        private String userName;

        public Builder withUserName(String userName) {
            this.userName = userName;

            return this;
        }

        public LoginResponse build() {
            return new LoginResponse(this);
        }

    }

}
