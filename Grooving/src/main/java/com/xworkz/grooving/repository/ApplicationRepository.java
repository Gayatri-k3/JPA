package com.xworkz.grooving.repository;

import com.xworkz.grooving.entity.ApplicationEntity;

public interface ApplicationRepository {
    void saveApplication(ApplicationEntity applicationEntity);
    ApplicationEntity readApplication(Integer id);
}
