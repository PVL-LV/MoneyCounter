package ua.pvl;


public class ParameterDefiner {

    public static final String STRING_TYPE = "String";

    public static final String INPUT_PATH = "inputPath";
    public static final String OUTPUT_PATH = "outputPath";
    public static final String CURRENCY_TYPE = "currencyType";

    private String name;
    private String type;
    private boolean required;

    public ParameterDefiner(String name, String type, boolean required) {
        this.name = name;
        this.type = type;
        this.required = required;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isRequired() {
        return required;
    }
}


