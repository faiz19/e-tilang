package com.company;

import java.util.List;

public class Tilanglist {
    String nama, alamat, jeniskendaraan, tipekendaraan, email, nomortelpon, nik;
    String username, password;
    int jenispelanggaran;
    List<jenispelanggaran> jp;

    public Tilanglist(String nama, String alamat, String jeniskendaraan, int jenispelanggaran, String tipekendaraan, String email, String nik, String nomortelpon, List<jenispelanggaran> jp) {
        this.nama = nama;
        this.alamat = alamat;
        this.jenispelanggaran = jenispelanggaran;
        this.tipekendaraan = tipekendaraan;
        this.email = email;
        this.nik = nik;
        this.nomortelpon = nomortelpon;
        this.jeniskendaraan = jeniskendaraan;
        this.jp = jp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<jenispelanggaran> getJp() {
        return jp;
    }

    public void setJp(List<jenispelanggaran> jp) {
        this.jp = jp;
    }

    public String getJeniskendaraan() {
        return jeniskendaraan;
    }

    public void setJeniskendaraan(String jeniskendaraan) {
        this.jeniskendaraan = jeniskendaraan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getJenispelanggaran() {
        return jenispelanggaran;
    }

    public void setJenispelanggaran(int jenispelanggaran) {
        this.jenispelanggaran = jenispelanggaran;
    }

    public String getTipekendaraan() {
        return tipekendaraan;
    }

    public void setTipekendaraan(String tipekendaraan) {
        this.tipekendaraan = tipekendaraan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNomortelpon() {
        return nomortelpon;
    }

    public void setNomortelpon(String nomortelpon) {
        this.nomortelpon = nomortelpon;
    }
}


