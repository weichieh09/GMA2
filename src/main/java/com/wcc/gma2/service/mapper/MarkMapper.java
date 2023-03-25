package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Country;
import com.wcc.gma2.domain.Mark;
import com.wcc.gma2.service.dto.CountryDTO;
import com.wcc.gma2.service.dto.MarkDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Mark} and its DTO {@link MarkDTO}.
 */
@Mapper(componentModel = "spring")
public interface MarkMapper extends EntityMapper<MarkDTO, Mark> {
    @Mapping(target = "country", source = "country", qualifiedByName = "countryId")
    MarkDTO toDto(Mark s);

    @Named("countryId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CountryDTO toDtoCountryId(Country country);
}
