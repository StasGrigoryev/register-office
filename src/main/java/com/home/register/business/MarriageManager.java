package com.home.register.business;

import com.home.register.dao.MarriageDao;
import com.home.register.dao.PersonDao;
import com.home.register.domain.MarriageCertificate;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import com.home.register.view.MarriageRequest;
import com.home.register.view.MarriageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Setter
@Slf4j
@Service("marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarriageManager {
    @Autowired
    private MarriageDao marriageDao;
    @Autowired
    private PersonDao personDao;

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        log.info("findMarriageCertificate called from marriage manager");
        MarriageCertificate cert = marriageDao.findMarriageCertificate(request);

        personDao.findPersons();

        return new MarriageResponse();
    }
}
