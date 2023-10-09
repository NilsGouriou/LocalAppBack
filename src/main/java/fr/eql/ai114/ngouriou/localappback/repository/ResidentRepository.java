package fr.eql.ai114.ngouriou.localappback.repository;

import fr.eql.ai114.ngouriou.localappback.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ResidentRepository extends JpaRepository<Resident, Long> {


}
