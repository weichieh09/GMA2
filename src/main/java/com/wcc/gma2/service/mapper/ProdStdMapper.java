package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Prod;
import com.wcc.gma2.domain.ProdStd;
import com.wcc.gma2.domain.Std;
import com.wcc.gma2.service.dto.ProdDTO;
import com.wcc.gma2.service.dto.ProdStdDTO;
import com.wcc.gma2.service.dto.StdDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProdStd} and its DTO {@link ProdStdDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProdStdMapper extends EntityMapper<ProdStdDTO, ProdStd> {
    @Mapping(target = "prod", source = "prod", qualifiedByName = "prodId")
    @Mapping(target = "std", source = "std", qualifiedByName = "stdId")
    ProdStdDTO toDto(ProdStd s);

    @Named("prodId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProdDTO toDtoProdId(Prod prod);

    @Named("stdId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    StdDTO toDtoStdId(Std std);
}
