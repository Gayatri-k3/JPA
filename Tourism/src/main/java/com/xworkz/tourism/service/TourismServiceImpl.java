package com.xworkz.tourism.service;

import com.xworkz.tourism.dto.TourismDTO;
import com.xworkz.tourism.entity.TourismEntity;
import com.xworkz.tourism.repository.TourismRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourismServiceImpl implements TourismService{
    @Autowired
    private TourismRepository tourismRepository;


    @Override
    public boolean save(TourismDTO tourismDTO) {
        if (tourismDTO!=null){
            System.out.println("All details validated");
            return true;
        }
        return false;
    }

    @Override
    public boolean saveDetails(TourismDTO tourismDTO) {
        System.out.println("Service data: "+tourismDTO);
        if (save(tourismDTO)){
            TourismEntity tourismEntity = new TourismEntity();
            tourismEntity.setId(tourismDTO.getId());
            tourismEntity.setPlace(tourismDTO.getPlace());
            tourismEntity.setNoOfPeople(tourismDTO.getNoOfPeople());
            tourismEntity.setNoOfDays(tourismDTO.getNoOfDays());
            tourismEntity.setStartDate(tourismDTO.getStartDate());
            tourismEntity.setEndDate(tourismDTO.getEndDate());

            return tourismRepository.saveTourism(tourismEntity);
        }
        System.out.println("Invalid");
        return false;
    }

    @Override
    public List<TourismDTO> getAllEntity() {
        System.out.println("getAllEntity method in service");
        List<TourismEntity> listOfTourismEntity=tourismRepository.getAllEntity();
        List<TourismDTO> listOfTourismDto=listOfTourismEntity.stream()
                .map(entity -> {
                    TourismDTO dto = new TourismDTO();
                    dto.setId(entity.getId());
                    dto.setPlace(entity.getPlace());
                    dto.setNoOfPeople(entity.getNoOfPeople());
                    dto.setNoOfDays(entity.getNoOfDays());
                    dto.setStartDate(entity.getStartDate());
                    dto.setEndDate(entity.getEndDate());
                    return dto;
                })
                .collect(Collectors.toList());

        return listOfTourismDto;

    }
}
