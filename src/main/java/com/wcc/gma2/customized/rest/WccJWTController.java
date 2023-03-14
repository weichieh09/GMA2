package com.wcc.gma2.customized.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wcc.gma.customized.dto.ResponseDTO;
import com.wcc.gma.customized.service.WccJWTService;
import com.wcc.gma.customized.type.StatusCode;
import com.wcc.gma.security.jwt.JWTFilter;
import com.wcc.gma.web.rest.vm.LoginVM;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to authenticate users.
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class WccJWTController {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private WccJWTService wccJWTService;

    //    @PostMapping("/authenticate")
    public ResponseEntity<ResponseDTO> authorize(@Valid @RequestBody LoginVM loginVM, HttpServletRequest httpServletRequest) {
        ResponseDTO responseDTO = new ResponseDTO<>();
        JWTToken jwtToken = new JWTToken();
        HttpHeaders httpHeaders = new HttpHeaders();

        try {
            String jwt = wccJWTService.getJwtFromOriginalAuthorize(loginVM);

            jwtToken.setIdToken(jwt);
            httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

            responseDTO.setContent(jwtToken);
            responseDTO.setStatusCode(StatusCode.SUCCESS);
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }

        return ResponseEntity.ok().headers(httpHeaders).body(responseDTO);
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    static class JWTToken {

        private String idToken;

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }
    }
}
