package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Mark;
import com.wcc.gma2.domain.Sticker;
import com.wcc.gma2.domain.StickerMark;
import com.wcc.gma2.service.dto.MarkDTO;
import com.wcc.gma2.service.dto.StickerDTO;
import com.wcc.gma2.service.dto.StickerMarkDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link StickerMark} and its DTO {@link StickerMarkDTO}.
 */
@Mapper(componentModel = "spring")
public interface StickerMarkMapper extends EntityMapper<StickerMarkDTO, StickerMark> {
    @Mapping(target = "sticker", source = "sticker", qualifiedByName = "stickerId")
    @Mapping(target = "mark", source = "mark", qualifiedByName = "markId")
    StickerMarkDTO toDto(StickerMark s);

    @Named("stickerId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    StickerDTO toDtoStickerId(Sticker sticker);

    @Named("markId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    MarkDTO toDtoMarkId(Mark mark);
}
