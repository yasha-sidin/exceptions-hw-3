package Logic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserParser implements StringParser<User> {
    public User parseString(String dataString) throws StringParserException,UserParamsException {
        String[] params = dataString.split(" ");
        if (params.length != 6) {
            throw new StringParserException("Must be only six params in string. Not more, not less.");
        }
        String secondName = params[0];
        String firstName = params[1];
        String lastName = params[2];
        String dateString = params[3];
        String numberString = params[4];
        String genderString = params[5];

        if (genderString.length() != 1) {
            throw new StringParserException("Last param must be char.");
        }

        Date birthDate;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            birthDate = formatter.parse(dateString);
        } catch (Exception e) {
            throw new RuntimeException("Exception in initializing of date of birth. " + e.getMessage());
        }

        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(numberString);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Exception in parsing phone number. " + e.getMessage());
        }

        char gender;
        try {
            gender = genderString.charAt(0);
        } catch (Exception e) {
            throw new RuntimeException("Exception in initializing char for gender param. ");
        }

        return new User(secondName, firstName, lastName, birthDate, phoneNumber, gender);
    }
}
