package com.aht.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aht.entities.DanhMuc;

@Repository
@Transactional
public interface DanhMucRepository extends JpaRepository<DanhMuc, Long> {
	
}
