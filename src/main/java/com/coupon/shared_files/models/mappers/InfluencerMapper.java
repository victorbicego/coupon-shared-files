package com.coupon.shared_files.models.mappers;

import com.coupon.shared_files.models.dtos.InfluencerDto;
import com.coupon.shared_files.models.entities.Influencer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfluencerMapper {

  private final ModelMapper modelMapper;

  public InfluencerDto toDto(Influencer influencer) {
    return modelMapper.map(influencer, InfluencerDto.class);
  }

  public Influencer toEntity(InfluencerDto influencerDto) {
    return modelMapper.map(influencerDto, Influencer.class);
  }
}
