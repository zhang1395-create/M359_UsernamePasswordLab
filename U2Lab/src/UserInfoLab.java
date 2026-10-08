import java.util.Scanner;
public class UserInfoLab {
    public static void main(String[] args) {
        // Part 1
        Scanner input = new Scanner(System.in);

        System.out.println("What is your first name?");
        String firstname = input.nextLine();
        System.out.println("What is your last name?");
        String lastName = input.nextLine();
        String user = generateUsername(firstname, lastName);
        System.out.println("Enter a password:");
        String pass = input.nextLine();
        boolean password = validatePassword(pass);

        if(password == true){
            System.out.println("Enter credit card number");
            String credit = input.nextLine();
            String maskCred = maskCreditCard(credit);
            if(maskCred.equals(credit) != true){
                System.out.println("Final Details: ");
                System.out.println("Username: " + user);
                System.out.println("Credit Card number: " + maskCred);
            }
        }

        // Create a Scanner for keyboard input
        // Ask the user to enter their first and last name and pass these
        // values to the generateUsername method and save the returned result.

        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        // The validatePassword method will check if the password meets the criteria:

        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        // credit card number and pass this value to the maskCreditCard method.

        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output
        // as shown in the demo video
        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing

    }

    public static String generateUsername(String firstName, String lastName) {
        String user = "";
        if(firstName.length() <= 3){
            user += firstName;
        }

        else{
            user += firstName.substring(0,3);


        }
        if(lastName.length() <= 3){
            user += lastName;
        }
        else{
            user += lastName;

        }
        user = user.toLowerCase();
        return user;
        // Fill in this method and return an appropriate username

    }
    public static boolean validatePassword(String password) {
        if(password.length() >= 8){
            if(!password.toLowerCase().equals(password)){
                if(containsDigit(password) == true){
                    return true;
                }
                else{
                    System.out.println("must contain 1 digit");
                }

            }
            else{
                System.out.println("must have at least one upper case character");
            }


        }
        else{
            System.out.println("must be at least 8 characters");
        }
        return false;
    }
    public static String maskCreditCard(String creditCardNumber) {
        if(allDigits(creditCardNumber) == false || creditCardNumber.length() != 16){
            return "N/A";
        }
        String newPass = "**** **** **** " + creditCardNumber.substring(12);


        // Fill in this method and if the credit card is valid, return a masked CC
        return newPass;
    }

    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
