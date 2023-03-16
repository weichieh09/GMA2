package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Prod;
import com.wcc.gma2.service.dto.ProdDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Prod} and its DTO {@link ProdDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProdMapper extends EntityMapper<ProdDTO, Prod> {}
