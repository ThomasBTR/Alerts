package com.safetynet.alerts.database.repositories;

import com.safetynet.alerts.database.entities.AllergeneEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AllergeneRepository extends JpaRepository<AllergeneEntity, Long> {
}
