package co.ufps.edu.projectservice.application.config;

import co.ufps.edu.projectservice.domain.model.gateways.ProjectGateway;
import co.ufps.edu.projectservice.domain.useCase.ProjectUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ProjectUseCase projectUseCase(ProjectGateway gateway){
        return new ProjectUseCase(gateway);
    }
}
