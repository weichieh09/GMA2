package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.AreaDesc;
import com.wcc.gma2.service.dto.AreaDescDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link AreaDesc} and its DTO {@link AreaDescDTO}.
 */
@Mapper(componentModel = "spring")
public interface AreaDescMapper extends EntityMapper<AreaDescDTO, AreaDesc> {}
