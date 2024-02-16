package hu.undieb.fishfinder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

enum WaterType{
     FRESHWATER,
     SALTWATER
 }
public class Fish {
    public Fish(int id,String name,String scientificName,ArrayList<String> urls,WaterType waterType,String description,float size, float requiredTankSize) {
        this.id = id;
        this.name = name;
        this.scientificName = scientificName;
        this.urls = urls;
        this.waterType = waterType;
        this.description = description;
        this.size=size;
        this.requiredTankSize=requiredTankSize;
    }
    public float size;

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getRequiredTankSize() {
        return requiredTankSize;
    }

    public void setRequiredTankSize(float requiredTankSize) {
        this.requiredTankSize = requiredTankSize;
    }

    public float requiredTankSize;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public ArrayList<String> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<String> urls) {
        this.urls = urls;
    }

    public WaterType getWaterType() {
        return waterType;
    }

    public void setWaterType(WaterType waterType) {
        this.waterType = waterType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String scientificName;
    private ArrayList<String> urls;
    private WaterType waterType;
    private String description;

}
