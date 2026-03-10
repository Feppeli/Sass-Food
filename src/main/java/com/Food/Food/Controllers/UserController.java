package com.Food.Food.Controllers;

import com.Food.Food.Model.UserModel;
import com.Food.Food.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<?> receiveUser(@RequestBody UserModel user){
        if(userRepository.existsByCpf(user.getCpf())){ // Veiricação do CPF cadastrado
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: CPF já cadastrado!");
        }

        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: Email já cadatrado");
        }

        try {
            UserModel savedUser = userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário salvo com Sucesso!" + user);
        }catch (DataIntegrityViolationException e){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Houve um conflito nos dados fornecidos com nossa base de dados!");
        }
    }

}
