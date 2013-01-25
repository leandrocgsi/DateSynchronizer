package br.com.semeru.datesynchronizer.beans;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

/* Anotação que indica para a XStream que timezone
é um nó de um arquivo XML ou seja ele é um objeto */
@XStreamAlias("timezone")
public class Timezone implements Serializable{

    //Atributo para serialização do bean
    private static final long serialVersionUID = 1L;
    
    //Atributo do XML
    private String version;

    /*Essa anotação indica que o atributo XML abaixo 
    é um atributo um pouco mais complexo e representa
    um objeto dentro de timezone*/
    @XStreamAlias("location")
    private Location location;
    
    //Outro atributo do XML
    private String offset;
    private String suffix;
    private String localtime;
    private String isotime;
    private String utctime;
    private String dst;

    public Timezone() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public String getIsotime() {
        return isotime;
    }

    public void setIsotime(String isotime) {
        this.isotime = isotime;
    }

    public String getUtctime() {
        return utctime;
    }

    public void setUtctime(String utctime) {
        this.utctime = utctime;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }
        
}
