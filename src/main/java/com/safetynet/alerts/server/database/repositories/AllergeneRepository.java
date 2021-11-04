package com.safetynet.alerts.server.database.repositories;

import com.safetynet.alerts.server.database.entities.AllergeneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergeneRepository extends JpaRepository<AllergeneEntity, Long> {
}
