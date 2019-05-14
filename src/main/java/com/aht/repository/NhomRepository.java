package com.aht.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aht.entities.Nhom;

@Repository
@Transactional
public interface NhomRepository extends JpaRepository<Nhom, Long> {

}
