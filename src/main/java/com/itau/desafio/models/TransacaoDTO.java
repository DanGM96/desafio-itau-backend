package com.itau.desafio.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class TransacaoDTO {

  @NotNull
  @PositiveOrZero
  private final BigDecimal valor;

  @NotNull
  @Past
  private final OffsetDateTime dataHora;
}
