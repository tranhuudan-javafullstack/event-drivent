package com.tanthanh.notificationservice;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
@RestController
@EnableBinding(Sink.class)
public class NotificationserviceApplication {
    private final WebClient.Builder webClientBuilder;
    private final CircuitBreakerFactory circuitBreakerFactory;
    private Logger logger = org.slf4j.LoggerFactory.getLogger(NotificationserviceApplication.class);

    public NotificationserviceApplication(WebClient.Builder webClientBuilder, CircuitBreakerFactory circuitBreakerFactory) {
        this.webClientBuilder = webClientBuilder;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    public static void main(String[] args) {
        SpringApplication.run(NotificationserviceApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void consumeMessage(Message message) {

        EmployeeReponseModel Employeemodel = circuitBreakerFactory.create("getEmployee").run(
                () -> {
                    return webClientBuilder.build()
                            .get()
                            .uri("http://localhost:9002/api/v1/employees/" + message.getEmployeeId())
                            .retrieve()
                            .bodyToMono(EmployeeReponseModel.class)
                            .block();
                },
                t -> {
                    EmployeeReponseModel model = new EmployeeReponseModel();
                    model.setFirstName("Anonymous");
                    model.setLastName("Employee");
                    return model;
                }
        );

        if (Employeemodel != null) {
            logger.info("Consume Payload: " + Employeemodel.getFirstName() + " " + Employeemodel.getLastName() + " " + message.getMessage());
        }
    }


}
