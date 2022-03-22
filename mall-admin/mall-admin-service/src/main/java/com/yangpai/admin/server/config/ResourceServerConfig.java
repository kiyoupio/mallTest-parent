package com.yangpai.admin.server.config;

import com.yangpai.admin.server.component.IgnoreUrls;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author kuangyoupeng1
 * @date 2022.1.25
 */
@Configuration
// 资源服务器开启：多一层filter
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    /**
     * 白名单
     */
    private final IgnoreUrls ignoreUrls;

    public ResourceServerConfig(IgnoreUrls ignoreUrls) {
        this.ignoreUrls = ignoreUrls;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        for (String url : ignoreUrls.getUrls()){
            http.csrf().disable().authorizeRequests().antMatchers(url).permitAll();
        }
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").authenticated();
    }
}
