package be.vdab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import be.vdab.entities.Bier;

public interface BierDAO extends JpaRepository<Bier, Long> {
	List<Bier> findByBrouwerBrouwerNr(@Param("id")long brouwerNr);
}
