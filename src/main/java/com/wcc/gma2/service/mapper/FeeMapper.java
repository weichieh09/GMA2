package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Cerf;
import com.wcc.gma2.domain.Company;
import com.wcc.gma2.domain.Fee;
import com.wcc.gma2.domain.Prod;
import com.wcc.gma2.service.dto.CerfDTO;
import com.wcc.gma2.service.dto.CompanyDTO;
import com.wcc.gma2.service.dto.FeeDTO;
import com.wcc.gma2.service.dto.ProdDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Fee} and its DTO {@link FeeDTO}.
 */
@Mapper(componentModel = "spring")
public interface FeeMapper extends EntityMapper<FeeDTO, Fee> {
    @Mapping(target = "prod", source = "prod", qualifiedByName = "prodId")
    @Mapping(target = "cerf", source = "cerf", qualifiedByName = "cerfId")
    @Mapping(target = "company", source = "company", qualifiedByName = "companyId")
    FeeDTO toDto(Fee s);

    @Named("prodId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProdDTO toDtoProdId(Prod prod);

    @Named("cerfId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CerfDTO toDtoCerfId(Cerf cerf);

    @Named("companyId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CompanyDTO toDtoCompanyId(Company company);
}
