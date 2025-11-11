package model;

import java.time.LocalDate;

public class Aktivitas{
    private String nama;
    private LocalDate tanggal;
    private int durasi;
    private String kategori;

    public Aktivitas(String nama, LocalDate tanggal, int durasi, String kategori) {
        this.nama = nama;
        this.tanggal = tanggal;
        this.durasi = durasi;
        this.kategori = kategori;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public LocalDate getTanggal() { return tanggal; }
    public void setTanggal(LocalDate tanggal) { this.tanggal = tanggal; }

    public int getDurasi() { return durasi; }
    public void setDurasi(int durasi) { this.durasi = durasi; }

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }
}

