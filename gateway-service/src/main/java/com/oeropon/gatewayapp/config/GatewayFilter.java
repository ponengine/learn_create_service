package com.oeropon.gatewayapp.config;

import com.oeropon.gatewayapp.filter.FilterUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class GatewayFilter implements GlobalFilter {
    final Logger logger = LoggerFactory.getLogger(GatewayFilter.class);
    @Autowired
    FilterUtility filterUtili;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
        if(isCorrelationIdPresent(requestHeaders)){
            logger.info("Tracing filter : {}",filterUtili.getCorrelationId(requestHeaders));
        }else{
            String correlationId = generateCorreationId();
            exchange=filterUtili.setCorrelationId(exchange,correlationId);
            logger.info("Tracing filter : {}",correlationId);
        }
        return chain.filter(exchange);
    }

    private boolean isCorrelationIdPresent(HttpHeaders requestHeader){
        if(filterUtili.getCorrelationId(requestHeader)!=null){
            return true;
        }else {
            return false;
        }
    }

    private String generateCorreationId(){
        return UUID.randomUUID().toString();
    }
}
