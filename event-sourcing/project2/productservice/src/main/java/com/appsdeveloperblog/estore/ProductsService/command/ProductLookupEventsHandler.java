package com.appsdeveloperblog.estore.ProductsService.command;

import com.appsdeveloperblog.estore.ProductsService.core.data.ProductLookupEntity;
import com.appsdeveloperblog.estore.ProductsService.core.data.ProductLookupRepository;
import com.appsdeveloperblog.estore.ProductsService.core.events.ProductCreatedEvent;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.ResetHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product-group")

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductLookupEventsHandler {

    ProductLookupRepository productLookupRepository;

    @EventHandler
    public void on(ProductCreatedEvent event) {

        ProductLookupEntity productLookupEntity = new ProductLookupEntity(event.getProductId(),
                event.getTitle());

        productLookupRepository.save(productLookupEntity);

    }

    @ResetHandler
    public void reset() {
        productLookupRepository.deleteAll();
    }

}
