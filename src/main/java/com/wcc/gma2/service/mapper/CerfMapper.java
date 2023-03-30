package com.wcc.gma2.service.mapper;

import com.wcc.gma2.domain.Cerf;
import com.wcc.gma2.domain.Country;
import com.wcc.gma2.domain.Mark;
import com.wcc.gma2.domain.Prod;
import com.wcc.gma2.domain.Std;
import com.wcc.gma2.service.dto.CerfDTO;
import com.wcc.gma2.service.dto.CountryDTO;
import com.wcc.gma2.service.dto.MarkDTO;
import com.wcc.gma2.service.dto.ProdDTO;
import com.wcc.gma2.service.dto.StdDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Cerf} and its DTO {@link CerfDTO}.
 */
@Mapper(componentModel = "spring")
public interface CerfMapper extends EntityMapper<CerfDTO, Cerf> {
    @Mapping(target = "prods", source = "prods", qualifiedByName = "prodIdSet")
    @Mapping(target = "stds", source = "stds", qualifiedByName = "stdIdSet")
    @Mapping(target = "marks", source = "marks", qualifiedByName = "markIdSet")
    @Mapping(target = "country", source = "country", qualifiedByName = "countryId")
    CerfDTO toDto(Cerf s);

    @Mapping(target = "removeProd", ignore = true)
    @Mapping(target = "removeStd", ignore = true)
    @Mapping(target = "removeMark", ignore = true)
    Cerf toEntity(CerfDTO cerfDTO);

    @Named("prodId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProdDTO toDtoProdId(Prod prod);

    @Named("prodIdSet")
    default Set<ProdDTO> toDtoProdIdSet(Set<Prod> prod) {
        return prod.stream().map(this::toDtoProdId).collect(Collectors.toSet());
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

    @Named("countryId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CountryDTO toDtoCountryId(Country country);
}
