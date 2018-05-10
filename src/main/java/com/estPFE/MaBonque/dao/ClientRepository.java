package com.estPFE.MaBonque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estPFE.MaBonque.Beans.ClientBean;

public interface ClientRepository extends JpaRepository<ClientBean, Long> {

}
