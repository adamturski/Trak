package pl.com.turski.registry;

import pl.com.turski.model.domain.user.GaeUser;

/**
 * User: Adam
 */
public interface UserRegistry {

    GaeUser findUser(String userId);

    void registerUser(GaeUser newUser);

    void removeUser(String userId);
}
