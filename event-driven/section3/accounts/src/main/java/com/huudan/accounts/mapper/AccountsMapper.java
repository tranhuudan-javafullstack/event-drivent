package com.huudan.accounts.mapper;

import com.huudan.accounts.command.event.AccountUpdatedEvent;
import com.huudan.accounts.dto.AccountsDto;
import com.huudan.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setMobileNumber(accounts.getMobileNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        accountsDto.setActiveSw(accounts.isActiveSw());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }

    public static Accounts mapEventToAccount(AccountUpdatedEvent event, Accounts account) {
        account.setAccountType(event.getAccountType());
        account.setBranchAddress(event.getBranchAddress());
        return account;
    }

}
