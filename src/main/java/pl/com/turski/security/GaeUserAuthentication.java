package pl.com.turski.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import pl.com.turski.model.domain.user.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User: Adam
 */
public class GaeUserAuthentication implements Authentication {

    private User principal;
    private Object credentials;
    private Object details;
    private String name;
    private List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getDetails() {
        return details;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public GaeUserAuthentication(User principal, Object details) {
        this.principal = principal;
        this.details = details;
    }
}
