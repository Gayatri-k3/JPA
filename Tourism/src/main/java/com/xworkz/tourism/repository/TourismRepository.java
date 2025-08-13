package com.xworkz.tourism.repository;

import com.xworkz.tourism.entity.TourismEntity;

import java.util.List;

public interface TourismRepository {
    boolean saveTourism(TourismEntity tourismEntity);
    List<TourismEntity> getAllEntity();
}
