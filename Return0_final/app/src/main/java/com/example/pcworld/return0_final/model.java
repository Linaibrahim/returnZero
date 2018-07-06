package com.example.pcworld.return0_final;

/**
 * Created by elanaggar on 17/09/17.
 */

public class model {
    String title,description;

    public model(String model1, String desModel1, String uid) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public model(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
