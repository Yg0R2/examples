package yg0r2.examples.auth.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

@JsonDeserialize(builder = LoginRequest.Builder.class)
public final class LoginRequest {

    private final String password;
    private final String userName;

    private LoginRequest(Builder builder) {
        password = Objects.requireNonNull(builder.password);
        userName = Objects.requireNonNull(builder.userName);
    }

    public LoginRequest(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public static class Builder {

        private String password;
        private String userName;

        public Builder withPassword(String password) {
            this.password = password;

            return this;
        }

        public Builder withUserName(String userName) {
            this.userName = userName;

            return this;
        }

        public LoginRequest build() {
            return new LoginRequest(this);
        }

    }

}
