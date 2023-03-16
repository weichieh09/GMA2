package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.StsDesc;
import com.wcc.gma2.service.dto.StsDescDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link StsDesc} and its DTO {@link StsDescDTO}.
 */
@Mapper(componentModel = "spring")
public interface StsDescMapper extends EntityMapper<StsDescDTO, StsDesc> {}
