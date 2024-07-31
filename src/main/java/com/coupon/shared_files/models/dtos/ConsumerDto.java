package com.coupon.shared_files.models.dtos;

import com.coupon.shared_files.models.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerDto {

  private String id;
  @Email @NotBlank private String username;
  @NotBlank private Role role;
  @NotNull private Boolean accountNonExpired;
  @NotNull private Boolean accountNonLocked;
  @NotNull private Boolean credentialsNonExpired;
  @NotNull private Boolean enabled;
  @NotNull private LocalDateTime createTimeStamp;
  private LocalDateTime updateTimeStamp;
  private String createdTroughInfluencer;
  @NotBlank private String firstName;
  @NotBlank private String lastName;
}
