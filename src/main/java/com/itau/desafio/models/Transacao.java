package com.itau.desafio.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Transacao {

  private final BigDecimal valor;

  private final OffsetDateTime dataHora;
}
