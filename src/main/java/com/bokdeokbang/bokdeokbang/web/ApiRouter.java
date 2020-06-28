package com.bokdeokbang.bokdeokbang.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class ApiRouter {

    @Bean
    public RouterFunction<ServerResponse> routeByUser(ApiHandler handler) {
        return nest(path("/api"),
                route(GET("/{id}"), handler::findById));
    }

}
