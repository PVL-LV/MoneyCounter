package ua.pvl;

import java.util.ArrayList;
import java.util.List;

public class ParamValidator {

    List <ParameterDefiner> commandList = new ArrayList<>();
    List <UserParameters> userCommandList = new ArrayList<>();


    public ParamValidator(List<ParameterDefiner> commandList,List <UserParameters> userCommandList) {
        this.commandList = commandList;
        this.userCommandList = userCommandList;
    }

    public void validate() throws ValidationException {

        for (ParameterDefiner p : commandList) {
            String defComName = p.getName();
            String defComType = p.getType();
            boolean defComRequired = p.isRequired();

            for (UserParameters up : userCommandList) {

                String userComName = up.getName();
                String userComValue = up.getValue();


                if (defComName.equals(userComName) && userComValue != null && userComValue.length() > 0) {
                    if (defComType.equals(ParameterDefiner.CURRENCY_TYPE) && userComValue.length() != 3) {
                        throw new ValidationException("Value for parameter < " + userComValue + "> should be a currency type");
                    }
                    defComRequired = false;
                }
            }
            if (defComRequired) {
                throw new ValidationException("Required param " + p.getName() + " is not found");
            }

        }
    }
}