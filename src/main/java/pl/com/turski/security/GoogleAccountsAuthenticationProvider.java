package pl.com.turski.security;

import com.google.appengine.api.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import pl.com.turski.service.user.UserService;

/**
 * User: Adam
 */
public class GoogleAccountsAuthenticationProvider implements AuthenticationProvider {

    private static final Logger LOG = LoggerFactory.getLogger(GoogleAccountsAuthenticationProvider.class);

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User googleUser = (User) authentication.getPrincipal();

        pl.com.turski.model.domain.user.User user = userService.findByEmail(googleUser.getEmail());

        if (user == null) {
            LOG.error("User not found in database");
            throw new UsernameNotFoundException("Username not found");
        }

        if (!user.getEnabled()) {
            LOG.error("Account is disabled");
            throw new DisabledException("Account is disabled");
        }

        return new GaeUserAuthentication(user, authentication.getDetails());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return PreAuthenticatedAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
