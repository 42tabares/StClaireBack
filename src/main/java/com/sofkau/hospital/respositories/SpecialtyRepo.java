package com.sofkau.hospital.respositories;

import com.sofkau.hospital.records.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepo extends JpaRepository<Specialty, Long> {
}
