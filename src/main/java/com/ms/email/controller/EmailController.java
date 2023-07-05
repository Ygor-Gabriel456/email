package com.ms.email.controller;

import com.ms.email.dtos.EmailDtos;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;

@RestController
public class EmailController {
    @Autowired
    EmailServices services;

    @GetMapping("/")
    public List<EmailModel> findAll(){
        return services.findAll();
    }

    @GetMapping("/byId/{id}")
    public EmailModel findAllById(@PathVariable("id")Long id){
        return services.findAllById(id);
    }


    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDtos emailDtos){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDtos, emailModel); //LER DE DEPOIS
        services.sendingEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
}
