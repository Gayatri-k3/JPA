package com.xworkz.tourism.service;

import com.xworkz.tourism.dto.TourismDTO;
import com.xworkz.tourism.repository.TourismRepository;

import java.util.List;

public interface TourismService {
    boolean save(TourismDTO tourismDTO);
    boolean saveDetails(TourismDTO tourismDTO);
    List<TourismDTO> getAllEntity();
}
