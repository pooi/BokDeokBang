package com.bokdeokbang.bokdeokbang.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Configuration
public class ApiHandler {

    @Autowired
    public ApiHandler() {

    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        return Optional.of(request.pathVariable("id"))
                .filter(id -> !StringUtils.isEmpty(id))
                .map(id -> ServerResponse.ok())
                .orElseGet(ServerResponse::badRequest)
                .build();
    }
}
