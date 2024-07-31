package com.coupon.shared_files.repositories;

import com.coupon.shared_files.models.entities.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfluencerRepository
    extends JpaRepository<Influencer, String>, BaseUserRepository<Influencer> {}
