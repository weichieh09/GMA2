package com.wcc.gma2.customized.service;

import com.wcc.gma.security.jwt.TokenProvider;
import com.wcc.gma.web.rest.vm.LoginVM;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WccJWTService {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    public String getJwtFromOriginalAuthorize(LoginVM loginVM) {
        String result = "";

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
            loginVM.getUsername(),
            loginVM.getPassword()
        );

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        result = tokenProvider.createToken(authentication, loginVM.isRememberMe());

        return result;
    }
}
