package org.examples.supermarket.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

public final class Item {

    private final String name;
    private final double basePrice;

    private Item(Builder builder) {
        name = Objects.requireNonNull(builder.name);
        basePrice = builder.basePrice;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object that) {
        return (that instanceof Item) && EqualsBuilder.reflectionEquals(this, that) ;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public static class Builder {

        private String name;
        private double basePrice;

        public Builder withName(String name) {
            this.name = name;

            return this;
        }

        public Builder withBasePrice(double basePrice) {
            this.basePrice = basePrice;

            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

}
