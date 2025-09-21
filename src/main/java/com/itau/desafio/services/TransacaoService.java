package com.itau.desafio.services;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.itau.desafio.models.Transacao;
import com.itau.desafio.utils.BigDecimalSummaryStatistics;

@Service
public class TransacaoService {

  private static final Long DEFAULT_SECONDS = 60L;

  private final List<Transacao> transacoes = new ArrayList<>();

  public void addOne(Transacao tansacao) {
    transacoes.add(tansacao);
  }

  public void deleteAll() {
    transacoes.clear();
  }

  public BigDecimalSummaryStatistics getStats(Optional<Long> seconds) {
    OffsetDateTime cutoff = OffsetDateTime.now().minusSeconds(seconds.orElse(DEFAULT_SECONDS));

    return transacoes.parallelStream()
        .filter(t -> t.getDataHora().isAfter(cutoff))
        .map(Transacao::getValor)
        .collect(
            BigDecimalSummaryStatistics::new,
            BigDecimalSummaryStatistics::accept,
            BigDecimalSummaryStatistics::combine);
  }
}
