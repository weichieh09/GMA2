package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.CerfImg;
import com.wcc.gma2.service.dto.CerfImgDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CerfImg} and its DTO {@link CerfImgDTO}.
 */
@Mapper(componentModel = "spring")
public interface CerfImgMapper extends EntityMapper<CerfImgDTO, CerfImg> {}
