package com.coupon.shared_files.models.mappers;

import com.coupon.shared_files.models.dtos.FollowRequestDto;
import com.coupon.shared_files.models.entities.FollowRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowRequestMapper {

  private final ModelMapper modelMapper;

  public FollowRequestDto toDto(FollowRequest followRequest) {
    return modelMapper.map(followRequest, FollowRequestDto.class);
  }

  public FollowRequest toEntity(FollowRequestDto followRequestDto) {
    return modelMapper.map(followRequestDto, FollowRequest.class);
  }
}
