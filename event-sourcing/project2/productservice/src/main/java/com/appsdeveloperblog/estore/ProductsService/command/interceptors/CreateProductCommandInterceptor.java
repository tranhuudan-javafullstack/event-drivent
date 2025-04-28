package com.appsdeveloperblog.estore.ProductsService.command.interceptors;

import com.appsdeveloperblog.estore.ProductsService.command.CreateProductCommand;
import com.appsdeveloperblog.estore.ProductsService.core.data.ProductLookupEntity;
import com.appsdeveloperblog.estore.ProductsService.core.data.ProductLookupRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.BiFunction;

@Component

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CreateProductCommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {

    ProductLookupRepository productLookupRepository;


    @Override
    @NonNull
    public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(@NonNull List<?extends CommandMessage<?>> messages) {

        return (index, command) -> {

            log.info("Intercepted command: " + command.getPayloadType());

            if (CreateProductCommand.class.equals(command.getPayloadType())) {

                CreateProductCommand createProductCommand = (CreateProductCommand) command.getPayload();

                ProductLookupEntity productLookupEntity = productLookupRepository.findByProductIdOrTitle(createProductCommand.getProductId(),
                        createProductCommand.getTitle());

                if (productLookupEntity != null) {
                    throw new IllegalStateException(
                            String.format("Product with productId %s or title %s already exist",
                                    createProductCommand.getProductId(), createProductCommand.getTitle())
                    );
                }

            }

            return command;
        };
    }

}
