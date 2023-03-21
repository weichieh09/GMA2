package com.wcc.gma2.customized.service;

import com.wcc.gma2.customized.utils.StringFilterUtils;
import com.wcc.gma2.service.*;
import com.wcc.gma2.service.criteria.*;
import com.wcc.gma2.service.dto.*;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Wcc110Service {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private CerfQueryService cerfQueryService;

    @Autowired
    private Cerf2MnfctrViewQueryService cerf2MnfctrViewQueryService;

    @Autowired
    private Cerf2ProdViewQueryService cerf2ProdViewQueryService;

    @Autowired
    private Cerf2StdViewQueryService cerf2StdViewQueryService;

    @Autowired
    private CerfViewQueryService cerfViewQueryService;

    public List<CerfDTO> findByCerf(String cerfNo, String cerfVer) {
        CerfCriteria criteria = new CerfCriteria();
        criteria.setCerfNo(StringFilterUtils.toEqualStringFilter(cerfNo));
        criteria.setCerfVer(StringFilterUtils.toEqualStringFilter(cerfVer));
        return cerfQueryService.findByCriteria(criteria);
    }

    public List<Cerf2MnfctrViewDTO> findByCerf2MnfctrView(String cerfNo, String cerfVer) {
        Cerf2MnfctrViewCriteria criteria = new Cerf2MnfctrViewCriteria();
        criteria.setCerfNo(StringFilterUtils.toEqualStringFilter(cerfNo));
        criteria.setCerfVer(StringFilterUtils.toEqualStringFilter(cerfVer));
        return cerf2MnfctrViewQueryService.findByCriteria(criteria);
    }

    public List<Cerf2ProdViewDTO> findByCerf2ProdView(String cerfNo, String cerfVer) {
        Cerf2ProdViewCriteria criteria = new Cerf2ProdViewCriteria();
        criteria.setCerfNo(StringFilterUtils.toEqualStringFilter(cerfNo));
        criteria.setCerfVer(StringFilterUtils.toEqualStringFilter(cerfVer));
        return cerf2ProdViewQueryService.findByCriteria(criteria);
    }

    public List<Cerf2StdViewDTO> findByCerf2StdView(String cerfNo, String cerfVer) {
        Cerf2StdViewCriteria criteria = new Cerf2StdViewCriteria();
        criteria.setCerfNo(StringFilterUtils.toEqualStringFilter(cerfNo));
        criteria.setCerfVer(StringFilterUtils.toEqualStringFilter(cerfVer));
        return cerf2StdViewQueryService.findByCriteria(criteria);
    }

    public List<CerfViewDTO> findByCerfView(String cerfNo, String cerfVer) {
        CerfViewCriteria criteria = new CerfViewCriteria();
        criteria.setCerfNo(StringFilterUtils.toEqualStringFilter(cerfNo));
        criteria.setCerfVer(StringFilterUtils.toEqualStringFilter(cerfVer));
        return cerfViewQueryService.findByCriteria(criteria);
    }
}
