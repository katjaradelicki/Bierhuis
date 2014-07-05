package be.vdab.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Brouwer;

public interface BrouwerDAO extends JpaRepository<Brouwer, Long> {

}
