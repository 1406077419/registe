package com.registe.brick.userbrick.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import tk.mybatis.mapper.util.StringUtil;


import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AuthUtil {

    //过期时间
    private static final long EXPIRE_DATE = 4 * 1000;

    //token秘钥
    private static final String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2020BQWE";

    //token缓存
    private static Map<String,String> authMap = new HashMap<String,String>();

    /**
     * 创建token
     * @param userId
     * @param userName
     * @return
     */
    public static String createToken(String userId, String userName) {

        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("userId", userId)
                    .withClaim("userName", userName).withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }

    /**
     * 更新token
     * @param userId
     * @param userName
     * @return
     */
    public static String updateToken(String userId, String userName){

        return getToken(userId,userName);
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        /**
         * @desc 验证token，通过返回true
         * @params [token]需要校验的串
         **/
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 获取token
     * @param userId
     * @param userName
     * @return
     */
    public static String getToken(String userId, String userName){
        //名称转码
        String nameEncode = Base64.getEncoder()
                .encodeToString(userName.getBytes(StandardCharsets.UTF_8));
        String token = createToken(userId,nameEncode);

        if (StringUtil.isNotEmpty(token)){
            //添加到缓存
            authMap.put(token,userId);
            return token;
        }
        return null;
    }

    public static void main(String[] args) throws InterruptedException {


        String userName = "张飞";
        String userId = "1695206c-96b9-4ba5-bb6f-b07ca6461dda";
        String token = getToken(userName,userId);

        System.out.println("token验证   "+verify(token));

        Thread.sleep(6000L);

        System.out.println("token过期后验证   "+verify(token));

    }
}
