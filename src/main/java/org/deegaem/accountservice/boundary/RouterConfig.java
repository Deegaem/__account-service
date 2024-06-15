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
                .GET("/bf/accounts", accountHandler::listAccounts)
                .GET("/bf/accounts/{account_id}", RequestPredicates.accept(MediaType.TEXT_PLAIN), accountHandler::getAccountById)
                .POST("/bf/accounts", RequestPredicates.contentType(MediaType.APPLICATION_JSON), accountHandler::saveAccount)
                .PUT("/bf/accounts", RequestPredicates.contentType(MediaType.APPLICATION_JSON), accountHandler::updateAccount)
                .DELETE("/bf/accounts/{account_id}", RequestPredicates.accept(MediaType.TEXT_PLAIN), accountHandler::deleteAccountById)
                .build();
    }

}
//
//