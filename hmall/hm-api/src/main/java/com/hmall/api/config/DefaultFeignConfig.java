package com.hmall.api.config;

import com.hmall.common.utils.UserContext;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;

public class DefaultFeignConfig {
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.NONE;
    }

    @Bean
    public RequestInterceptor userInfoRequestInterceptor(){
        return requestTemplate -> {
            Long userId = UserContext.getUser();
            if(userId == null){
                return ;
            }
            requestTemplate.header("user-info", userId.toString());
        };
    }
}
