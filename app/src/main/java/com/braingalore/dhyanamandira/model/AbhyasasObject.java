package com.braingalore.dhyanamandira.model;

/**
 * Created by s92 on 5/8/2017.
 */

public class AbhyasasObject {
    private String name, abhyasaItems, drawableName;

    public AbhyasasObject() {
    }

    public AbhyasasObject(String name, String abhyasaItems, String drawableName) {
        this.name = name;
        this.abhyasaItems = abhyasaItems;
        this.drawableName = drawableName;
    }

    public String getAbhyasaItems() {
        return abhyasaItems;
    }

    public void setAbhyasaItems(String items) {
        this.abhyasaItems = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDrawableName() {
        return drawableName;
    }

    public void setDrawableName(String drawableName) {
        this.drawableName = drawableName;
    }
}
