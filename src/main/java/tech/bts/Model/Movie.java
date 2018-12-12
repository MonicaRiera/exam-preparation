package tech.bts.Model;

public class Movie {

    private String title;
    private Double length;
    private boolean adult;

    public Movie() {}

    public Movie(String title, Double length, boolean adult) {
        this.title = title;
        this.length = length;
        this.adult = adult;
    }

    public String getTitle() {
        return title;
    }

    public Double getLength() {
        return length;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }
}
