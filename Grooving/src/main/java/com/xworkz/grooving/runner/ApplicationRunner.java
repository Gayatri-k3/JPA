package com.xworkz.grooving.runner;

import com.xworkz.grooving.entity.ApplicationEntity;
import com.xworkz.grooving.repository.ApplicationRepository;
import com.xworkz.grooving.repository.ApplicationRepositoryImpl;
import com.xworkz.grooving.service.ApplicationService;
import com.xworkz.grooving.service.ApplicationServiceImpl;

import java.time.LocalDate;

public class ApplicationRunner {
    public static void main(String[] args) {
        ApplicationEntity applicationEntity = new ApplicationEntity();
        ApplicationRepository applicationRepository=new ApplicationRepositoryImpl();
        ApplicationService applicationService = new ApplicationServiceImpl(applicationRepository);

        applicationEntity.setApplicationName("IntelliJ");
        applicationEntity.setApplicationSize("23");
        applicationEntity.setCompany("JetBrains");
        applicationEntity.setRatings(5.0f);
        applicationEntity.setLaunchDate(LocalDate.now());
        applicationEntity.setNoOfUSers(80);
        applicationService.save(applicationEntity);

        applicationRepository.readApplication(1);

        applicationEntity.setApplicationName("PyCharm");
        applicationEntity.setApplicationSize("33");
        applicationEntity.setCompany("JetBrains");
        applicationEntity.setRatings(5.0f);
        applicationEntity.setLaunchDate(LocalDate.now());
        applicationEntity.setNoOfUSers(110);
        applicationRepository.updateApplication(applicationEntity, 1);


        applicationRepository.readApplication(1);

        applicationRepository.deleteApplication(1);
    }
}
