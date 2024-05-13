package com.akai;

import com.baomidou.mybatisplus.core.toolkit.Assert;
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

    @Test
    void testPassword() {

        // 工作因子，默认值是10，最小值是4，最大值是31，值越大运算速度越慢
        PasswordEncoder encoder = new BCryptPasswordEncoder(4);
        // 明文："password"
        // 密文：result，即使明文密码相同，每次生成的密文也不一致
        String result = encoder.encode("password");
        System.out.println(result);

        // 密码校验
        Assert.isTrue(encoder.matches("password", result), "密码不一致");
    }
}
