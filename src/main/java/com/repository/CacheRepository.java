package com.repository;

import com.entity.CacheResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CacheRepository extends JpaRepository<CacheResult,Integer> {
    List<CacheResult> findAll();
    List<CacheResult> getAllByResponceId(int id);
}
