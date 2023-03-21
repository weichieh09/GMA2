package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Cerf2StdView;
import com.wcc.gma2.service.dto.Cerf2StdViewDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Cerf2StdView} and its DTO {@link Cerf2StdViewDTO}.
 */
@Mapper(componentModel = "spring")
public interface Cerf2StdViewMapper extends EntityMapper<Cerf2StdViewDTO, Cerf2StdView> {}
