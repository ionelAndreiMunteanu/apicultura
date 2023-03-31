package com.apicol.apicultura.repository;

import com.apicol.apicultura.model.Boss;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BossRepository extends CrudRepository<Boss,Long> {
}
