package yg0r2.examples.user.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@JsonDeserialize(builder = CreateUserRequest.Builder.class)
public class CreateUserRequest {

    @NotBlank
    private final String password;
    @NotBlank
    private final String userName;

    private CreateUserRequest(Builder builder) {
        password = Objects.requireNonNull(builder.password);
        userName = Objects.requireNonNull(builder.userName);
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

        public CreateUserRequest build() {
            return new CreateUserRequest(this);
        }

    }

}
