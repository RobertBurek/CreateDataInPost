package pl.maestrofinansow.inpostmap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paczkomat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String gdzie;
    String nrPaczkomatu;
    String ulica;
    String kod;
    String miasto;
    String wspX;
    String wspY;

    public Paczkomat() {
    }

    public Paczkomat(String gdzie, String nrPaczkomatu, String ulica, String kod, String miasto, String wspX, String wspY) {
        this.gdzie = gdzie;
        this.nrPaczkomatu = nrPaczkomatu;
        this.ulica = ulica;
        this.kod = kod;
        this.miasto = miasto;
        this.wspX = wspX;
        this.wspY = wspY;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGdzie() {
        return gdzie;
    }

    public void setGdzie(String gdzie) {
        this.gdzie = gdzie;
    }

    public String getNrPaczkomatu() {
        return nrPaczkomatu;
    }

    public void setNrPaczkomatu(String nrPaczkomatu) {
        this.nrPaczkomatu = nrPaczkomatu;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getWspX() {
        return wspX;
    }

    public void setWspX(String wspX) {
        this.wspX = wspX;
    }

    public String getWspY() {
        return wspY;
    }

    public void setWspY(String wspY) {
        this.wspY = wspY;
    }

    @Override
    public String toString() {
        return "Paczkomat{" +
                "id=" + id +
                ", gdzie='" + gdzie + '\'' +
                ", nrPaczkomatu='" + nrPaczkomatu + '\'' +
                ", ulica='" + ulica + '\'' +
                ", kod='" + kod + '\'' +
                ", miasto='" + miasto + '\'' +
                ", wspX='" + wspX + '\'' +
                ", wspY='" + wspY + '\'' +
                '}';
    }
}
