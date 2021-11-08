package org.treasure.chest.dev.template.event;

import org.treasure.chest.dev.template.event.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-11-05 18:19
 */
@Component
public class CheckRoad implements ApplicationRunner {

    @Autowired
    private EmailService emailService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        emailService.sendEmail("真北路1425号", "超级拥堵");
    }
}
