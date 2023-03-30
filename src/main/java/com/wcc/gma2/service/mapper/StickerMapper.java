package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Mark;
import com.wcc.gma2.domain.Prod;
import com.wcc.gma2.domain.Sticker;
import com.wcc.gma2.service.dto.MarkDTO;
import com.wcc.gma2.service.dto.ProdDTO;
import com.wcc.gma2.service.dto.StickerDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Sticker} and its DTO {@link StickerDTO}.
 */
@Mapper(componentModel = "spring")
public interface StickerMapper extends EntityMapper<StickerDTO, Sticker> {
    @Mapping(target = "marks", source = "marks", qualifiedByName = "markIdSet")
    @Mapping(target = "prod", source = "prod", qualifiedByName = "prodId")
    StickerDTO toDto(Sticker s);

    @Mapping(target = "removeMark", ignore = true)
    Sticker toEntity(StickerDTO stickerDTO);

    @Named("markId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    MarkDTO toDtoMarkId(Mark mark);

    @Named("markIdSet")
    default Set<MarkDTO> toDtoMarkIdSet(Set<Mark> mark) {
        return mark.stream().map(this::toDtoMarkId).collect(Collectors.toSet());
    }

    @Named("prodId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProdDTO toDtoProdId(Prod prod);
}
