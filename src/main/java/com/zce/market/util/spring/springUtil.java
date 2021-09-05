package com.zce.market.util.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class springUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        springUtil.applicationContext = applicationContext;
    }


    public static <T> T getBean(Class<T> cls) {
        return springUtil.applicationContext.getBean(cls);
    }
}
