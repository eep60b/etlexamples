package com.etlsolutions.examples.weather;

/**
 * The RecoverableIntParser class.
 *
 * @author zc
 */
public final class RecoverableIntParser extends RecoverableNumberParser<Integer> {

    private static final RecoverableIntParser INSTANCE = new RecoverableIntParser();

    public static final RecoverableIntParser getInstance() {
        return INSTANCE;
    }

    @Override
    protected Integer parseNumber(String value) {
        return Integer.parseInt(value);
    }
}
