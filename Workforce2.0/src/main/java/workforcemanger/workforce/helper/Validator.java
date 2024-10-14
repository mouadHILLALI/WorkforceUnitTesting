package workforcemanger.workforce.helper;

public class Validator {

    public Validator() {}
    public static boolean isNotNullOrEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean validateName(String name) {
        if (!isNotNullOrEmpty(name)) {
            return false;
        }
        return name.matches("^[a-zA-Z\\s]+$");
    }

    public static boolean validateEmail(String email) {
        if (!isNotNullOrEmpty(email)) {
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        if (!isNotNullOrEmpty(phoneNumber)) {
            return false;
        }
        return phoneNumber.matches("^\\+?[0-9]{10,15}$");
    }

    public boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static boolean validateAllFields(String name, String email, String phoneNumber) {
        return isNotNullOrEmpty(name) &&
                validateName(name) &&
                isNotNullOrEmpty(email) &&
                validateEmail(email) &&
                isNotNullOrEmpty(phoneNumber) &&
                validatePhoneNumber(phoneNumber);
    }

    public boolean validateAllFields(String name, String email, String phoneNumber, Object additionalField) {
        return validateAllFields(name, email, phoneNumber) && isNotNull(additionalField);
    }
}
