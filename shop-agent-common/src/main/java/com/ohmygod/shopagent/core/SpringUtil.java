package com.ohmygod.shopagent.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Provides the application context to framework utilities that construct keys outside bean methods.
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    public static final String PREFIX_DISTINCTION_NAME = "prefix.distinction.name";
    public static final String DEFAULT_PREFIX_DISTINCTION_NAME = "shop-agent";

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext context) {
        applicationContext = context;
    }

    public static String getPrefixDistinctionName() {
        return applicationContext == null
                ? DEFAULT_PREFIX_DISTINCTION_NAME
                : applicationContext.getEnvironment().getProperty(
                        PREFIX_DISTINCTION_NAME, DEFAULT_PREFIX_DISTINCTION_NAME);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return applicationContext.getBean(name, requiredType);
    }
}
