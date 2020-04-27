package spring.security.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import spring.security.entities.Role;
import spring.security.entities.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Created 09 / 04 / 2020 - 2:18 PM
 * @project SpringSecurity
 * @Author Hamdamboy
 */
public class AuthenticationUser extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;
    private User user;

    public AuthenticationUser(User user){
        super(user.getEmail(), user.getPassword(), getAuthorities(user));
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user){
        Set<String> roleAndPermissions = new HashSet<>();
        List<Role> roles = user.getRoles();

        for(Role role: roles){
            roleAndPermissions.add(role.getName());
        }
        String[] roleNames = new String[roleAndPermissions.size()];
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roleAndPermissions.toArray(roleNames));
        return authorities;
    }
}
