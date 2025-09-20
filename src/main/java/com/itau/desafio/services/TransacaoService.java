package com.itau.desafio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itau.desafio.models.Transacao;

@Service
public class TransacaoService {

  private final List<Transacao> transacoes = new ArrayList<>();

  public void addOne(Transacao tansacao) {
    transacoes.add(tansacao);
  }
}
