package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class SiparisKalemi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "urun_id")
    private Urun urun;
    private int adet;

    public SiparisKalemi(Urun urun, int adet) {
        this.urun = urun;
        this.adet = adet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    @Override
    public String toString() {
        return "SiparisKalemi{" +
                "id=" + id +
                ", urun=" + urun +
                ", adet=" + adet +
                '}';
    }
}

