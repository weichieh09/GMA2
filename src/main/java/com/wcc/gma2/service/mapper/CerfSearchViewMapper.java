package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.CerfSearchView;
import com.wcc.gma2.service.dto.CerfSearchViewDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CerfSearchView} and its DTO {@link CerfSearchViewDTO}.
 */
@Mapper(componentModel = "spring")
public interface CerfSearchViewMapper extends EntityMapper<CerfSearchViewDTO, CerfSearchView> {}
