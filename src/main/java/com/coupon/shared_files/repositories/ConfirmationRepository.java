package com.coupon.shared_files.repositories;

import com.coupon.shared_files.models.entities.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation, String> {}
