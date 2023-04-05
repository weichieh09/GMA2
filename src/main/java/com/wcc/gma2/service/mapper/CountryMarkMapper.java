package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Country;
import com.wcc.gma2.domain.CountryMark;
import com.wcc.gma2.domain.Mark;
import com.wcc.gma2.service.dto.CountryDTO;
import com.wcc.gma2.service.dto.CountryMarkDTO;
import com.wcc.gma2.service.dto.MarkDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CountryMark} and its DTO {@link CountryMarkDTO}.
 */
@Mapper(componentModel = "spring")
public interface CountryMarkMapper extends EntityMapper<CountryMarkDTO, CountryMark> {
    @Mapping(target = "country", source = "country", qualifiedByName = "countryId")
    @Mapping(target = "mark", source = "mark", qualifiedByName = "markId")
    CountryMarkDTO toDto(CountryMark s);

    @Named("countryId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CountryDTO toDtoCountryId(Country country);

    @Named("markId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "markNo", source = "markNo")
    @Mapping(target = "chName", source = "chName")
    @Mapping(target = "img", source = "img")
    @Mapping(target = "imgContentType", source = "imgContentType")
    MarkDTO toDtoMarkId(Mark mark);
}
