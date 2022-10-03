package com.candemirhan.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.bouncycastle.math.ec.rfc8032.Ed25519;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenManager {

    /**
     * 1 - Create JWT
     * 2 - Validate JWT
     */
    public Optional<String> createToken(Long oid) {
        String token = null;
        String sifreAnahtari = "1234";
        try{
            /**
             *  JWT içerisine hassas bilgilerinizi koymayınız. Örneğin şifre.
             */
            token = JWT.create()
                    .withIssuer("Can")
                    .withAudience()
                    .withClaim("oid",oid)
                    .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                    .sign(Algorithm.HMAC256(sifreAnahtari));
            return Optional.of(token);
        }catch (Exception ex){
            return Optional.empty();
        }
    }
}
