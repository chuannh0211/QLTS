package com.aht.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aht.entities.TaiSan;

@Repository
@Transactional
public interface TaiSanRepository extends JpaRepository<TaiSan, Long>{
	TaiSan findByTentaisan(String tentaisan);
	
}
