package com.api.study.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable pageable);

    @Query("""
            select m from Medico mwhere m.ativo=true
            and m.especialidade = :especialidade
            and m.id not in (
                select c.medico.id from Consulta c
                where c.data=:data
                )
            order by rand() limit 1
            """)
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);

    @Query("""
            select m.ativo from Medico m where m.id= :id
            """)
    Boolean findAtivoById(Long idMedico);
}
