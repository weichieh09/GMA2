package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Mark;
import com.wcc.gma2.service.dto.MarkDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Mark} and its DTO {@link MarkDTO}.
 */
@Mapper(componentModel = "spring")
public interface MarkMapper extends EntityMapper<MarkDTO, Mark> {}
