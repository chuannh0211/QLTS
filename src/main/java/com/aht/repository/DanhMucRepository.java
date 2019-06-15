package com.aht.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aht.entities.DanhMuc;

@Repository
@Transactional
public interface DanhMucRepository extends PagingAndSortingRepository<DanhMuc, Long> {
	@Query("from DanhMuc")
	List<DanhMuc> dmList();
}
