package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.FeeDesc;
import com.wcc.gma2.service.dto.FeeDescDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link FeeDesc} and its DTO {@link FeeDescDTO}.
 */
@Mapper(componentModel = "spring")
public interface FeeDescMapper extends EntityMapper<FeeDescDTO, FeeDesc> {}
