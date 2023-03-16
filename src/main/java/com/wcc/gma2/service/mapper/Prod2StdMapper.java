package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Prod2Std;
import com.wcc.gma2.service.dto.Prod2StdDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Prod2Std} and its DTO {@link Prod2StdDTO}.
 */
@Mapper(componentModel = "spring")
public interface Prod2StdMapper extends EntityMapper<Prod2StdDTO, Prod2Std> {}
