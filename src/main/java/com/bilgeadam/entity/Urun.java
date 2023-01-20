package com.bilgeadam.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
    public class Urun {
        private Object GenerationType;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String kategori;
        private double fiyat;

        public Urun(String kategori, double fiyat) {
            this.kategori = kategori;
            this.fiyat = fiyat;
        }

        public Object getGenerationType() {
            return GenerationType;
        }

        public void setGenerationType(Object generationType) {
            GenerationType = generationType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getKategori() {
            return kategori;
        }

        public void setKategori(String kategori) {
            this.kategori = kategori;
        }

        public double getFiyat() {
            return fiyat;
        }

        public void setFiyat(double fiyat) {
            this.fiyat = fiyat;
        }

        @Override
        public String toString() {
            return "Urun{" +
                    "GenerationType=" + GenerationType +
                    ", id=" + id +
                    ", kategori='" + kategori + '\'' +
                    ", fiyat=" + fiyat +
                    '}';
        }


    }
