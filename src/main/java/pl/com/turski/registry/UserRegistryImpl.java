package pl.com.turski.registry;

import org.springframework.stereotype.Service;
import pl.com.turski.model.domain.user.GaeUser;

/**
 * User: Adam
 */
@Service
public class UserRegistryImpl implements UserRegistry {
    @Override
    public GaeUser findUser(String userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void registerUser(GaeUser newUser) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeUser(String userId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
