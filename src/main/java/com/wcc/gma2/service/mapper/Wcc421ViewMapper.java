package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Wcc421View;
import com.wcc.gma2.service.dto.Wcc421ViewDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Wcc421View} and its DTO {@link Wcc421ViewDTO}.
 */
@Mapper(componentModel = "spring")
public interface Wcc421ViewMapper extends EntityMapper<Wcc421ViewDTO, Wcc421View> {}
