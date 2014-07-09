package pl.com.turski.model.domain.user;

import java.io.Serializable;
import java.util.Set;

/**
 * User: Adam
 */
public class GaeUser implements Serializable {
    private String userId;
    private String email;
    private String nickname;
    private String forename;
    private String surname;
    private Set<Role> authorities;
    private boolean enabled;

    public GaeUser() {
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
