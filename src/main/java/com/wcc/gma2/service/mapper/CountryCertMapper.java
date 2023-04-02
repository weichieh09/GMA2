package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Cerf;
import com.wcc.gma2.domain.Country;
import com.wcc.gma2.domain.CountryCert;
import com.wcc.gma2.service.dto.CerfDTO;
import com.wcc.gma2.service.dto.CountryCertDTO;
import com.wcc.gma2.service.dto.CountryDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CountryCert} and its DTO {@link CountryCertDTO}.
 */
@Mapper(componentModel = "spring")
public interface CountryCertMapper extends EntityMapper<CountryCertDTO, CountryCert> {
    @Mapping(target = "country", source = "country", qualifiedByName = "countryId")
    @Mapping(target = "cerf", source = "cerf", qualifiedByName = "cerfId")
    CountryCertDTO toDto(CountryCert s);

    @Named("countryId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CountryDTO toDtoCountryId(Country country);

    @Named("cerfId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CerfDTO toDtoCerfId(Cerf cerf);
}
