package com.wcc.gma2.customized.dto;

import com.wcc.gma2.service.dto.*;
import java.util.List;
import lombok.Data;

@Data
public class Wcc111Res {

    private CerfDTO cerf;

    private List<Cerf2MnfctrViewDTO> cerf2Mnfctr;

    private List<Cerf2ProdViewDTO> cerf2Prod;

    private List<Cerf2StdViewDTO> cerf2Std;

    private List<CerfViewDTO> cerf2CerfFee;
}
