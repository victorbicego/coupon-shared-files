package com.coupon.shared_files.models.entities;

import com.coupon.shared_files.models.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Data
public class Company implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Email
  @Column(unique = true, nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Role role;

  @Column(nullable = false)
  private Boolean accountNonExpired = true;

  @Column(nullable = false)
  private Boolean accountNonLocked = true;

  @Column(nullable = false)
  private Boolean credentialsNonExpired = true;

  @Column(nullable = false)
  private Boolean enabled = false;

  @Column(nullable = false)
  private LocalDateTime createTimeStamp;

  private LocalDateTime updateTimeStamp;

  private String createdTroughInfluencer;

  @Column(nullable = false)
  private String name;

  @CNPJ
  @Column(unique = true, nullable = false)
  private String cnpj;

  @ManyToMany(mappedBy = "companyList")
  @JsonBackReference("company-influencers")
  private List<Influencer> influencerList;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
}
