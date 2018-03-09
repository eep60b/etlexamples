package com.etlsolutions.examples.weather;

/**
 * The RecoverableLongParser class provides a parser to parse a string to a long
 * number. If the operation fails, Error will be logged as warning information
 * instead of an exception being thrown out.
 *
 * @author zc
 */
public final class RecoverableLongParser extends RecoverableNumberParser<Long> {

    private static final RecoverableLongParser INSTANCE = new RecoverableLongParser();

    private RecoverableLongParser() {
    }

    /**
     * 
     * @return 
     */
    public static final RecoverableLongParser getInstance() {
        return INSTANCE;
    }

    @Override
    protected Long parseNumber(String value) {
        return Long.parseLong(value);
    }
}
