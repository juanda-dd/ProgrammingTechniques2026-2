package com.juanfedevmaster.examplemenu;

import java.util.ArrayList;

public class Student {

    private String name;
    private String lastName;
    private String career;
    private ArrayList<Subject> subjects;

    public Student(String name, String lastName, String career, ArrayList<Subject> subjects) {
        this.name = name;
        this.lastName = lastName;
        this.career = career;
        this.subjects = subjects;
    }

    public Student() {
        this.subjects = new ArrayList<>();
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCareer() {
        return career;
    }

    public boolean agregarAsignatura(Subject subject) {

        if (subjects == null) {
            subjects = new ArrayList<>();
        }

        // Máximo 3 asignaturas
        if (subjects.size() >= 3) {
            return false;
        }

        // Evitar asignaturas repetidas
        for (Subject s : subjects) {
            if (s.getCode().equals(subject.getCode())) {
                return false;
            }
        }

        subjects.add(subject);
        return true;
    }

    @Override
    public String toString() {

        String resultado = "Nombre: " + name
                + "\nApellido: " + lastName
                + "\nCarrera: " + career
                + "\nAsignaturas:";

        if (subjects == null || subjects.isEmpty()) {
            resultado += "\nNo tiene asignaturas asignadas.";
        } else {
            for (Subject subject : subjects) {
                resultado += "\n- " + subject.getName()
                        + " (" + subject.getCode() + ")";
            }
        }

        return resultado;
    }
}
