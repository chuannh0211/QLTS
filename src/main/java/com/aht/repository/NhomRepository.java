package com.aht.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aht.entities.Nhom;

@Repository
@Transactional
public interface NhomRepository extends JpaRepository<Nhom, Long> {
	@Query("from Nhom")
	List<Nhom> grList();
}
