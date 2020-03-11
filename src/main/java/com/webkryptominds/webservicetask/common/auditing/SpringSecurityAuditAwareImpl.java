package com.webkryptominds.webservicetask.common.auditing;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class SpringSecurityAuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {     
        return Optional.ofNullable("Admin");
    }
}