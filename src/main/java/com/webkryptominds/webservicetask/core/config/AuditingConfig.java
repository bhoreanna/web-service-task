package com.webkryptominds.webservicetask.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.webkryptominds.webservicetask.common.auditing.SpringSecurityAuditAwareImpl;


@Configuration
@EnableJpaAuditing
public class AuditingConfig {
	@Bean
    public AuditorAware<String> auditorAware() {
        return new SpringSecurityAuditAwareImpl();
    }
}
