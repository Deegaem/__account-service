package org.deegaem.accountservice.boundary;

import org.deegaem.accountservice.domain.Account;
import org.deegaem.accountservice.domain.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
//@CrossOrigin
@Component
public class AccountHandler {
    @Autowired
    AccountRepository accountRepository;
    public Mono<ServerResponse> listAccounts(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(accountRepository.findAll(), Account.class);

    }

    public Mono<ServerResponse> getAccountById(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("account_id"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(accountRepository.findById(id), Account.class);
    }
    public Mono<ServerResponse> saveAccount(ServerRequest request) {
        return request.bodyToMono(Account.class)
                .flatMap(account -> accountRepository.save(account))
                .flatMap(newAccount -> ServerResponse.created(URI.create("/accounts/" + newAccount.getAccount_id()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .build());
    }
    public Mono<ServerResponse> updateAccount(ServerRequest request) {
        return request.bodyToMono(Account.class)
                .flatMap(account -> accountRepository.save(account))
                .flatMap(account -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(account)));
    }
    public Mono<ServerResponse> deleteAccountById(ServerRequest request) {
        return ServerResponse.noContent().build(accountRepository.deleteById(Long.parseLong(request.pathVariable("account_id"))));
    }


}
