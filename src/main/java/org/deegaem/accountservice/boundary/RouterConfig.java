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
/*    public RouterFunction<ServerResponse> accountroots(AccountHandler accountHandler) {
        return RouterFunctions.route()
                .GET("/accounts", accountHandler::listAccounts)
                .GET("/accounts/{id}", RequestPredicates.accept(MediaType.TEXT_PLAIN), accountHandler::getAccountById)
                .POST("/accounts", RequestPredicates.contentType(MediaType.APPLICATION_JSON), accountHandler::saveAccount)
                .PUT("/accounts/{id}", RequestPredicates.contentType(MediaType.APPLICATION_JSON), accountHandler::updateBook)
                .DELETE("/accounts/{id}", RequestPredicates.accept(MediaType.TEXT_PLAIN), accountHandler::deleteBookById)
                .build();
    }*/
}
