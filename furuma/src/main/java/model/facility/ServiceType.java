package model.facility;

public class ServiceType {
    private int id;
    private String name;

    public ServiceType(String name) {
        this.name = name;
    }

    public ServiceType(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
