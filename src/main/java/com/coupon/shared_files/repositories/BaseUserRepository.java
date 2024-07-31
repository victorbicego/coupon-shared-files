package com.coupon.shared_files.repositories;

import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;

public interface BaseUserRepository<T extends UserDetails> {

  Optional<T> findByUsername(String username);
}
