package spring.custom.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import spring.custom.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Created 21 / 04 / 2020 - 11:12 AM
 * @project custom
 * @Author Hamdamboy
 */
public class UserPrincipal implements UserDetails {

    private User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Extract list of permission name
        this.user.getPermissionList().forEach(p-> {
                GrantedAuthority authority = new SimpleGrantedAuthority(p);
                authorities.add(authority);
        });

        // Extract list of roles (ROLE_NAME)
        this.user.getRoleList().forEach(r ->{
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE" + r);
            authorities.add(authority);
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
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
