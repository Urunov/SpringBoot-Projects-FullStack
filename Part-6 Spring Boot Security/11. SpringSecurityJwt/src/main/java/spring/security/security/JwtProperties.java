package spring.security.security;

/**
 * @Created 24 / 04 / 2020 - 1:55 PM
 * @project SpringSecurityJWT
 * @Author Hamdamboy
 */
public class JwtProperties {
    public static final String SECRET = "Hamdamboy123";
    public static final  int EXPIRATION_TIME = 864000000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Author";
}
