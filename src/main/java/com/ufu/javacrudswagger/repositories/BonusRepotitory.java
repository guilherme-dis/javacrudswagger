package com.ufu.javacrudswagger.repositories;

import com.ufu.javacrudswagger.entities.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BonusRepotitory extends JpaRepository<Bonus,Long> {

    //@Query("select c from tb_bonus c where c.cpf like ?1")

    @Query("select b from Bonus b where b.cpf = ?1")
    Bonus findBonusByCpf(String cpf);
}
