package per.liam;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import per.liam.repository.UserRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@SpringBootTest
@Slf4j
class BlogApplicationTests {
    @Autowired
    private UserRepository userRepository;

    public static final int CALENDAR_FIELD = Calendar.MINUTE;
    public static final int CALENDAR_INTERVAL = 1;
    private static final String SECRET_KEY = "6A50A18D70FA63636645C65459F1D78A";

    @Test
    void contextLoads() {
        HashMap<String, Object> userMap = new HashMap<>();
        // 头部
        HashMap<String, Object> headerMap = new HashMap<>();
        headerMap.put("alg", "HS256");
        headerMap.put("typ", "JWT");

        // 当前时间与过期时间
        Calendar time = Calendar.getInstance();
        Date now = time.getTime();
        time.add(CALENDAR_FIELD, CALENDAR_INTERVAL);
        Date expireTime = time.getTime();

        // 密匙加密
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

        userMap.put("username", "liam");
        userMap.put("role", "admin");
        userMap.put("admin", true);

        String token = JWT.create().withHeader(headerMap)
                .withIssuedAt(now)
                .withExpiresAt(expireTime)
                .withSubject("userInfo")
                .withClaim("userInfo", userMap)
                .sign(algorithm);
        log.info(token);

        DecodedJWT verifier = null;
        verifier = JWT.require(algorithm).build().verify(token);
        log.info(String.valueOf(verifier.getClaim("userInfo").asMap()));
    }
}
