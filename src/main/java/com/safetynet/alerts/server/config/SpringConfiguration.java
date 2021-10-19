package com.safetynet.alerts.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.safetynet.alerts.database.repositories")
public class SpringConfiguration {

}
