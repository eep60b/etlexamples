package com.etlsolutions.examples.weather;

/**
 *
 * @author zc
 */
public final class RecoverableDoubleParser extends RecoverableNumberParser<Double>{

    private static final RecoverableDoubleParser INSTANCE = new RecoverableDoubleParser();
    
    public static final RecoverableDoubleParser getInstance() {
        return INSTANCE;
    }
    
    @Override
    protected Double parseNumber(String value) {
        return Double.parseDouble(value);
    }
}
