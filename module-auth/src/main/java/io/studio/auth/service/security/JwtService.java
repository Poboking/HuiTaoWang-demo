package io.studio.auth.service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.studio.auth.dal.mysql.InvalidTokensMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * Date:2023/12/4 19:43
 *
 * @Author:poboking
 */
@Service
@RequiredArgsConstructor
public class JwtService {
    private final String SECRET_KEY = "this0is0a0test0key0for0jwt0security012345678901234567890123456789012";

    @Resource
    private final InvalidTokensMapper mapper;

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }

    public String generateToken(
            Map<String, Object> extractClaims,
            UserDetails userDetails
    ){
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 判断传递token是否有效(username是否相等, 是否未过期)
     * @param token string
     * @param userDetails UserDetails
     * @return boolean of valid
     */
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUserName(token);
        return Objects.equals(username,userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否处于失效列表
     * @param token Token
     * @return boolean of invalid
     */
    public boolean isTokenInvalid(String token){
        return !Objects.isNull(mapper.findByToken(token));
    }
    public boolean invalidateToken(String token){
        return mapper.insertToken(token) > 0;
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
