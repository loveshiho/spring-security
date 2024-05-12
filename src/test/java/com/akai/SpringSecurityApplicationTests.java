package com.akai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SpringSecurityApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testEncoder() {
        // 底层是 MD5加密
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = encoder.encode("shiho");
        System.out.println(result);
        // $2a$10$FUWa2cbArUlWDuDsfsyGXuRL75BGd81GEBk79IH2U3QWIzcKxCOgG
        boolean match = encoder.matches("shiho", result);
        System.out.println(match);  // true
    }
}
