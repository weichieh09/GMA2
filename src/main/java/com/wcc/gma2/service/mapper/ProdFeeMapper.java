package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Prod;
import com.wcc.gma2.domain.ProdFee;
import com.wcc.gma2.service.dto.ProdDTO;
import com.wcc.gma2.service.dto.ProdFeeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProdFee} and its DTO {@link ProdFeeDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProdFeeMapper extends EntityMapper<ProdFeeDTO, ProdFee> {
    @Mapping(target = "prod", source = "prod", qualifiedByName = "prodId")
    ProdFeeDTO toDto(ProdFee s);

    @Named("prodId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProdDTO toDtoProdId(Prod prod);
}
