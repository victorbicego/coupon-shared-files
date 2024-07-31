package com.coupon.shared_files.repositories;

import com.coupon.shared_files.models.entities.FollowRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRequestRepository extends JpaRepository<FollowRequest, String> {}
