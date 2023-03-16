package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Prod2Cerf;
import com.wcc.gma2.service.dto.Prod2CerfDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Prod2Cerf} and its DTO {@link Prod2CerfDTO}.
 */
@Mapper(componentModel = "spring")
public interface Prod2CerfMapper extends EntityMapper<Prod2CerfDTO, Prod2Cerf> {}
