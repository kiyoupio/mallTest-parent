package com.yangpai.admin.server.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * admin访问白名单
 * @author kuangyoupeng1
 * @date 2022.1.27
 */
@Component
@ConfigurationProperties(prefix = "spring.secure.ignored")
public class IgnoreUrls {
    /**
     * url
     */
    private List<String> urls = new ArrayList<>();

    public List<String> getUrls(){
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
