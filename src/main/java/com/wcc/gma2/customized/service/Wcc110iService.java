package com.wcc.gma2.customized.service;

import com.wcc.gma2.customized.dto.Wcc111iReq;
import com.wcc.gma2.customized.utils.LongFilterUtils;
import com.wcc.gma2.customized.utils.StringFilterUtils;
import com.wcc.gma2.service.CerfQueryService;
import com.wcc.gma2.service.ProdQueryService;
import com.wcc.gma2.service.ProdService;
import com.wcc.gma2.service.criteria.CerfCriteria;
import com.wcc.gma2.service.criteria.ProdCriteria;
import com.wcc.gma2.service.dto.CerfDTO;
import com.wcc.gma2.service.dto.ProdDTO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class Wcc110iService {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private ProdQueryService prodQueryService;

    @Autowired
    private CerfQueryService cerfQueryService;

    public String test() {
        return CLASS_NAME;
    }

    public Long findProdId(Wcc111iReq req) {
        ProdCriteria criteria = new ProdCriteria();
        criteria.setProdNo(StringFilterUtils.toEqualStringFilter(req.getProdNo()));
        criteria.setHsCode(StringFilterUtils.toEqualStringFilter(req.getHsCode()));
        criteria.setCccCode(StringFilterUtils.toEqualStringFilter(req.getCccCode()));
        List<ProdDTO> byCriteria = prodQueryService.findByCriteria(criteria);
        log.info("{}", byCriteria);
        if (byCriteria.size() == 1) {
            return byCriteria.get(0).getId();
        } else {
            return null;
        }
    }

    public Page<CerfDTO> findCerfByProdId(Long prodId, PageRequest pageRequest) {
        CerfCriteria criteria = new CerfCriteria();
        criteria.setProdId(LongFilterUtils.toEqualLongFilter(prodId));
        return cerfQueryService.findByCriteria(criteria, pageRequest);
    }
}
