package com.ufu.javacrudswagger.services;

import com.ufu.javacrudswagger.entities.Bonus;
import com.ufu.javacrudswagger.repositories.BonusRepotitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BonusService {
    @Autowired
    private BonusRepotitory bonusRepotitory;

    public Bonus insert(Bonus bonus){
        Bonus bonusByCpf=bonusRepotitory.findBonusByCpf(bonus.getCpf());
        if(bonusByCpf==null){
            return bonusRepotitory.save(bonus);
        }else{

            bonusByCpf.setScore(bonus.getScore() + bonusByCpf.getScore());
            bonusByCpf.setCash_back(bonusByCpf.getCash_back() + 0.50);
            return bonusRepotitory.save(bonusByCpf);

        }
    }

    public Page<Bonus> findAll(Pageable page){
        return bonusRepotitory.findAll(page);
    }
}
