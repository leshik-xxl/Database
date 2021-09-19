package com.example.demo.repository;

import com.example.demo.model.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("update Client c set c.eMail = :eMail where c.id = :clientId")
    void setClientEMail(@Param("clientId") Long id, @Param("eMail") String eMail);
}
