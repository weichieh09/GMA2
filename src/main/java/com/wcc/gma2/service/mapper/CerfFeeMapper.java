package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.CerfFee;
import com.wcc.gma2.service.dto.CerfFeeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CerfFee} and its DTO {@link CerfFeeDTO}.
 */
@Mapper(componentModel = "spring")
public interface CerfFeeMapper extends EntityMapper<CerfFeeDTO, CerfFee> {}
