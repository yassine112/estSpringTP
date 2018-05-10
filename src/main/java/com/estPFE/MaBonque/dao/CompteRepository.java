package com.estPFE.MaBonque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estPFE.MaBonque.Beans.CompteBean;

public interface CompteRepository extends JpaRepository<CompteBean, String> {

}
