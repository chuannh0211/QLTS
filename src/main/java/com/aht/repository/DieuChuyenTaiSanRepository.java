package com.aht.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aht.entities.DieuChuyenTaiSan;

@Repository
@Transactional
public interface DieuChuyenTaiSanRepository extends JpaRepository<DieuChuyenTaiSan, Long> {
//	DieuChuyenTaiSan findByTenTaiSan(String dcts); 
}
