package org.deegaem.accountservice.boundary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> accountsRouten(AccountHandler accountHandler) {
        // This is some nested endpoints using functional endpoints
        return route()
                .GET("/accounts", accountHandler::listAccounts)
                .build();
    }
}
