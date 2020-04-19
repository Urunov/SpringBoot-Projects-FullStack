package spring.authenticate.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import spring.authenticate.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Created 17 / 04 / 2020 - 4:13 PM
 * @project SpringAuthenticateDB
 * @Author Hamdamboy
 */
public class UserPrincipal implements UserDetails {

    private User user;

    public UserPrincipal(User user){
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        //Extract list of permission (name)
        this.user.getPermissionList().forEach(p-> {
            GrantedAuthority authority = new SimpleGrantedAuthority(p);
            authorityList.add(authority);
        });

        // Extract list of permission (ROLE_name)
        this.user.getRoleList().forEach(p-> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + p);
            authorityList.add(authority);
        });
        return authorityList;
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
        return this.user.getActive()==1;
    }
}
