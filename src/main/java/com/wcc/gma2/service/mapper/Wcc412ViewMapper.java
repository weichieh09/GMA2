package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Wcc412View;
import com.wcc.gma2.service.dto.Wcc412ViewDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Wcc412View} and its DTO {@link Wcc412ViewDTO}.
 */
@Mapper(componentModel = "spring")
public interface Wcc412ViewMapper extends EntityMapper<Wcc412ViewDTO, Wcc412View> {}
