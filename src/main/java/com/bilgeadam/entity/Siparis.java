package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Siparis {
    public boolean getSiparisKalemler;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    private Musteri musteri;
    @OneToMany(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    private List<SiparisKalemi> siparisKalemleri;


    public Siparis(Musteri musteri, List<SiparisKalemi> siparisKalemleri) {
        this.musteri = musteri;
        this.siparisKalemleri = siparisKalemleri;

    }

    public Siparis(boolean getSiparisKalemler, int id, Musteri musteri, List<SiparisKalemi> siparisKalemleri) {
        this.getSiparisKalemler = getSiparisKalemler;
        this.id = id;
        this.musteri = musteri;
        this.siparisKalemleri = siparisKalemleri;
    }
}
