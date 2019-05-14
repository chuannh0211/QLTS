package com.aht.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aht.entities.BienDongTaiSan;

@Repository
@Transactional
public interface BienDongTaiSanRepository extends JpaRepository<BienDongTaiSan, Long> {

}
