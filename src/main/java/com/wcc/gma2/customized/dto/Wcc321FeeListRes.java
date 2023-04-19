package com.wcc.gma2.customized.dto;

import com.wcc.gma2.domain.FeeProdCerfCompany;
import com.wcc.gma2.service.dto.ProdDTO;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class Wcc321FeeListRes {

    ProdDTO prod;
    List<FeeProdCerfCompany> feeDetailList;
    List<String> timeLine;
    List<Object> feeObjectList;
}
