package com.coupon.shared_files.models.dtos;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowRequestDto {

  private String id;
  @NotNull private LocalDateTime createTimeStamp;
}
