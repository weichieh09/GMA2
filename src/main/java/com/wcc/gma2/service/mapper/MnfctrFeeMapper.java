package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.MnfctrFee;
import com.wcc.gma2.service.dto.MnfctrFeeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link MnfctrFee} and its DTO {@link MnfctrFeeDTO}.
 */
@Mapper(componentModel = "spring")
public interface MnfctrFeeMapper extends EntityMapper<MnfctrFeeDTO, MnfctrFee> {}
