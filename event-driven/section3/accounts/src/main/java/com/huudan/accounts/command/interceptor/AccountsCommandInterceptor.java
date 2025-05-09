package com.huudan.accounts.command.interceptor;

import com.huudan.accounts.command.CreateAccountCommand;
import com.huudan.accounts.command.DeleteAccountCommand;
import com.huudan.accounts.command.UpdateAccountCommand;
import com.huudan.accounts.constants.AccountsConstants;
import com.huudan.accounts.entity.Accounts;
import com.huudan.accounts.exception.AccountAlreadyExistsException;
import com.huudan.accounts.exception.ResourceNotFoundException;
import com.huudan.accounts.repository.AccountsRepository;
import jakarta.annotation.Nonnull;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class AccountsCommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {

    AccountsRepository accountsRepository;

    @Nonnull
    @Override
    public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(@Nonnull List<? extends
            CommandMessage<?>> messages) {
        return (index, command) -> {
            if (CreateAccountCommand.class.equals(command.getPayloadType())) {
                CreateAccountCommand createAccountCommand = (CreateAccountCommand) command.getPayload();
                Optional<Accounts> optionalAccounts = accountsRepository.findByMobileNumberAndActiveSw(
                        createAccountCommand.getMobileNumber(), true);
                if (optionalAccounts.isPresent()) {
                    throw new AccountAlreadyExistsException("Account already created with given mobileNumber "
                            + createAccountCommand.getMobileNumber());
                }
            } else if (UpdateAccountCommand.class.equals(command.getPayloadType())) {
                UpdateAccountCommand updateAccountCommand = (UpdateAccountCommand) command.getPayload();
                Accounts account = accountsRepository.findByMobileNumberAndActiveSw
                        (updateAccountCommand.getMobileNumber(), true).orElseThrow(() ->
                        new ResourceNotFoundException("Account", "mobileNumber", updateAccountCommand.getMobileNumber()));
            } else if (DeleteAccountCommand.class.equals(command.getPayloadType())) {
                DeleteAccountCommand deleteAccountCommand = (DeleteAccountCommand) command.getPayload();
                Accounts account = accountsRepository.findByAccountNumberAndActiveSw(deleteAccountCommand.getAccountNumber(),
                        AccountsConstants.ACTIVE_SW).orElseThrow(() -> new ResourceNotFoundException("Account", "accountNumber",
                        deleteAccountCommand.getAccountNumber().toString()));
            }
            return command;
        };
    }

}
