package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.CerfView;
import com.wcc.gma2.service.dto.CerfViewDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CerfView} and its DTO {@link CerfViewDTO}.
 */
@Mapper(componentModel = "spring")
public interface CerfViewMapper extends EntityMapper<CerfViewDTO, CerfView> {}
