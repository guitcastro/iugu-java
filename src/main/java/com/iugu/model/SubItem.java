package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubItem {

    private String id;
    private String description;
    private Integer quantity;
    @JsonProperty("price_cents")
    private Integer priceCents;
    private boolean recurrent;
    @JsonProperty("_destroy")
    private boolean _destroy;

    public SubItem() {
    }

    public SubItem(String description, Integer quantity, Integer priceCents) {
        this.description = description;
        this.quantity = quantity;
        this.priceCents = priceCents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getPriceCents() {
        return priceCents;
    }

    public void setPriceCents(Integer priceCents) {
        this.priceCents = priceCents;
    }

    public boolean isRecurrent() {
        return recurrent;
    }

    public void setRecurrent(boolean recurrent) {
        this.recurrent = recurrent;
    }

    public boolean isDestroy() {
        return _destroy;
    }

    public void setDestroy(boolean _destroy) {
        this._destroy = _destroy;
    }

    @Override
    public String toString() {
        return "SubItem{"
                + "description='" + description + '\''
                + ", quantity=" + quantity
                + ", priceCents=" + priceCents
                + ", recurrent=" + recurrent
                + '}';
    }
}
