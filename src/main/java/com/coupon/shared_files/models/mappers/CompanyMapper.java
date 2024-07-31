package com.coupon.shared_files.models.mappers;

import com.coupon.shared_files.models.dtos.CompanyDto;
import com.coupon.shared_files.models.entities.Company;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyMapper {

  private final ModelMapper modelMapper;

  public CompanyDto toDto(Company company) {
    return modelMapper.map(company, CompanyDto.class);
  }

  public Company toEntity(CompanyDto companyDto) {
    return modelMapper.map(companyDto, Company.class);
  }
}
