package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Cerf;
import com.wcc.gma2.domain.CerfMark;
import com.wcc.gma2.domain.Mark;
import com.wcc.gma2.service.dto.CerfDTO;
import com.wcc.gma2.service.dto.CerfMarkDTO;
import com.wcc.gma2.service.dto.MarkDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CerfMark} and its DTO {@link CerfMarkDTO}.
 */
@Mapper(componentModel = "spring")
public interface CerfMarkMapper extends EntityMapper<CerfMarkDTO, CerfMark> {
    @Mapping(target = "cerf", source = "cerf", qualifiedByName = "cerfId")
    @Mapping(target = "mark", source = "mark", qualifiedByName = "markId")
    CerfMarkDTO toDto(CerfMark s);

    @Named("cerfId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CerfDTO toDtoCerfId(Cerf cerf);

    @Named("markId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "markNo", source = "markNo")
    @Mapping(target = "chName", source = "chName")
    @Mapping(target = "img", source = "img")
    MarkDTO toDtoMarkId(Mark mark);
}
