package com.Food.Food.Controllers;

import com.Food.Food.Model.MenuModel;
import com.Food.Food.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @PostMapping("/create")
    public ResponseEntity<?> receiveMenu(@RequestBody MenuModel menu){

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body("Menu Criado com sucesso" + menu);
        }catch(DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Houve um conflito nos dados fornecidos com nossa base de dados");
        }
    }

}
