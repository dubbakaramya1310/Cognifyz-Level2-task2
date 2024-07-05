import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter a password
        System.out.print("Enter a password to check its strength: ");
        String password = scanner.nextLine();
        
        // Analyze the password strength
        String strength = analyzePasswordStrength(password);
        
        // Provide feedback on the password strength
        System.out.println("Password strength: " + strength);
        
        scanner.close();
    }
    
    public static String analyzePasswordStrength(String password) {
        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        
        // Check for presence of different character types
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }
        
        // Determine the strength of the password
        if (length >= 12 && hasUppercase && hasLowercase && hasNumber && hasSpecialChar) {
            return "Very Strong";
        } else if (length >= 8 && hasUppercase && hasLowercase && hasNumber && hasSpecialChar) {
            return "Strong";
        } else if (length >= 8 && ((hasUppercase && hasLowercase && hasNumber) || 
                                   (hasUppercase && hasLowercase && hasSpecialChar))) {
            return "Moderate";
        } else if (length >= 6 && (hasUppercase || hasLowercase) && (hasNumber || hasSpecialChar)) {
            return "Weak";
        } else {
            return "Very Weak";
        }
    }
}
