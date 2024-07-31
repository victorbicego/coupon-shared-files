package com.coupon.shared_files.models.mappers;

import com.coupon.shared_files.models.dtos.ConfirmationDto;
import com.coupon.shared_files.models.entities.Confirmation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmationMapper {

    private final ModelMapper modelMapper;

    public ConfirmationDto toDto(Confirmation confirmation) {
        return modelMapper.map(confirmation, ConfirmationDto.class);
    }

    public Confirmation toEntity(ConfirmationDto confirmationDto) {
        return modelMapper.map(confirmationDto, Confirmation.class);
    }
}
