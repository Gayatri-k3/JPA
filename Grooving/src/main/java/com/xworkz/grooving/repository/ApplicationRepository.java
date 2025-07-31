package com.xworkz.grooving.repository;

import com.xworkz.grooving.entity.ApplicationEntity;

public interface ApplicationRepository {
    void saveApplication(ApplicationEntity applicationEntity);
    ApplicationEntity readApplication(Integer id);
    ApplicationEntity updateApplication(ApplicationEntity entity, Integer id);
    ApplicationEntity deleteApplication(Integer id);
}
