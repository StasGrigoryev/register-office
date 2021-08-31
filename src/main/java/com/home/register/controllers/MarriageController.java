package com.home.register.controllers;

import com.home.register.business.MarriageManager;
import com.home.register.view.MarriageResponse;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import com.home.register.view.MarriageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Setter
@Slf4j
@Service("controller")
public class MarriageController {
    @Autowired
    @Qualifier("marriageService")
    private MarriageManager marriageManager;

    public MarriageResponse findMarriageCertificate(MarriageRequest marriageRequest) {
        log.info("findMarriageCertificate called from controller");
        return marriageManager.findMarriageCertificate(marriageRequest);
    }
}
