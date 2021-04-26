package com.company;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice;
        String Username, usernameInput;
        String Password, passwordInput;
        ArrayList<Tilanglist> Tilanglist = new ArrayList<Tilanglist>();
        Scanner optionObj = new Scanner(System.in);

        Password = "123";
        Username = "moeldoko";

        do {
            System.out.println("***LOGIN***");
            Scanner input1 = new Scanner(System.in);
            System.out.println("Masukkan Username : ");
            usernameInput = input1.nextLine();

            System.out.println("Masukkan Password : ");
            passwordInput = input1.nextLine();
        } while (!usernameInput.equals(Username) && !passwordInput.equals(Password));
        System.out.println("\nSelamat bertugas\n");



        do {
            System.out.println("===============================");
            System.out.println("E-TILANG : KOTA WARNA WARNI     ");
            System.out.println("===============================");
            System.out.println("1. Input Data Pelanggar");
            System.out.println("2. Tampilkan Data Pelanggar");
            System.out.println("3. Cetak Surat Tilang ");
            System.out.println("4. Logout");
            System.out.println("===============================");
            System.out.println("Pilihan : ");
            choice = optionObj.nextInt();
            switch (choice) {
                case 1:
                    addpelanggaran(Tilanglist);
                    break;
                case 2:
                    LihatData(Tilanglist);
                    break;
                case 3:
                    suratTilang(Tilanglist, Username);
                    break;

            }
        } while (choice != 4);
    }


    private static void addpelanggaran(ArrayList<Tilanglist> tilanglist) {
        String nama, alamat, jeniskendaraan, tipekendaraan, email, pilih, nik, nomortelpon;
        int jenispelanggaran;
        List<jenispelanggaran> jp = new ArrayList<>();
        Scanner add = new Scanner(System.in);

        System.out.print("\nMasukan Nama Lengkap: ");
        nama = add.nextLine();
        System.out.print("Masukan Alamat Lengkap: ");
        alamat = add.nextLine();
        System.out.print("Masukan NIK [0-9]: ");
        nik = add.nextLine();
        System.out.print("Masukan E-mail : ");
        email = add.nextLine();
        System.out.print("Masukan No.Telpon [0-9]: ");
        nomortelpon = add.nextLine();

//ketika masukin jenis kendaraan nanti harga pelanggaran bakalan sesuai
        System.out.println("============= ");
        System.out.println("Jenis Kendaraan ");
        System.out.println("1. Roda Dua");
        System.out.println("2. Roda Empat/Lebih");
        System.out.println("Masukkan  Jenis Kendaraan :");
        jeniskendaraan = add.nextLine();

        System.out.println("\nTipe Kendaraan ");
        System.out.println("1. Motor");
        System.out.println("2. Mobil");
        System.out.println("3. Bis");
        System.out.println("4. Truk/Tronton");
        System.out.println("Masukkan  Tipe Kendaraan :");
        tipekendaraan = add.nextLine();

        do {
            System.out.println("\nJenis Pelanggaran ");
            System.out.println("1. Menggunakan Gawai / Handphone saat berkendara");
            System.out.println("2. Tidak memakai helm");
            System.out.println("3. Tidak memakai sabuk pengaman");
            System.out.println("4. Melanggar rambu lalu lintas dan marka jalan");
            System.out.println("5. Memakai plat nomor palsu");
            System.out.println("Masukkan  Jenis Pelanggaran :");
            jenispelanggaran = add.nextInt();
            add.nextLine();
            if (jenispelanggaran > 5) {
                pilih = "N";
            } else {
                jp.add(new jenispelanggaran(jenispelanggaran));
                System.out.println("Apakah ada pelanggaran Lain? (Y/N)");
                pilih = add.nextLine();
            }
        } while (pilih.equals("Y"));


        tilanglist.add(new Tilanglist(nama, alamat, jeniskendaraan, jenispelanggaran, tipekendaraan, email, nik, nomortelpon, jp ));
    }

    private static void LihatData(ArrayList<Tilanglist> tilanglist) {
        int tilang, totalTilang = 0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String[] jenispel = {
                "Menggunakan Gawai / Handphone saat berkendara",
                "Tidak memakai helm",
                "Tidak memakai sabuk pengaman",
                "Melanggar rambu lalu lintas dan marka jalan",
                "Memakai plat nomor palsu",
        };
        int[] hargapel = {
                750000,
                250000,
                250000,
                500000,
                500000,
        };

        if (tilanglist != null) {
            for (int i = 0; i < tilanglist.size(); i++) {
                System.out.println(dtf.format(now));
                System.out.println("\nID : " + (i +1));
                System.out.println("Nama : " + tilanglist.get(i).getNama());
                System.out.println("Jenis pelanggaran : ");
                for (int a = 0; a < tilanglist.get(i).getJp().size(); a++) {
                    System.out.println("Pelanggaran  " + (a + 1) + " = " + jenispel[a]);
                    totalTilang = totalTilang + hargapel[a];
                }
                System.out.println("\nTotal denda pelanggaran  : " + totalTilang);
            }
        } else {
            System.out.println("Tidak ada data!");
        }
    }

    private static void suratTilang(ArrayList<Tilanglist> tilanglist, String Username) {
        int tilang, totalTilang = 0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Scanner surat = new Scanner(System.in);

        String[] jenispel = {
                "Menggunakan Gawai / Handphone saat berkendara",
                "Tidak memakai helm",
                "Tidak memakai sabuk pengaman",
                "Melanggar rambu lalu lintas dan marka jalan",
                "Memakai plat nomor palsu",
        };
        int[] hargapel = {
                750000,
                250000,
                250000,
                500000,
                500000,
        };


        if (tilanglist != null) {
            for (int i = 0; i < tilanglist.size(); i++) {
                System.out.println("\nID : " + (i +1));
                System.out.println("Nama : " + tilanglist.get(i).getNama());
                System.out.println("Jenis pelanggaran : ");
                for (int a = 0; a < tilanglist.get(i).getJp().size(); a++) {
                    System.out.println((a + 1) + " = " + tilanglist.get(i).getJp().get(a).noJenis );
                }
            }
        } else {
            System.out.println("Tidak ada data!");
        }

        System.out.println("\nPilih ID Pelanggar : ");
        tilang = surat.nextInt() - 1;
        System.out.println(dtf.format(now));
        System.out.println("Petugas\t" + Username);
        System.out.println("\nNama : " + tilanglist.get(tilang).getNama());
        System.out.println("Alamat : " + tilanglist.get(tilang).getAlamat());
        System.out.println("NIK : " + tilanglist.get(tilang).getNik());
        System.out.println("E-mail : " + tilanglist.get(tilang).getEmail());
        System.out.println("No.telpon : " + tilanglist.get(tilang).getNomortelpon());
        System.out.println("Jenis kendaraan : " + tilanglist.get(tilang).getJeniskendaraan());
        System.out.println("Tipe kendaraan : " + tilanglist.get(tilang).getTipekendaraan());
        System.out.println("___");
        System.out.println("Jenis pelanggaran : ");
        for (int a = 0; a < tilanglist.get(tilang).getJp().size(); a++) {
            System.out.println("Pelanggaran ke " + (a + 1) + " = " + jenispel[a]);
            System.out.println("Biaya denda " + (a + 1) + " = " + hargapel[a]);
            System.out.println("___");
            totalTilang = totalTilang + hargapel[a];
        }
        System.out.println("total denda : " + totalTilang);
        System.out.println("\n");
    }


}
