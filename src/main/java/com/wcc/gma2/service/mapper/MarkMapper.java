package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Cerf;
import com.wcc.gma2.domain.Country;
import com.wcc.gma2.domain.Mark;
import com.wcc.gma2.domain.Sticker;
import com.wcc.gma2.service.dto.CerfDTO;
import com.wcc.gma2.service.dto.CountryDTO;
import com.wcc.gma2.service.dto.MarkDTO;
import com.wcc.gma2.service.dto.StickerDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Mark} and its DTO {@link MarkDTO}.
 */
@Mapper(componentModel = "spring")
public interface MarkMapper extends EntityMapper<MarkDTO, Mark> {
    @Mapping(target = "country", source = "country", qualifiedByName = "countryId")
    @Mapping(target = "cerf", source = "cerf", qualifiedByName = "cerfId")
    @Mapping(target = "sticker", source = "sticker", qualifiedByName = "stickerId")
    MarkDTO toDto(Mark s);

    @Named("countryId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CountryDTO toDtoCountryId(Country country);

    @Named("cerfId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CerfDTO toDtoCerfId(Cerf cerf);

    @Named("stickerId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    StickerDTO toDtoStickerId(Sticker sticker);
}
