package com.aht.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aht.entities.TaiSan;

@Repository
@Transactional
public interface TaiSanRepository extends JpaRepository<TaiSan, Long> {
	TaiSan findByTentaisan(String tentaisan);

	@Query("from TaiSan")
	List<TaiSan> findAll();

}
