package org.taskmanagementsystem.tms.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

@Component
@Slf4j
public class JwtUtilis {
    private final long jwtExpiration = 86400000;
    private SecretKey secretKey;

    @Value("${secretJwtString}")
    private String secretJwtString;

    @PostConstruct
    public void init(){
        if(secretJwtString == null || secretJwtString.isEmpty()){
            throw new IllegalArgumentException("JWT SecretKey is not seted");
        }
        log.info("starting JwtUtils");
        byte[] secretByte = secretJwtString.getBytes(StandardCharsets.UTF_8);
        this.secretKey = new SecretKeySpec(secretByte, "HmacSHA256");
    }

    public String generateToken(String email){
        return Jwts.builder().subject(email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ jwtExpiration))
                .signWith(secretKey)
                .compact();
    }
    public String getUsernameFromToken (String token){
            return extractToken(token, Claims::getSubject);
    }

    public <T> T extractToken(String token, Function<Claims,T>claimsTFunction){
        return claimsTFunction.apply(Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload());
    }
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username= getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && isTokenexpired(token)) ;
    }

    public  boolean isTokenexpired(String token){
        return extractToken(token, Claims::getExpiration).before(new Date(System.currentTimeMillis()));
    }

}
