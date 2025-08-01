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

//        applicationEntity.setApplicationName("Meesho");
//        applicationEntity.setApplicationSize("120");
//        applicationEntity.setCompany("Flipkart");
//        applicationEntity.setRatings(4.0f);
//        applicationEntity.setLaunchDate(LocalDate.now());
//        applicationEntity.setNoOfUSers(9000);
//        applicationService.save(applicationEntity);
//
//        applicationRepository.readApplication(2);
//
//        applicationEntity.setApplicationName("PyCharm");
//        applicationEntity.setApplicationSize("33");
//        applicationEntity.setCompany("JetBrains");
//        applicationEntity.setRatings(5.0f);
//        applicationEntity.setLaunchDate(LocalDate.now());
//        applicationEntity.setNoOfUSers(110);
//        applicationRepository.updateApplication(applicationEntity, 3);
//
//
//        applicationRepository.readApplication(3);
//
//        applicationRepository.deleteApplication(2);

        applicationRepository.findByCompany("Amazon");
        applicationRepository.findByRatings(4.0f);
        applicationRepository.findBySize("33");
        applicationRepository.findByUsers(110);


    }
}
