package com.example.traveler.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class PariwisataModel {
    private List<Wisata> wisata;

    public List<Wisata> getWisata() {
        return wisata;
    }

    public void setWisata(List<Wisata> wisata) {
        this.wisata = wisata;
    }

    public static class Wisata{
        private int id;
        private String nama;
        private String gambar_url;
        private String kategori;

        public Wisata(JSONObject jsonObject) {
            try {
                String nama=jsonObject.getString("nama");
                String gambar_url=jsonObject.getString("gambar_url");
                String kategori=jsonObject.getString("kategori");
                this.nama=nama;
                this.gambar_url=gambar_url;
                this.kategori=kategori;
            }
            catch (JSONException e){
                e.printStackTrace();
            }
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getGambar_url() {
            return gambar_url;
        }

        public void setGambar_url(String gambar_url) {
            this.gambar_url = gambar_url;
        }

        public String getKategori() {
            return kategori;
        }

        public void setKategori(String kategori) {
            this.kategori = kategori;
        }

        //untuk logcat
        @Override
        public String toString() {
            return "Wisata{" +
                    "id=" + id +
                    ", nama='" + nama + '\'' +
                    ", gambar_url='" + gambar_url + '\'' +
                    ", kategori='" + kategori + '\'' +
                    '}';
        }
    }
}

