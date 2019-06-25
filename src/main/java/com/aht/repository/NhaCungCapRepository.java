package com.aht.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aht.entities.NhaCungCap;

@Repository
@Transactional
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Long> {
	@Query("from NhaCungCap")
	List<NhaCungCap> supList();
}
