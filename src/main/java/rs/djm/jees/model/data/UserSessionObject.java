package rs.djm.jees.model.data;

import java.io.Serializable;

/**
 * @author djm.rs
 */
public class UserSessionObject implements Serializable {

    private final String username;
    private String name;

    private final boolean validated;

    public UserSessionObject(String username, boolean validated) {
        this.username = username;
        this.validated = validated;
    }

    public boolean isValidated() {
        return this.validated;
    }
}
