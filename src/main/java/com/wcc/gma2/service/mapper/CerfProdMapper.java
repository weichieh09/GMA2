package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Cerf;
import com.wcc.gma2.domain.CerfProd;
import com.wcc.gma2.domain.Prod;
import com.wcc.gma2.service.dto.CerfDTO;
import com.wcc.gma2.service.dto.CerfProdDTO;
import com.wcc.gma2.service.dto.ProdDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CerfProd} and its DTO {@link CerfProdDTO}.
 */
@Mapper(componentModel = "spring")
public interface CerfProdMapper extends EntityMapper<CerfProdDTO, CerfProd> {
    @Mapping(target = "cerf", source = "cerf", qualifiedByName = "cerfId")
    @Mapping(target = "prod", source = "prod", qualifiedByName = "prodId")
    CerfProdDTO toDto(CerfProd s);

    @Named("cerfId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CerfDTO toDtoCerfId(Cerf cerf);

    @Named("prodId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "prodNo", source = "prodNo")
    @Mapping(target = "chName", source = "chName")
    ProdDTO toDtoProdId(Prod prod);
}
