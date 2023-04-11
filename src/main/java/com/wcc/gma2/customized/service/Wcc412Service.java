package com.wcc.gma2.customized.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class Wcc412Service {

    private final String CLASS_NAME = this.getClass().getSimpleName();
}
