package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Country;
import com.wcc.gma2.domain.Mark;
import com.wcc.gma2.domain.Prod;
import com.wcc.gma2.domain.Std;
import com.wcc.gma2.service.dto.CountryDTO;
import com.wcc.gma2.service.dto.MarkDTO;
import com.wcc.gma2.service.dto.ProdDTO;
import com.wcc.gma2.service.dto.StdDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Prod} and its DTO {@link ProdDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProdMapper extends EntityMapper<ProdDTO, Prod> {
    @Mapping(target = "countries", source = "countries", qualifiedByName = "countryIdSet")
    @Mapping(target = "stds", source = "stds", qualifiedByName = "stdIdSet")
    @Mapping(target = "marks", source = "marks", qualifiedByName = "markIdSet")
    ProdDTO toDto(Prod s);

    @Mapping(target = "removeCountry", ignore = true)
    @Mapping(target = "removeStd", ignore = true)
    @Mapping(target = "removeMark", ignore = true)
    Prod toEntity(ProdDTO prodDTO);

    @Named("countryId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CountryDTO toDtoCountryId(Country country);

    @Named("countryIdSet")
    default Set<CountryDTO> toDtoCountryIdSet(Set<Country> country) {
        return country.stream().map(this::toDtoCountryId).collect(Collectors.toSet());
    }

    @Named("stdId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    StdDTO toDtoStdId(Std std);

    @Named("stdIdSet")
    default Set<StdDTO> toDtoStdIdSet(Set<Std> std) {
        return std.stream().map(this::toDtoStdId).collect(Collectors.toSet());
    }

    @Named("markId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    MarkDTO toDtoMarkId(Mark mark);

    @Named("markIdSet")
    default Set<MarkDTO> toDtoMarkIdSet(Set<Mark> mark) {
        return mark.stream().map(this::toDtoMarkId).collect(Collectors.toSet());
    }
}
