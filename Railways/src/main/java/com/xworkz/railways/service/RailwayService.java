package com.xworkz.railways.service;

import com.xworkz.railways.dto.RailwayDTO;

public interface RailwayService {
    boolean validateAndSave(RailwayDTO dto);
}
