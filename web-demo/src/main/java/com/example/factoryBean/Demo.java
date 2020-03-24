package com.example.factoryBean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by duan on 2020/1/20 15:18
 */

@Component
@Slf4j
public class Demo implements FactoryBean<User>, InitializingBean {

    private User user;

    @Override
    public User getObject() throws Exception {
        log.info("get object ...");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        User user = new User();
        user.setUsername("factoryBean test");
        user.setPassword("test");
        this.user = user;
        System.out.println("-------------------------");
//        user = build();
    }

    private User build(){
        User user = new User();
        user.setUsername("factoryBean test");
        user.setPassword("test");
        return user;
    }

}
