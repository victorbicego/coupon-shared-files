package com.coupon.shared_files.models.mappers;

import com.coup.shared_entities.models.models.dtos.ConsumerDto;
import com.coup.shared_entities.models.models.entities.Consumer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerMapper {

  private final ModelMapper modelMapper;

  public ConsumerDto toDto(Consumer consumer) {
    return modelMapper.map(consumer, ConsumerDto.class);
  }

  public Consumer toEntity(ConsumerDto consumerDto) {
    return modelMapper.map(consumerDto, Consumer.class);
  }

}
