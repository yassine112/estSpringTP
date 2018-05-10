package com.estPFE.MaBonque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import com.estPFE.MaBonque.Beans.OperationBean;

public interface OperationReapository extends JpaRepository<OperationBean, Long> {
	@Query("select o from OperationBean o where o.compte.codeCompte = :x order by o.dateOperation desc")
	public Page<OperationBean> listOperations(@Param("x") String codeCmpt, Pageable  pageable);

}
