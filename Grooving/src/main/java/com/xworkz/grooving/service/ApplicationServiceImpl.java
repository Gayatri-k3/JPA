package com.xworkz.grooving.service;

import com.xworkz.grooving.entity.ApplicationEntity;
import com.xworkz.grooving.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService{
    ApplicationRepository applicationRepository;
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }
    @Override
    public boolean save(ApplicationEntity applicationEntity) {
        if (applicationEntity != null) {
            if (applicationEntity.getApplicationName() == null || applicationEntity.getApplicationName().isEmpty() ||
                    applicationEntity.getApplicationName().length() < 2 || applicationEntity.getApplicationName().length() > 20) {
                System.out.println("Invalid Application name");
                return false;
            }
            if (applicationEntity.getApplicationSize() == null || applicationEntity.getApplicationSize().isEmpty()) {
                System.out.println("Invalid Application size");
                return false;
            }
            if (applicationEntity.getCompany() == null || applicationEntity.getCompany().isEmpty()) {
                System.out.println("Invalid Application company");
                return false;
            }
            if (applicationEntity.getRatings() == null) {
                System.out.println("Invalid ratings");
                return false;
            }
            if (applicationEntity.getLaunchDate() == null) {
                System.out.println("Invalid LaunchDate");
                return false;
            }
            if (applicationEntity.getNoOfUSers() == null) {
                System.out.println("Invalid noOfUsers");
                return false;
            }

            System.out.println("All validations passed");
            applicationRepository.saveApplication(applicationEntity); // no NullPointer now
            return true;
        }
        return false;
    }
}