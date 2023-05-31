package src;

public class Rekening {
    String noRekening, nama, namaIbu, phone, email;

    public Rekening(String nrek, String nm, String nmI, String ph, String em) {
        this.noRekening = nrek;
        this.nama = nm;
        this.namaIbu = nmI;
        this.phone = ph;
        this.email = em;
    }

    void tampil() {
        System.out.println(
            this.noRekening + " " +
            this.nama + " " +
            this.namaIbu + " " +
            this.phone + " " +
            this.email
        );
    }
}
