package com.etlsolutions.examples.weather.data;

import java.util.Objects;

/**
 *
 * @author zc
 * @param <T>
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
        
        if (!(obj instanceof AbstractValuable)) {
            return false;
        }

        final AbstractValuable<?> other = (AbstractValuable<?>) obj;

        return Objects.equals(this.value, other.value);
    }
}
