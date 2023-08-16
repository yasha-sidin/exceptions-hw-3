package Logic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String secondName;
    private String firstName;
    private String lastName;
    private final Date dateOfBirth;
    private long phoneNumber;
    private final char gender;
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public User(String secondName, String firstName, String lastName, Date dateOfBirth, long phoneNumber,
                char gender) throws UserParamsException {
        if(dateOfBirth.after(new Date()) || dateOfBirth.equals(new Date())) {
            throw new UserParamsException("Date of birth can't be less than current date or equals this.");
        }
        if (Character.toString(gender).toUpperCase().equals(Gender.F.toString()) ||
                Character.toString(gender).toUpperCase().equals(Gender.M.toString())) {
            setSecondName(secondName);
            setFirstName(firstName);
            setLastName(lastName);
            this.dateOfBirth = dateOfBirth;
            setPhoneNumber(phoneNumber);
            this.gender = gender;
        } else {
            throw new UserParamsException("Not a valid value of gender.");
        }
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) throws UserParamsException {
        if(secondName.length() <= 1) {
            throw new UserParamsException("Length of second name, first name and last name can't be less than 1 or equals this");
        }
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws UserParamsException {
        if(firstName.length() <= 1) {
            throw new UserParamsException("Length of second name, first name and last name can't be less than 1 or equals this");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws UserParamsException {
        if(lastName.length() <= 1) {
            throw new UserParamsException("Length of second name, first name and last name can't be less than 1 or equals this");
        }
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) throws UserParamsException {
        if (phoneNumber <= 0) {
            throw new UserParamsException("Not a valid phoneNumber. It can't be less than 0 or equals this.");
        }
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    private enum Gender {
        F,
        M;
    }

    @Override
    public String toString() {
        return "<" + getSecondName() + "><"  + getFirstName() +
                "><" + getLastName() + "><" + getPhoneNumber() + "><" + formatter.format(getDateOfBirth()) + "><" + getGender() + ">";
    }
}
