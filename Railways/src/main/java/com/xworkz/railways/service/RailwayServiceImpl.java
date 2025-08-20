package com.xworkz.railways.service;

import com.xworkz.railways.dto.RailwayDTO;
import com.xworkz.railways.entity.RailwayEntity;
import com.xworkz.railways.repository.RailwayRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RailwayServiceImpl implements RailwayService{
    public RailwayServiceImpl(){
        System.out.println("RailwayServiceImpl loaded");
    }
    @Autowired
    private RailwayRepository railwayRepository;
    @Override
    public boolean validateAndSave(RailwayDTO dto) {
        System.out.println("Service data: " +dto);
        if (dto!=null){
            RailwayEntity entity = new RailwayEntity();
            BeanUtils.copyProperties(entity, dto);
            return railwayRepository.save(entity);
        }
        return false;
    }

}
