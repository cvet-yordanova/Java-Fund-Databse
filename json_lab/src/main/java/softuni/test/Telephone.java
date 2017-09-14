package softuni.test;


public class Telephone {
    private String number;
    private String p;

    public Telephone() {
    }

    public Telephone(String number, String p) {
        this.number = number;
        this.p = p;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }
}
