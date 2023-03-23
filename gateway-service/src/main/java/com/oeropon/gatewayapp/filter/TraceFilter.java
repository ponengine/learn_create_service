//package com.oeropon.gatewayapp.filter;//package com.oreopon.gatewayserver.filter;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.UUID;
//
//@Component
////@Order(1)
//public class TraceFilter implements GlobalFilter {
//    private static final Logger logger = LoggerFactory.getLogger(TraceFilter.class);
//    @Autowired
//    FilterUtility filterUtili;
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
//        if(isCorrelationIdPresent(requestHeaders)){
//            logger.debug("OreoBank-correlation found in tracing filter : {}",filterUtili.getCorrelationId(requestHeaders));
//        }else{
//            String correlationId = generateCorreationId();
//            exchange=filterUtili.setCorrelationId(exchange,correlationId);
//            logger.debug("OreoBank generated in tracing filter : {}",correlationId);
//        }
//        return chain.filter(exchange);
//    }
//
//    private boolean isCorrelationIdPresent(HttpHeaders requestHeader){
//        if(filterUtili.getCorrelationId(requestHeader)!=null){
//            return true;
//        }else {
//            return false;
//        }
//    }
//
//    private String generateCorreationId(){
//        return UUID.randomUUID().toString();
//    }
//}
