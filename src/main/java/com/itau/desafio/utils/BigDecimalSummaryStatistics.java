package com.itau.desafio.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Consumer;

import lombok.Getter;

/**
 * Based on DoubleSummaryStatistics, but using BigDecimal instead of double.
 * 
 * @see java.util.DoubleSummaryStatistics
 * @see java.math.BigDecimal
 */

@Getter
public class BigDecimalSummaryStatistics implements Consumer<BigDecimal> {
  private long count = 0L;
  private BigDecimal sum = BigDecimal.ZERO;
  private BigDecimal min = null;
  private BigDecimal max = null;

  public BigDecimalSummaryStatistics() {
  }

  public BigDecimalSummaryStatistics(long count, BigDecimal sum, BigDecimal min, BigDecimal max)
      throws IllegalArgumentException {
    if (count < 0L) {
      throw new IllegalArgumentException("Negative count value");
    } else if (count > 0L) {
      if (min.compareTo(max) > 0)
        throw new IllegalArgumentException("Minimum greater than maximum");

      this.count = count;
      this.sum = sum;
      this.min = min;
      this.max = max;
    }
    // Use default field values if count == 0
  }

  @Override
  public void accept(BigDecimal value) {
    ++count;
    sum = sum.add(value);
    min = (min == null) ? value : min.min(value);
    max = (max == null) ? value : max.max(value);
  }

  public void combine(BigDecimalSummaryStatistics other) {
    count += other.count;
    sum = sum.add(other.sum);
    if (other.min != null) {
      min = (min == null) ? other.min : min.min(other.min);
    }
    if (other.max != null) {
      max = (max == null) ? other.max : max.max(other.max);
    }
  }

  public final BigDecimal getAvg() {
    return getCount() > 0L ? getSum().divide(new BigDecimal(getCount()), RoundingMode.HALF_UP) : BigDecimal.ZERO;
  }

  public BigDecimal getMin() {
    return min != null ? min : BigDecimal.ZERO;
  }

  public BigDecimal getMax() {
    return max != null ? max : BigDecimal.ZERO;
  }

  @Override
  public String toString() {
    return String.format(
        "%s{count=%d, sum=%f, avg=%f, min=%f, max=%f}",
        this.getClass().getSimpleName(),
        getCount(),
        getSum(),
        getAvg(),
        getMin(),
        getMax());
  }
}
