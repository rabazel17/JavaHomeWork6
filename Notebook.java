public class Notebook {
    private String brand;
    private Integer ram;
    private Integer hdd;
    private String os;
    private String color;

    public Notebook(String brand, Integer ram, Integer hdd, String os, String color){
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

@Override
public String toString() {
    return ("brand: " + this.brand + "; ram: " + this.ram + "; hdd: " + this.hdd + "; os: " + this.os + "; color: " + this.color);
}

public String getBrandName() {
    return brand;
}

public String getColor() {
    return color;
}

public Integer getHdd() {
    return hdd;
}

public String getOs() {
    return os;
}

public Integer getRam() {
    return ram;
}

}