package com.niit.cakestore;

import com.niit.cakestore.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CakeStoreApplicationTests {

    @Test
    void contextLoads() {
        System.out.println( new User().getUsername());

    }

}
