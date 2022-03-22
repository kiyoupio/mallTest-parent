package com.yangpai.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * 请求日志过滤器
 * @author kuangyoupeng1
 * @date 2022.2.4
 */
@Component
@Slf4j
public class RequestLogFilter implements WebFilter, Ordered {

    /**
     * 定义过滤器执行顺序
     * 越大约靠前，或者使用@Order
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * 拦截：打印请求日志
     * @param serverWebExchange
     * @param webFilterChain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        return webFilterChain.filter(serverWebExchange).then(Mono.fromRunnable(() -> log.info(":: RequestLogFilter URL：{}", serverWebExchange.getRequest().getURI())));
    }
}
