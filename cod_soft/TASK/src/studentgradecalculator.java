import java.util.Scanner;

public class studentgradecalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Calculator!");

        // Prompt user to enter the number of subjects
        System.out.print("Enter the number of subjects: ");
        int totalSubjects = scanner.nextInt();

        double totalMarks = 0;

        // Input marks for each subject and calculate total marks
        for (int i = 1; i <= totalSubjects; i++) {
            System.out.printf("Enter marks obtained in subject %d (out of 100): ", i);
            double marks = scanner.nextDouble();

            // Validate marks
            while (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Marks should be between 0 and 100.");
                System.out.printf("Enter marks obtained in subject %d (out of 100): ", i);
                marks = scanner.nextDouble();
            }

            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage = (totalMarks / (totalSubjects * 100)) * 100;

        // Assign grade based on average percentage
        String grade;

        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.printf("\nTotal Marks: %.2f out of %d\n", totalMarks, totalSubjects * 100);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}