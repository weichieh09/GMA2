package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Cerf2ProdView;
import com.wcc.gma2.service.dto.Cerf2ProdViewDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Cerf2ProdView} and its DTO {@link Cerf2ProdViewDTO}.
 */
@Mapper(componentModel = "spring")
public interface Cerf2ProdViewMapper extends EntityMapper<Cerf2ProdViewDTO, Cerf2ProdView> {}
