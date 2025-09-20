package com.itau.desafio.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transacao {

  private final BigDecimal valor;

  private final OffsetDateTime dataHora;
}
