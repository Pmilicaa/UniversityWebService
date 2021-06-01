package com.uni.UniversityWebService.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "storage")
@Component
public class StorageProperties {



    private String location;

    public StorageProperties(){

    }

    public StorageProperties(String location){

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
