package com.etlsolutions.examples.weather.data;

import java.util.Objects;

/**
 * The AbstractValuable class has implemented some common methods for concrete Valuable classes.
 *
 * @author zc
 * @param <T> - The value type.
 */
public abstract class AbstractValuable<T> implements Valuable {

    protected final T value;

    public AbstractValuable(T value) {
        this.value = value;
    }

    @Override
    public final T getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final AbstractValuable<?> other = (AbstractValuable<?>) obj;
        return Objects.equals(this.value, other.value);
    }

}
