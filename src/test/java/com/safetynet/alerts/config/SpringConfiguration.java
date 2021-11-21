package com.safetynet.alerts.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.safetynet.alerts.server.database.repositories")
public class SpringConfiguration {

}
