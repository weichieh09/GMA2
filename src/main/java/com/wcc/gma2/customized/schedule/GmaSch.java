package com.wcc.gma2.customized.schedule;

import com.wcc.gma2.customized.service.CerfSchService;
import com.wcc.gma2.customized.service.StdSchService;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GmaSch {

    @Autowired
    private CerfSchService cerfSchService;

    @Autowired
    private StdSchService stdSchService;

    @Scheduled(cron = "0 0 */1 * * ?", zone = "Asia/Taipei")
    public void checkCerfStatus() {
        log.info("[開始]檢查 證書 有效性");
        cerfSchService.checkCerfStatus();
        log.info("[結束]檢查 證書 有效性");
        log.info("[開始]檢查 標準 有效性");
        stdSchService.checkStdStatus();
        log.info("[結束]檢查 標準 有效性");
        //        LocalDate next = LocalDate.now().plus(1, ChronoUnit.MINUTES);
        //        log.info("下次檢查有效性時間點: {}", next);
    }
}
