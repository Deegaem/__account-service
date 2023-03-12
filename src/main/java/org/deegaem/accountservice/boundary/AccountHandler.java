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

import java.net.URI;

@Component
public class AccountHandler {
    // Simple Handler that returns a String

    @Autowired
    AccountRepository accountRepository;
    public Mono<ServerResponse> listAccounts(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(accountRepository.findAll(), Account.class);

    }

    public Mono<ServerResponse> getAccountById(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("id"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(accountRepository.findById(id), Account.class);
    }
    public Mono<ServerResponse> saveAccount(ServerRequest request) {
        return request.bodyToMono(Account.class)
                .flatMap(account -> accountRepository.save(account))
                .flatMap(newAccount -> ServerResponse.created(URI.create("/accounts" + newAccount.getAccount_id()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .build());
    }
    public Mono<ServerResponse> updateAccount(ServerRequest request) {
        return request.bodyToMono(Account.class)
                .flatMap(account -> accountRepository.)
                .flatMap(modBook -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(modBook)));
    }
    public Mono<ServerResponse> deleteBookById(ServerRequest request) {
        return bookService.deleteBookById(Integer.parseInt(request.pathVariable("id")))
                .flatMap(val -> {
                    if (val == true) {
                        return ServerResponse.noContent().build();
                    }
                    return ServerResponse.notFound().build();
                });
    }


}
