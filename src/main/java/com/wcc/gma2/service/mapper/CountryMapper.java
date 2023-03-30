package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Country;
import com.wcc.gma2.domain.Std;
import com.wcc.gma2.service.dto.CountryDTO;
import com.wcc.gma2.service.dto.StdDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Country} and its DTO {@link CountryDTO}.
 */
@Mapper(componentModel = "spring")
public interface CountryMapper extends EntityMapper<CountryDTO, Country> {
    @Mapping(target = "stds", source = "stds", qualifiedByName = "stdIdSet")
    CountryDTO toDto(Country s);

    @Mapping(target = "removeStd", ignore = true)
    Country toEntity(CountryDTO countryDTO);

    @Named("stdId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    StdDTO toDtoStdId(Std std);

    @Named("stdIdSet")
    default Set<StdDTO> toDtoStdIdSet(Set<Std> std) {
        return std.stream().map(this::toDtoStdId).collect(Collectors.toSet());
    }
}
