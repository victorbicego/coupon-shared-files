package com.coupon.shared_files.repositories;

import com.coupon.shared_files.models.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository
    extends JpaRepository<Company, String>, BaseUserRepository<Company> {}
