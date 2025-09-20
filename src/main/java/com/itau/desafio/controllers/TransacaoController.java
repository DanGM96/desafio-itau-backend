package com.itau.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.desafio.models.Transacao;
import com.itau.desafio.models.TransacaoDTO;
import com.itau.desafio.services.TransacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

  @Autowired
  private TransacaoService transacaoService;

  @PostMapping
  public ResponseEntity<Void> postTransacao(@RequestBody @Valid TransacaoDTO transacao) {
    transacaoService.addOne(
        Transacao.builder()
            .valor(transacao.getValor())
            .dataHora(transacao.getDataHora())
            .build());

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
