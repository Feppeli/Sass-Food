package com.Food.Food.Controllers;


import com.Food.Food.Model.BusinessModel;
import com.Food.Food.Repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessRepository businessRepository;

    @PostMapping("/create")
    public ResponseEntity<?> receiveBusiness(@RequestBody BusinessModel business){
        if(businessRepository.existsByCnpj(business.getCnpj())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: CNPJ já cadastrado");
        }

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body("Business criado com sucesso" + business);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Houve um conflito nos dados fornecidos com nossa base de dados!");
        }
    }
}
