package com.xworkz.railways.service;

import com.xworkz.railways.dto.RailwayDTO;

import java.util.List;

public interface RailwayService {
    boolean validateAndSave(RailwayDTO dto);
    List<RailwayDTO> getAll();
}
