package com.example.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurationSupport {

//    @Autowired
//    private LoginInterceptor loginInterceptor;
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        // 多个拦截器组成一个拦截器链
//        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
//        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/stuInfo/getAllStuInfoA","/account/register");
//        super.addInterceptors(registry);
//    }

    @Bean
    public SecurityInterceptor securityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(securityInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/static/*");
        registry.addInterceptor(securityInterceptor()).excludePathPatterns("/static/**")
                .excludePathPatterns("/error").addPathPatterns("/**");
    }

    @Override
    //需要告知系统，这是要被当成静态文件的！
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 设置文件上传的文件不拦截
//        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+ TaleUtils.getUplodFilePath()+"upload/");
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}