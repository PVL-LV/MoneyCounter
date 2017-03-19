package ua.pvl;

public class UserParameters {

    private String name;
    private String value;

    public UserParameters(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
