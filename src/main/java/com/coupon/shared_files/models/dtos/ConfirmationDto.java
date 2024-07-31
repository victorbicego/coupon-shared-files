package com.coupon.shared_files.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmationDto {

  private String id;
  @NotBlank private String username;
  @NotBlank private String code;
  @NotNull private LocalDateTime createTimeStamp;
}
