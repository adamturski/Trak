package pl.com.turski.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.user.User;
import pl.com.turski.repository.user.UserRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create() throws TechnicalException, BusinessException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update() throws TechnicalException, BusinessException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User findByEmail(@NotNull String email) throws TechnicalException, BusinessException {
        LOG.debug("Searching for user [email='{}']", email);
        return userRepository.findByEmail(email);
    }

    @Override
    public User get(@NotNull Long id) throws TechnicalException, BusinessException {
        LOG.debug("Getting user [id='{}']", id);
        return userRepository.findOne(id);
    }

    @Override
    public List<User> getAll() throws TechnicalException, BusinessException {
        LOG.debug("Getting all users");
        return userRepository.findAll();
    }
}
