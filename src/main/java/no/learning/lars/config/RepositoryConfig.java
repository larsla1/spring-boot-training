package no.learning.lars.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Repository configuration file.
 * This file is needed to do integration testing on the Repository
 */
@Configuration
@EnableAutoConfiguration //Tells Spring Boot to  automatically create Spring Beans with defaults values for testing purposes.
@EntityScan(basePackages = {"no.learning.lars.*"}) //Tells Hibernate where to look for JPA entities
@EnableJpaRepositories(basePackages = {"no.learning.lars.repositories"}) //Enable auto config of Spring Data JPA
@EnableTransactionManagement //Enable annotation driven transaction management.
public class RepositoryConfig {
}
