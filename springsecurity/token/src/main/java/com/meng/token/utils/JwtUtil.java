package com.meng.token.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtUtil {
    // 密钥
    public static final Long JWT_TTL = 604800L; // 7天

    public static final String JWT_KEY = "meng";

    public static String getUUID(){
        String token= UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }

    /**
     * 生成jtw
     * @param subject token中要存放的数据（json格式）
     * @return
     */
    public static String createJWT(String subject){
        JwtBuilder builder=getJwtBuilder(subject,null,getUUID());//生成JWTBuilder
        return builder.compact();
    }

    /**
     * 生成jtw
     * @param subject token中要存放的数据（json格式）
     * @param ttlMillis token超时时间
     * @return
     */
    public static String createJWT(String subject,Long ttlMillis){
        JwtBuilder builder=getJwtBuilder(subject,ttlMillis,getUUID()); // 创建JWT
        return builder.compact();
    }


    public static JwtBuilder getJwtBuilder(String subject,Long ttlMillis,String uuid){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if (ttlMillis == null) {
            ttlMillis = JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                .setId(uuid)  // 设置jwt的唯一id
                .setIssuedAt(now)  // 设置jwt的签发时间
                .setIssuer("meng")  // 设置jwt的签发人
                .setSubject(subject)  // 设置jwt的主题
                .setExpiration(expDate)  // 设置jwt的过期时间
                .signWith(signatureAlgorithm, secretKey);  // 设置jwt的签名算法和密钥
    }

    /**
     * 创建token
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id,String subject,Long ttlMillis){
        JwtBuilder builder=getJwtBuilder(subject,ttlMillis,id); //设置过期时间
        return builder.compact();
    }

    public static void main(String[] args) throws Exception{
        String jwt = createJWT("meng");
        Claims claims =parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzOTUwYzYyYTU1YzE0MWVlOTI4NGUwNDg5YWRmMzMwNyIsImlhdCI6MTY1NzgwMjg5NiwiaXNzIjoibWVuZyIsInN1YiI6Im1lbmciLCJleHAiOjE2NTc4MDM1MDF9.JTETsRoKmMGNO1AXcd13kQHnbCUgIjd9ZUlumw08gRk");
//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJjYWM2ZDVhZi1mNjVlLTQ0MDAtYjcxMi0zYWEwOGIyOTIwYjQiLCJzdWIiOiJzZyIsImlzcyI6InNnIiwiaWF0IjoxNjM4MTA2NzEyLCJleHAiOjE2MzgxMTAzMTJ9.JVsSbkP94wuczb4QryQbAke3ysBDIL5ou8fWsbt_ebg";
//        Claims claims= parseJWT(token);
        System.out.println(claims);
    }

    /**
     * 生成加密后的秘钥 secretKey
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 解析
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }


}
