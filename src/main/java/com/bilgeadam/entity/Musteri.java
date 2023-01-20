package com.bilgeadam.entity;


import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ad;
    private String soyad;

    @OneToMany(mappedBy = "musteri",fetch = FetchType.EAGER)
    private List<Siparis> siparisler;

    public Musteri(String ad, String soyad, List<Siparis> siparisler) {
        this.ad = ad;
        this.soyad = soyad;
        this.siparisler = siparisler;
    }

    public Musteri(int id, String ad, String soyad) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;

    }
    public Musteri(int id, String ad, String soyad, List<Siparis> siparisler) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.siparisler = siparisler;
    }

    public Musteri(String ad, String soyad) {
        this.ad = ad;
        this.soyad = soyad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    @Override
    public String toString() {
        return "Musteri{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                '}';
    }
}