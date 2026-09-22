package com.vd14.restclients;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RestClientsApplicationTests {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(applicationContext);
        int count = applicationContext.getBeanDefinitionCount();
        System.out.println("count : " + count);
    }

    @Test @Disabled
    public void getBeanMethodThrowsNoSuchBeanDefinitionException() {
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean(RestTemplate.class));
    }

}
