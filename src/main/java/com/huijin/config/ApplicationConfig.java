package com.huijin.config;

import com.huijin.filter.LoginIntercept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class ApplicationConfig extends WebMvcConfigurationSupport {

    @Resource
    private LoginIntercept loginIntercept;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 解决静态资源访问404 问题
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/static/**")
                .addResourceLocations("classpath:/public/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercept).
                addPathPatterns("/**").    // 拦截所有 url
                excludePathPatterns("/login"). //不拦截登录接口
                excludePathPatterns("/login/login.html").
                excludePathPatterns("/error").
                excludePathPatterns("/getImg"). // 不拦截虚幻引擎查询excel解析的接口
                excludePathPatterns("/getExcelJson"). // 不拦截虚幻引擎查询excel解析的接口
                excludePathPatterns("/getJson"). // 不拦截虚幻引擎查询excel解析的接口
                excludePathPatterns("/getJsonBySheetNameAndColumn"). // 不拦截虚幻引擎查询excel解析的接口
                excludePathPatterns("/getJsonBySheetConfig"). // 不拦截虚幻引擎查询excel解析的接口
                excludePathPatterns("/**/*.js").
                excludePathPatterns("/**/*.css").
                excludePathPatterns("/**/*.png").
                excludePathPatterns("/**/*.jpg");
    }

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
        super.configureMessageConverters(converters);
    }

    @Bean
    public HttpMessageConverter responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

}
