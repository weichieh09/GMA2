package com.wcc.gma2.customized.service;

import com.wcc.gma2.customized.dto.ResponseDTO;
import com.wcc.gma2.customized.dto.SelectListDTO;
import com.wcc.gma2.customized.dto.Wcc312CerfListRes;
import com.wcc.gma2.customized.type.CerfStatusTypeList;
import com.wcc.gma2.domain.Country;
import com.wcc.gma2.repository.CountryRepository;
import com.wcc.gma2.service.CerfService;
import com.wcc.gma2.service.criteria.CountryCertCriteria;
import com.wcc.gma2.service.dto.CerfDTO;
import com.wcc.gma2.service.dto.CountryCertDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class Wcc312Service {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CerfService cerfService;

    public List<SelectListDTO> findCountryList() {
        List<SelectListDTO> list = new ArrayList<>();
        SelectListDTO selectListDTO = null;
        for (Country country : countryRepository.findAll()) {
            selectListDTO = new SelectListDTO(country.getChName(), country.getId().toString());
            list.add(selectListDTO);
        }
        return list;
    }

    public Page<CerfDTO> findCerfList(CountryCertCriteria req, Pageable pageable) {
        return null;
    }

    public List<Wcc312CerfListRes> getCerfList(List<CountryCertDTO> content) {
        List<Wcc312CerfListRes> list = new ArrayList<>();
        Wcc312CerfListRes dto = null;
        for (CountryCertDTO countryCertDTO : content) {
            dto = new Wcc312CerfListRes();
            dto.setId(countryCertDTO.getCerf().getId());
            dto.setCountry(countryCertDTO.getCountry().getChName());
            dto.setCerfNo(countryCertDTO.getCerf().getCerfNo());
            dto.setCerfVer(countryCertDTO.getCerf().getCerfVer());
            dto.setStatus(CerfStatusTypeList.toText(countryCertDTO.getCerf().getStatus()));
            list.add(dto);
        }
        return list;
    }

    public CerfDTO removeCerf(CerfDTO cerfDTO) {
        cerfDTO = cerfService.findOne(cerfDTO.getId()).get();
        cerfDTO.setStatus(CerfStatusTypeList.DELETE.getValue());
        cerfService.save(cerfDTO);
        return cerfDTO;
    }
}
