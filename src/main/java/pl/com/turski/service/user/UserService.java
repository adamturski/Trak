package pl.com.turski.service.user;

import org.springframework.validation.annotation.Validated;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.user.User;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Validated
public interface UserService {

    public void create() throws TechnicalException, BusinessException;

    public void update() throws TechnicalException, BusinessException;

    public User findByEmail(@NotNull String email) throws TechnicalException, BusinessException;

    public User get(@NotNull Long id) throws TechnicalException, BusinessException;

    public List<User> getAll() throws TechnicalException, BusinessException;
}
