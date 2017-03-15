package ua.pvl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommandGetter {

    private String inPath = null;
    private String outPath = null;
    private String currencyType = "USD";

    List<UserParameters> userCommandList = new ArrayList<>();

    public CommandGetter(List<UserParameters> userCommandList) {
        this.userCommandList = userCommandList;
        populateCommand();
    }

    private void populateCommand() {

        Iterator<UserParameters> userIter = userCommandList.iterator();

        while (userIter.hasNext()) {
            UserParameters userParam = userIter.next();
            String userParamName = userParam.getName();
            String userParamValue = userParam.getValue();

            if(userParamName.equals(ParameterDefiner.INPUT_PATH)) {
                inPath = userParamValue;

            }else {
                if(userParamName.equals(ParameterDefiner.OUTPUT_PATH)) {
                    outPath = userParamValue;

                } else {
                    if (userParamName.equals(ParameterDefiner.CURRENCY_TYPE)) {
                        currencyType = userParamValue;
                    }
                }
            }
        }
    }

    public String getInPath() {
        return inPath;
    }

    public String getOutPath() {
        return outPath;
    }

    public String getCurrencyType() {
        return currencyType;
    }

}
