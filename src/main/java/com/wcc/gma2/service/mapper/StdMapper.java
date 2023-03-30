package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Std;
import com.wcc.gma2.service.dto.StdDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Std} and its DTO {@link StdDTO}.
 */
@Mapper(componentModel = "spring")
public interface StdMapper extends EntityMapper<StdDTO, Std> {}
