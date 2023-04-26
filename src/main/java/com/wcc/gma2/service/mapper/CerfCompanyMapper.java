package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Cerf;
import com.wcc.gma2.domain.CerfCompany;
import com.wcc.gma2.domain.Company;
import com.wcc.gma2.service.dto.CerfCompanyDTO;
import com.wcc.gma2.service.dto.CerfDTO;
import com.wcc.gma2.service.dto.CompanyDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CerfCompany} and its DTO {@link CerfCompanyDTO}.
 */
@Mapper(componentModel = "spring")
public interface CerfCompanyMapper extends EntityMapper<CerfCompanyDTO, CerfCompany> {
    @Mapping(target = "cerf", source = "cerf", qualifiedByName = "cerfId")
    @Mapping(target = "company", source = "company", qualifiedByName = "companyId")
    CerfCompanyDTO toDto(CerfCompany s);

    @Named("cerfId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "cerfNo", source = "cerfNo")
    @Mapping(target = "cerfVer", source = "cerfVer")
    CerfDTO toDtoCerfId(Cerf cerf);

    @Named("companyId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "chName", source = "chName")
    @Mapping(target = "enName", source = "enName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "peopleName", source = "peopleName")
    CompanyDTO toDtoCompanyId(Company company);
}
