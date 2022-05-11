package edu.patrones.demo.registraduriaservice.repository;

import edu.patrones.demo.registraduriaservice.model.RNEC;
import edu.patrones.demo.registraduriaservice.model.RNECId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RNECRepository extends JpaRepository<RNEC, RNECId> {
}
