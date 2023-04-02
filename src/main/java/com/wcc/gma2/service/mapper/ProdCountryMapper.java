package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Country;
import com.wcc.gma2.domain.Prod;
import com.wcc.gma2.domain.ProdCountry;
import com.wcc.gma2.service.dto.CountryDTO;
import com.wcc.gma2.service.dto.ProdCountryDTO;
import com.wcc.gma2.service.dto.ProdDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProdCountry} and its DTO {@link ProdCountryDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProdCountryMapper extends EntityMapper<ProdCountryDTO, ProdCountry> {
    @Mapping(target = "prod", source = "prod", qualifiedByName = "prodId")
    @Mapping(target = "country", source = "country", qualifiedByName = "countryId")
    ProdCountryDTO toDto(ProdCountry s);

    @Named("prodId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProdDTO toDtoProdId(Prod prod);

    @Named("countryId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CountryDTO toDtoCountryId(Country country);
}
