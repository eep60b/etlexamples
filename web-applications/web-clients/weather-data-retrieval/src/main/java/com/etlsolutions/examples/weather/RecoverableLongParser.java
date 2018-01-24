package com.etlsolutions.examples.weather;

/**
 * The RecoverableLongParser class
 * @author zc
 */
public final class RecoverableLongParser extends RecoverableNumberParser<Long>{

    private static final RecoverableLongParser INSTANCE = new RecoverableLongParser();
    
    public static final RecoverableLongParser getInstance() {
        return INSTANCE;
    }
    
    @Override
    protected Long parseNumber(String value) {
        return Long.parseLong(value);
    }
}
