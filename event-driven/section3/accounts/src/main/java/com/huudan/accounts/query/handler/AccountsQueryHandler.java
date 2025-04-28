package com.huudan.accounts.query.handler;

import com.huudan.accounts.dto.AccountsDto;
import com.huudan.accounts.query.FindAccountQuery;
import com.huudan.accounts.service.IAccountsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class AccountsQueryHandler {

    IAccountsService iAccountsService;

    @QueryHandler
    public AccountsDto findAccount(FindAccountQuery query) {
        return iAccountsService.fetchAccount(query.getMobileNumber());
    }

}