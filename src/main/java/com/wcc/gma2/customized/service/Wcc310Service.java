package com.wcc.gma2.customized.service;

import com.wcc.gma2.customized.dto.FeeDTO;
import com.wcc.gma2.customized.dto.IdDTO;
import com.wcc.gma2.customized.dto.Wcc311SaveAllReq;
import com.wcc.gma2.customized.type.StatusCode;
import com.wcc.gma2.service.*;
import com.wcc.gma2.service.dto.*;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class Wcc310Service {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private CerfService cerfService;

    @Autowired
    private CerfCompanyService cerfCompanyService;

    @Autowired
    private CerfProdService cerfProdService;

    @Autowired
    private CerfStdService cerfStdService;

    @Autowired
    private FeeProdCerfCompanyService feeProdCerfCompanyService;

    @Autowired
    private CerfMarkService cerfMarkService;

    public StatusCode saveAll(Wcc311SaveAllReq req) {
        try {
            if (!this.checkCerf(req)) return StatusCode.FAIL;
            CerfDTO cerfDTO = cerfService.save(this.getCerf(req));
            for (CerfCompanyDTO cerfCompanyDTO : this.getCerfCompany(req, cerfDTO)) cerfCompanyService.save(cerfCompanyDTO);
            for (CerfProdDTO cerfProdDTO : this.getCerfProd(req, cerfDTO)) cerfProdService.save(cerfProdDTO);
            for (CerfStdDTO cerfStdDTO : this.getCerfStd(req, cerfDTO)) cerfStdService.save(cerfStdDTO);
            for (FeeProdCerfCompanyDTO feeDTO : this.getFee(req, cerfDTO)) feeProdCerfCompanyService.save(feeDTO);
            cerfMarkService.save(this.getCerfMark(req, cerfDTO));
            return StatusCode.SUCCESS;
        } catch (Exception e) {
            log.error(CLASS_NAME + ".saveAll() - " + e.getMessage());
            return StatusCode.FAIL;
        }
    }

    private CerfMarkDTO getCerfMark(Wcc311SaveAllReq req, CerfDTO cerfDTO) {
        CerfMarkDTO result = new CerfMarkDTO();
        MarkDTO markDTO = new MarkDTO();
        markDTO.setId(req.getMark().getId());
        result.setCerf(cerfDTO);
        result.setMark(markDTO);
        return result;
    }

    private Boolean checkCerf(Wcc311SaveAllReq req) {
        if (req.getCerfNo() != null && !req.getCerfNo().isBlank() && req.getCerfVer() != null && !req.getCerfVer().isBlank()) return true;
        return false;
    }

    private List<FeeProdCerfCompanyDTO> getFee(Wcc311SaveAllReq req, CerfDTO cerfDTO) {
        List<FeeProdCerfCompanyDTO> list = new ArrayList<>();
        List<FeeDTO> feeList = req.getFeeList();
        FeeProdCerfCompanyDTO fee = null;
        for (FeeDTO feeDTO : feeList) {
            fee = new FeeProdCerfCompanyDTO();
            fee.setFee(feeDTO.getFee());
            fee.setFeeType(feeDTO.getFeeType());
            fee.setFeeDt(feeDTO.getFeeDt());
            fee.setCerf(cerfDTO);
            list.add(fee);
        }
        return list;
    }

    private List<CerfStdDTO> getCerfStd(Wcc311SaveAllReq req, CerfDTO cerfDTO) {
        List<CerfStdDTO> list = new ArrayList<>();
        List<IdDTO> stdList = req.getStdList();
        StdDTO stdDTO = null;
        CerfStdDTO cerfStdDTO = null;
        for (IdDTO idDTO : stdList) {
            Long stdId = idDTO.getId();
            stdDTO = new StdDTO();
            stdDTO.setId(stdId);
            cerfStdDTO = new CerfStdDTO();
            cerfStdDTO.setStd(stdDTO);
            cerfStdDTO.setCerf(cerfDTO);
            list.add(cerfStdDTO);
        }
        return list;
    }

    private List<CerfProdDTO> getCerfProd(Wcc311SaveAllReq req, CerfDTO cerfDTO) {
        List<CerfProdDTO> list = new ArrayList<>();
        List<IdDTO> prodList = req.getProdList();
        ProdDTO prodDTO = null;
        CerfProdDTO cerfProdDTO = null;
        for (IdDTO idDTO : prodList) {
            Long prodId = idDTO.getId();
            prodDTO = new ProdDTO();
            prodDTO.setId(prodId);
            cerfProdDTO = new CerfProdDTO();
            cerfProdDTO.setProd(prodDTO);
            cerfProdDTO.setCerf(cerfDTO);
            list.add(cerfProdDTO);
        }
        return list;
    }

    private List<CerfCompanyDTO> getCerfCompany(Wcc311SaveAllReq req, CerfDTO cerfDTO) {
        List<CerfCompanyDTO> list = new ArrayList<>();
        CompanyDTO companyDTO = null;
        CerfCompanyDTO cerfCompanyDTO = null;
        // APPLY
        Long applyId = req.getApply().getId();
        companyDTO = new CompanyDTO();
        cerfCompanyDTO = new CerfCompanyDTO();
        companyDTO.setId(applyId);
        cerfCompanyDTO.setCompany(companyDTO);
        cerfCompanyDTO.setCerf(cerfDTO);
        cerfCompanyDTO.setRelType("APPLY");
        list.add(cerfCompanyDTO);
        //MNFCTR
        Long mnfctrId = req.getMnfctr().getId();
        companyDTO = new CompanyDTO();
        cerfCompanyDTO = new CerfCompanyDTO();
        companyDTO.setId(mnfctrId);
        cerfCompanyDTO.setCompany(companyDTO);
        cerfCompanyDTO.setCerf(cerfDTO);
        cerfCompanyDTO.setRelType("MNFCTR");
        list.add(cerfCompanyDTO);
        //FCTY
        List<IdDTO> fctyList = req.getFctyList();
        for (IdDTO idDTO : fctyList) {
            Long fctyId = idDTO.getId();
            companyDTO = new CompanyDTO();
            cerfCompanyDTO = new CerfCompanyDTO();
            companyDTO.setId(fctyId);
            cerfCompanyDTO.setCompany(companyDTO);
            cerfCompanyDTO.setCerf(cerfDTO);
            cerfCompanyDTO.setRelType("FCTY");
            list.add(cerfCompanyDTO);
        }
        return list;
    }

    private CerfDTO getCerf(Wcc311SaveAllReq req) {
        CerfDTO result = new CerfDTO();
        result.setCerfNo(req.getCerfNo());
        result.setCerfVer(req.getCerfVer());
        result.setPdf(req.getPdf());
        result.setPdfContentType(req.getPdfContentType());
        result.setIssuDt(req.getIssuDt());
        result.setExpDt(req.getExpDt());
        return result;
    }
}
