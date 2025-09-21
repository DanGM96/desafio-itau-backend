package com.itau.desafio.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itau.desafio.services.TransacaoService;
import com.itau.desafio.utils.BigDecimalSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

  @Autowired
  private TransacaoService transacaoService;

  @GetMapping
  public ResponseEntity<BigDecimalSummaryStatistics> getEstatistica(
      @RequestParam(name = "segundos") Optional<Long> seconds) {
    BigDecimalSummaryStatistics stats = transacaoService.getStats(seconds);

    return ResponseEntity.ok().body(stats);
  }

}
