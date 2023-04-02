package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Cerf;
import com.wcc.gma2.domain.Company;
import com.wcc.gma2.domain.FeeProdCerfCompany;
import com.wcc.gma2.domain.Prod;
import com.wcc.gma2.service.dto.CerfDTO;
import com.wcc.gma2.service.dto.CompanyDTO;
import com.wcc.gma2.service.dto.FeeProdCerfCompanyDTO;
import com.wcc.gma2.service.dto.ProdDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link FeeProdCerfCompany} and its DTO {@link FeeProdCerfCompanyDTO}.
 */
@Mapper(componentModel = "spring")
public interface FeeProdCerfCompanyMapper extends EntityMapper<FeeProdCerfCompanyDTO, FeeProdCerfCompany> {
    @Mapping(target = "prod", source = "prod", qualifiedByName = "prodId")
    @Mapping(target = "cerf", source = "cerf", qualifiedByName = "cerfId")
    @Mapping(target = "company", source = "company", qualifiedByName = "companyId")
    FeeProdCerfCompanyDTO toDto(FeeProdCerfCompany s);

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
