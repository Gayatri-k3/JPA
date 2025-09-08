package com.xworkz.railways.repository;

import com.xworkz.railways.entity.RailwayEntity;

import java.util.List;

public interface RailwayRepository {
    boolean save(RailwayEntity entity);
    List<RailwayEntity> getAll();
}
