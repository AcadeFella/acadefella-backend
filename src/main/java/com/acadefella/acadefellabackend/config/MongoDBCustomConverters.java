package com.acadefella.acadefellabackend.config;

import java.math.BigDecimal;
import java.util.Arrays;
import lombok.NonNull;
import org.bson.types.Decimal128;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

public class MongoDBCustomConverters {

  public static MongoCustomConversions createCustomConverters() {
    return new MongoCustomConversions(
        Arrays.asList(new BigDecimalDecimal128Converter(), new Decimal128BigDecimalConverter()));
  }

  @WritingConverter
  private static class BigDecimalDecimal128Converter implements Converter<BigDecimal, Decimal128> {

    @Override
    public Decimal128 convert(@NonNull BigDecimal source) {
      return new Decimal128(source);
    }
  }

  @ReadingConverter
  private static class Decimal128BigDecimalConverter implements Converter<Decimal128, BigDecimal> {

    @Override
    public BigDecimal convert(@NonNull Decimal128 source) {
      return source.bigDecimalValue();
    }
  }
}
