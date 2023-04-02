package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Sticker;
import com.wcc.gma2.service.dto.StickerDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Sticker} and its DTO {@link StickerDTO}.
 */
@Mapper(componentModel = "spring")
public interface StickerMapper extends EntityMapper<StickerDTO, Sticker> {}
