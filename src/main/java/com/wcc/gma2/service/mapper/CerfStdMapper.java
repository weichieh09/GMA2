package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Cerf;
import com.wcc.gma2.domain.CerfStd;
import com.wcc.gma2.domain.Std;
import com.wcc.gma2.service.dto.CerfDTO;
import com.wcc.gma2.service.dto.CerfStdDTO;
import com.wcc.gma2.service.dto.StdDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CerfStd} and its DTO {@link CerfStdDTO}.
 */
@Mapper(componentModel = "spring")
public interface CerfStdMapper extends EntityMapper<CerfStdDTO, CerfStd> {
    @Mapping(target = "cerf", source = "cerf", qualifiedByName = "cerfId")
    @Mapping(target = "std", source = "std", qualifiedByName = "stdId")
    CerfStdDTO toDto(CerfStd s);

    @Named("cerfId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CerfDTO toDtoCerfId(Cerf cerf);

    @Named("stdId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "stdNo", source = "stdNo")
    @Mapping(target = "stdVer", source = "stdVer")
    @Mapping(target = "chName", source = "chName")
    StdDTO toDtoStdId(Std std);
}
