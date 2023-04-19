package org.deegaem.accountservice.boundary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> accountsRouten(AccountHandler accountHandler) {
        return RouterFunctions.route()
                .GET("/accounts", accountHandler::listAccounts)
                .GET("/accounts/{account_id}", RequestPredicates.accept(MediaType.TEXT_PLAIN), accountHandler::getAccountById)
                .POST("/accounts", RequestPredicates.contentType(MediaType.APPLICATION_JSON), accountHandler::saveAccount)
                .PUT("/accounts", RequestPredicates.contentType(MediaType.APPLICATION_JSON), accountHandler::updateAccount)
                .DELETE("/accounts/{account_id}", RequestPredicates.accept(MediaType.TEXT_PLAIN), accountHandler::deleteAccountById)
                .build();
    }

}
//
//