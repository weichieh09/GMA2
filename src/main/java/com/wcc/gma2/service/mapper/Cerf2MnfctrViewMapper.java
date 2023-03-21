package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Cerf2MnfctrView;
import com.wcc.gma2.service.dto.Cerf2MnfctrViewDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Cerf2MnfctrView} and its DTO {@link Cerf2MnfctrViewDTO}.
 */
@Mapper(componentModel = "spring")
public interface Cerf2MnfctrViewMapper extends EntityMapper<Cerf2MnfctrViewDTO, Cerf2MnfctrView> {}
