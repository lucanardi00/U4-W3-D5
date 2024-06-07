package luca_nardi.model;

import javax.persistence.Entity;

@Entity
public class Libro extends ElementoCatalogo {
    private String autore;
    private String genere;
    
    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
