package model;

import java.util.Date;

/**
 * Created by Alex on 1/9/2016.
 */
public class Temperature {
    Date createdAt;
    Float temp;

    public Temperature(Date createdAt, Float temp) {
        this.createdAt = createdAt;
        this.temp = temp;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }
}
