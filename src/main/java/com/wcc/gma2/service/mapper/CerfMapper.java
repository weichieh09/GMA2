package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Cerf;
import com.wcc.gma2.service.dto.CerfDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Cerf} and its DTO {@link CerfDTO}.
 */
@Mapper(componentModel = "spring")
public interface CerfMapper extends EntityMapper<CerfDTO, Cerf> {}
