package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Prod;
import com.wcc.gma2.domain.ProdSticker;
import com.wcc.gma2.domain.Sticker;
import com.wcc.gma2.service.dto.ProdDTO;
import com.wcc.gma2.service.dto.ProdStickerDTO;
import com.wcc.gma2.service.dto.StickerDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProdSticker} and its DTO {@link ProdStickerDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProdStickerMapper extends EntityMapper<ProdStickerDTO, ProdSticker> {
    @Mapping(target = "prod", source = "prod", qualifiedByName = "prodId")
    @Mapping(target = "sticker", source = "sticker", qualifiedByName = "stickerId")
    ProdStickerDTO toDto(ProdSticker s);

    @Named("prodId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProdDTO toDtoProdId(Prod prod);

    @Named("stickerId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    StickerDTO toDtoStickerId(Sticker sticker);
}
