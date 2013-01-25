package br.com.semeru.datesynchronizer.beans;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

/* Anotação que indica para a XStream que location
é um nó de um arquivo XML ou seja ele é um objeto */
@XStreamAlias("location")
public class Location implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String latitude;
    private String longitude;

    public Location() {
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
        
}
