package org.deegaem.accountservice.boundary;

import org.deegaem.accountservice.domain.Account;
import org.deegaem.accountservice.domain.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class AccountHandler {
    // Simple Handler that returns a String

    @Autowired
    AccountRepository accountRepository;
    public Mono<ServerResponse> listAccounts(ServerRequest request) {
        Flux<Account> accountsList= accountRepository.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(accountsList, Account.class);
    }

}
