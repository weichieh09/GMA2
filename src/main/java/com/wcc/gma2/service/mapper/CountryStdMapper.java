package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Country;
import com.wcc.gma2.domain.CountryStd;
import com.wcc.gma2.domain.Std;
import com.wcc.gma2.service.dto.CountryDTO;
import com.wcc.gma2.service.dto.CountryStdDTO;
import com.wcc.gma2.service.dto.StdDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CountryStd} and its DTO {@link CountryStdDTO}.
 */
@Mapper(componentModel = "spring")
public interface CountryStdMapper extends EntityMapper<CountryStdDTO, CountryStd> {
    @Mapping(target = "country", source = "country", qualifiedByName = "countryId")
    @Mapping(target = "std", source = "std", qualifiedByName = "stdId")
    CountryStdDTO toDto(CountryStd s);

    @Named("countryId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CountryDTO toDtoCountryId(Country country);

    @Named("stdId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    StdDTO toDtoStdId(Std std);
}
