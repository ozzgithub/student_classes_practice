import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join

        REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them

        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."

        Store all these 3 objects in a collection and print them

        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */


        Scanner input = new Scanner(System.in);

        String answer;
        int numberOfMathStudents = 0;
        int numberOfScienceStudents = 0;
        int age = 0;
        String className = "";


        List<Student> studentList = new ArrayList<>();


        do {
            System.out.println(UserQuestions.askToJoin);
            answer = input.next();

            if (answer.toUpperCase().startsWith("Y")) {
                System.out.println(UserQuestions.askFirstName);
                String firstName = input.next();
                System.out.println(UserQuestions.askLastName);
                String lastName = input.next();
                try {
                    System.out.println(UserQuestions.askAge);
                    age = input.nextInt();
                    Permission.checkAge(age);
                } catch (Exception e) {
                    System.out.println(age + " is not allowed");
                }


                if (age > 20){

                    System.out.println(UserQuestions.askGender);
                    String gender = input.next();
                    try {
                        System.out.println(UserQuestions.askClassName);
                        className = input.next();
                        Permission.checkClassName(className);
                        if (className.equalsIgnoreCase("Math")) {
                            numberOfMathStudents++;
                            System.out.println("Congratulations! You are registered for " + className + " class.");
                            MathStudent mathStudent = new MathStudent(firstName, lastName, age, gender, className);
                            studentList.add(mathStudent);
                        } else if (className.equalsIgnoreCase("Science")) {
                            numberOfScienceStudents++;
                            System.out.println("Congratulations! You are registered for " + className + " class.");
                            ScienceStudent scienceStudent = new ScienceStudent(firstName, lastName, age, gender, className);
                            studentList.add(scienceStudent);
                        }
                    } catch (Exception e) {
                        System.out.println(className + " is not allowed");

                    }
                }
            }


        } while (numberOfMathStudents + numberOfScienceStudents < 3) ; // total 3






        for (Student student : studentList) {
            System.out.println(student.toString());
        }
        System.out.println("Math students = " + numberOfMathStudents);
        System.out.println("Science students = " + numberOfScienceStudents);



        System.out.println("---------------End-------------");

    }
}




