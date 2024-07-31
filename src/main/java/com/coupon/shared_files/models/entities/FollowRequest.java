package com.coupon.shared_files.models.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
public class FollowRequest {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private LocalDateTime createTimeStamp;

  @ManyToOne private Company createdBy;

  @ManyToOne private Influencer createdFor;
}
