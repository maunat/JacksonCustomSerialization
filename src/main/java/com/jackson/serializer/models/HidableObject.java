package com.jackson.serializer.models;

import com.jackson.serializer.interfaces.Hidable;

public class HidableObject implements Hidable {

    private boolean hidden;

    @Override
    public boolean isHidden() {
        return this.hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
