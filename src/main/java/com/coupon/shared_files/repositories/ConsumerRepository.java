package com.coupon.shared_files.repositories;

import com.coupon.shared_files.models.entities.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository
    extends JpaRepository<Consumer, String>, BaseUserRepository<Consumer> {}
