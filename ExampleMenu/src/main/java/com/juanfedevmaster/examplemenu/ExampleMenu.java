package com.juanfedevmaster.examplemenu;

import java.util.ArrayList;
import java.util.Scanner;

public class ExampleMenu {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Subject> subjects = new ArrayList<>();

        subjects.add(new Subject("Tec. de Programacion", "Sb1"));
        subjects.add(new Subject("Logica 2", "Sb2"));
        subjects.add(new Subject("Bases de Datos", "Sb3"));

        Scanner scan = new Scanner(System.in);

        int optionUser;

        do {

            System.out.println();
            System.out.println("+++++++++++++++++++++++");
            System.out.println("University of Antioquia");
            System.out.println("+++++++++++++++++++++++");
            System.out.println("1. Create Student");
            System.out.println("2. Print all Students");
            System.out.println("3. List Subjects");
            System.out.println("4. Assign Subject to Student");
            System.out.println("5. Print Student with Subjects");
            System.out.println("6. Exit");
            System.out.println("+++++++++++++++++++++++");
            System.out.print("Select an option: ");

            optionUser = scan.nextInt();
            scan.nextLine();

            switch (optionUser) {

                case 1:

                    Student student = new Student();

                    System.out.println();
                    System.out.println("Set the name of the new Student:");
                    student.setName(scan.nextLine());

                    System.out.println("Set the last name of the new Student:");
                    student.setLastName(scan.nextLine());

                    System.out.println("Set the career of the new Student:");
                    student.setCareer(scan.nextLine());

                    students.add(student);

                    System.out.println("Student created successfully.");

                    break;

                case 2:

                    System.out.println();
                    System.out.println("The total students are: " + students.size());

                    if (students.isEmpty()) {
                        System.out.println("There are no students created.");
                    }

                    for (Student s : students) {

                        System.out.println("+++++++++++++");
                        System.out.println("The full name of the student is: "
                                + s.getName() + " " + s.getLastName());
                        System.out.println("Career: " + s.getCareer());
                    }

                    break;

                case 3:

                    System.out.println();
                    System.out.println("Available Subjects:");
                    System.out.println("+++++++++++++++++++++++");

                    for (int i = 0; i < subjects.size(); i++) {

                        Subject subject = subjects.get(i);

                        System.out.println((i + 1) + ". "
                                + subject.getName()
                                + " - Code: "
                                + subject.getCode());
                    }

                    break;

                case 4:

                    if (students.isEmpty()) {

                        System.out.println();
                        System.out.println("There are no students created.");

                    } else {

                        System.out.println();
                        System.out.println("Select a student:");

                        for (int i = 0; i < students.size(); i++) {

                            Student s = students.get(i);

                            System.out.println((i + 1) + ". "
                                    + s.getName() + " "
                                    + s.getLastName());
                        }

                        int studentOption = scan.nextInt();
                        scan.nextLine();

                        if (studentOption < 1 || studentOption > students.size()) {

                            System.out.println("Invalid student.");

                        } else {

                            Student selectedStudent = students.get(studentOption - 1);

                            // Verificar si ya tiene 3 asignaturas
                            if (selectedStudent.getSubjects().size() >= 3) {

                                System.out.println(
                                        "This student already has the maximum of 3 subjects."
                                );

                            } else {

                                System.out.println();
                                System.out.println("Available Subjects:");

                                for (int i = 0; i < subjects.size(); i++) {

                                    Subject subject = subjects.get(i);

                                    System.out.println((i + 1) + ". "
                                            + subject.getName()
                                            + " - "
                                            + subject.getCode());
                                }

                                System.out.println();
                                System.out.print("Select a subject: ");

                                int subjectOption = scan.nextInt();
                                scan.nextLine();

                                if (subjectOption < 1 || subjectOption > subjects.size()) {

                                    System.out.println("Invalid subject.");

                                } else {

                                    Subject selectedSubject =
                                            subjects.get(subjectOption - 1);

                                    boolean added =
                                            selectedStudent.addSubject(selectedSubject);

                                    if (added) {

                                        System.out.println(
                                                "Subject assigned successfully."
                                        );

                                    } else {

                                        System.out.println(
                                                "The student already has this subject."
                                        );
                                    }
                                }
                            }
                        }
                    }

                    break;

                case 5:

                    if (students.isEmpty()) {

                        System.out.println();
                        System.out.println("There are no students created.");

                    } else {

                        System.out.println();
                        System.out.println("Select a student:");

                        for (int i = 0; i < students.size(); i++) {

                            Student s = students.get(i);

                            System.out.println((i + 1) + ". "
                                    + s.getName() + " "
                                    + s.getLastName());
                        }

                        int studentOption = scan.nextInt();
                        scan.nextLine();

                        if (studentOption < 1 || studentOption > students.size()) {

                            System.out.println("Invalid student.");

                        } else {

                            Student selectedStudent =
                                    students.get(studentOption - 1);

                            System.out.println();
                            System.out.println("+++++++++++++++++++++++");
                            System.out.println("Student Information");
                            System.out.println("+++++++++++++++++++++++");

                            System.out.println(
                                    "Name: "
                                    + selectedStudent.getName()
                                    + " "
                                    + selectedStudent.getLastName()
                            );

                            System.out.println(
                                    "Career: "
                                    + selectedStudent.getCareer()
                            );

                            System.out.println("Subjects:");

                            if (selectedStudent.getSubjects().isEmpty()) {

                                System.out.println("No subjects assigned.");

                            } else {

                                for (Subject subject :
                                        selectedStudent.getSubjects()) {

                                    System.out.println(
                                            "- "
                                            + subject.getName()
                                            + " ("
                                            + subject.getCode()
                                            + ")"
                                    );
                                }
                            }
                        }
                    }

                    break;

                case 6:

                    System.out.println("Goodbye!");

                    break;

                default:

                    System.out.println("Invalid option.");

                    break;
            }

        } while (optionUser != 6);

        scan.close();
    }
}
