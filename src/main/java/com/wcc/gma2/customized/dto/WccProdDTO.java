package com.wcc.gma2.customized.dto;

import com.wcc.gma2.service.dto.ProdDTO;
import com.wcc.gma2.service.dto.StickerDTO;
import java.util.List;
import lombok.Data;

@Data
public class WccProdDTO extends ProdDTO {

    private List<StickerDTO> prodStickerList;
}
