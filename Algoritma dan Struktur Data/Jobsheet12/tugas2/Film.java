package tugas2;

class Film {
    int id;
    String judul;
    float rating;

    Film(int id, String judul, float rating) {
        this.id = id;
        this.judul = judul;
        this.rating = rating;
    }

    public void print() {
        System.out.println("ID Film: " + this.id + 
                        "\n Judul Film: " + this.judul +
                        "\n IMDB Rating: " + this.rating);
    }
}


