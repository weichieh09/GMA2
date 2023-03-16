package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Prod2Fcty;
import com.wcc.gma2.service.dto.Prod2FctyDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Prod2Fcty} and its DTO {@link Prod2FctyDTO}.
 */
@Mapper(componentModel = "spring")
public interface Prod2FctyMapper extends EntityMapper<Prod2FctyDTO, Prod2Fcty> {}
