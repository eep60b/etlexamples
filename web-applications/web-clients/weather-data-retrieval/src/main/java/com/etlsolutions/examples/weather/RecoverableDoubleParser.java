package com.etlsolutions.examples.weather;

/**
 * The RecoverableDoubleParser class provides a parser to parse a string to a
 * double number. If the operation fails, Error will be logged as warning
 * information instead of an exception being thrown out.
 *
 * @author zc
 */
public final class RecoverableDoubleParser extends RecoverableNumberParser<Double> {

    private static final RecoverableDoubleParser INSTANCE = new RecoverableDoubleParser();

    public static final RecoverableDoubleParser getInstance() {
        return INSTANCE;
    }

    @Override
    protected Double parseNumber(String value) {
        return Double.parseDouble(value);
    }
}
