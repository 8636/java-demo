package string;

import lombok.Data;

import java.util.StringJoiner;

/**
 * Created by duan on 2019/12/16 16:51
 */
@Data
public class User {
    private String username;
    private String password;

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .toString();
    }
}
