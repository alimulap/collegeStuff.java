package src;

public class Transaksi {
    double saldo, saldoAwal, saldoAkhir;
    String tanggalTransaksi, type;

    public Transaksi(double sld, double sldaw, double sldak, String tglTr, String tp) {
        this.saldo = sld;
        this.saldoAwal = sldaw;
        this.saldoAkhir = sldak;
        this.tanggalTransaksi = tglTr;
        this.type = tp;
    }

    void tampil() {
        System.out.println(
            this.saldo + " " +
            this.saldoAwal + " " +
            this.saldoAkhir + " " +
            this.tanggalTransaksi + " " +
            this.type
        );
    }
}
