package com.ufu.javacrudswagger.services;

import com.ufu.javacrudswagger.entities.Address;
import com.ufu.javacrudswagger.entities.Bonus;
import com.ufu.javacrudswagger.repositories.BonusRepotitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public ResponseEntity<Bonus> findById(Long id){
        Optional<Bonus> bonusOptional = bonusRepotitory.findById(id);
        return bonusOptional.map(bonus -> new ResponseEntity<>(bonus, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Bonus> deleteById(Long id){
        try {
            bonusRepotitory.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            Optional<Bonus> bonus=bonusRepotitory.findById(id);
            if (bonus.isPresent()){
                return new ResponseEntity<>(HttpStatus.valueOf(420));
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }
}
