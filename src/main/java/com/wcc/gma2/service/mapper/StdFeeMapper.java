package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.StdFee;
import com.wcc.gma2.service.dto.StdFeeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link StdFee} and its DTO {@link StdFeeDTO}.
 */
@Mapper(componentModel = "spring")
public interface StdFeeMapper extends EntityMapper<StdFeeDTO, StdFee> {}
