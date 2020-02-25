package entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserPrincipal implements UserDetails {
    //
    private User user;

    public UserPrincipal(User user) {
        super();
        this.user = user;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collection.singleton(new SimpleGrantedAuthority("USER"));

    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
