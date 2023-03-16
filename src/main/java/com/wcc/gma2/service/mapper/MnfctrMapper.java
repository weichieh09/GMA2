package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Mnfctr;
import com.wcc.gma2.service.dto.MnfctrDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Mnfctr} and its DTO {@link MnfctrDTO}.
 */
@Mapper(componentModel = "spring")
public interface MnfctrMapper extends EntityMapper<MnfctrDTO, Mnfctr> {}
