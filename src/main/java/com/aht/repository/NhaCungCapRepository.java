package com.aht.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aht.entities.NhaCungCap;

@Repository
@Transactional
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Long> {

}
