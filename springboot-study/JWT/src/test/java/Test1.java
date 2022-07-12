import io.jsonwebtoken.*;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

public class Test1 {

    private String signature="meng";

    @Test
    public void jwt(){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder.
                //header
                setHeaderParam("type", "JWT").
                setHeaderParam("alg", "HS256").
                //payload
                claim("name", "meng").
                claim("age", "18").
                setSubject("meng").
                setIssuedAt(new Date()).
                setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7)).
                setId(UUID.randomUUID().toString()).
                //signature
                signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        System.out.println(jwtToken);
    }

    @Test
    public void parse(){
        String token="";
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        System.out.println(claims.get("name"));
        System.out.println(claims.get("age"));
    }
}
