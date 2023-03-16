package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Cref2Std;
import com.wcc.gma2.service.dto.Cref2StdDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Cref2Std} and its DTO {@link Cref2StdDTO}.
 */
@Mapper(componentModel = "spring")
public interface Cref2StdMapper extends EntityMapper<Cref2StdDTO, Cref2Std> {}
