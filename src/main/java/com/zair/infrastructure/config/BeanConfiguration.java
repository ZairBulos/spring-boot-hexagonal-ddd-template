package com.zair.infrastructure.config;

import com.zair.application.ports.in.ApplicationUseCase;
import com.zair.application.ports.out.OutputPort;
import com.zair.application.services.ApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ApplicationUseCase applicationUseCase(OutputPort outputPort) {
        return new ApplicationService(outputPort);
    }
}
