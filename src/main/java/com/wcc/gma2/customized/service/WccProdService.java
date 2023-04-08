package com.wcc.gma2.customized.service;

import com.wcc.gma2.customized.dto.WccProdDTO;
import com.wcc.gma2.customized.utils.LongFilterUtils;
import com.wcc.gma2.service.ProdService;
import com.wcc.gma2.service.ProdStickerQueryService;
import com.wcc.gma2.service.ProdStickerService;
import com.wcc.gma2.service.StickerService;
import com.wcc.gma2.service.criteria.ProdStdCriteria;
import com.wcc.gma2.service.criteria.ProdStickerCriteria;
import com.wcc.gma2.service.dto.ProdDTO;
import com.wcc.gma2.service.dto.ProdStickerDTO;
import com.wcc.gma2.service.dto.StickerDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class WccProdService {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private ProdService prodService;

    @Autowired
    private StickerService stickerService;

    @Autowired
    private ProdStickerService prodStickerService;

    @Autowired
    private ProdStickerQueryService prodStickerQueryService;

    @Transactional
    public ProdDTO save(WccProdDTO wccProdDTO) {
        List<StickerDTO> StickerList = wccProdDTO.getProdStickerList();
        ProdDTO result = prodService.save(this.getProdDTO(wccProdDTO));
        for (StickerDTO dto : StickerList) {
            dto = stickerService.save(dto);
            ProdStickerDTO prodStickerDTO = new ProdStickerDTO();
            prodStickerDTO.setSticker(dto);
            prodStickerDTO.setProd(result);
            prodStickerService.save(prodStickerDTO);
        }
        return result;
    }

    private ProdDTO getProdDTO(WccProdDTO source) {
        ProdDTO target = new ProdDTO();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    @Transactional
    public ProdDTO update(WccProdDTO wccProdDTO) {
        List<StickerDTO> StickerList = wccProdDTO.getProdStickerList();
        ProdDTO result = prodService.update(this.getProdDTO(wccProdDTO));
        // Delete all prodSticker
        ProdStickerCriteria criteria = new ProdStickerCriteria();
        criteria.setProdId(LongFilterUtils.toEqualLongFilter(result.getId()));
        List<ProdStickerDTO> byCriteria = prodStickerQueryService.findByCriteria(criteria);
        for (ProdStickerDTO dto : byCriteria) {
            stickerService.delete(dto.getSticker().getId());
            prodStickerService.delete(dto.getId());
        }
        // Save new prodSticker
        for (StickerDTO dto : StickerList) {
            dto = stickerService.save(dto);
            ProdStickerDTO prodStickerDTO = new ProdStickerDTO();
            prodStickerDTO.setSticker(dto);
            prodStickerDTO.setProd(result);
            prodStickerService.save(prodStickerDTO);
        }
        return result;
    }

    public WccProdDTO findOne(Long id) {
        // ProdDTO
        ProdDTO prodDTO = null;
        Optional<ProdDTO> one = prodService.findOne(id);
        if (one.isPresent()) {
            prodDTO = one.get();
        }
        // StickerDTOList
        List<StickerDTO> stickerList = new ArrayList<>();
        ProdStickerCriteria criteria = new ProdStickerCriteria();
        criteria.setProdId(LongFilterUtils.toEqualLongFilter(id));
        List<ProdStickerDTO> byCriteria = prodStickerQueryService.findByCriteria(criteria);
        if (byCriteria != null && byCriteria.size() > 0) {
            for (ProdStickerDTO dto : byCriteria) {
                stickerList.add(dto.getSticker());
            }
        }
        // WccProdDTO
        WccProdDTO wccProdDTO = new WccProdDTO();
        BeanUtils.copyProperties(prodDTO, wccProdDTO);
        wccProdDTO.setProdStickerList(stickerList);
        return wccProdDTO;
    }
}
