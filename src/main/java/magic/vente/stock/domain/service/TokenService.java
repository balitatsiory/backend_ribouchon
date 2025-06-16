package magic.vente.stock.domain.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import magic.vente.stock.domain.model.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {
    private final String secretKey ;

    public TokenService(@Value("${secret.key}") String secretKey) {
        this.secretKey = secretKey;
    }

    String generateToken(Account account){
        HashMap<String,Object> claims = new HashMap<>();
        claims.put("id",account.getId());
        Timestamp issueAtDate = new Timestamp(System.currentTimeMillis());
        Timestamp expirationDate = new Timestamp(issueAtDate.getTime() + 3600000L);
        return buildToken(claims,account,issueAtDate,expirationDate);
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private String buildToken(
            Map<String, Object> extraClaims,
            Account account,
            Timestamp issuedAt,
            Timestamp expiration
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(account.getUsername())
                .setId(Long.toString(account.getId()))
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
