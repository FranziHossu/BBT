package validator;

import model.Laboratory;
import model.Student;

import java.util.Date;
import java.util.List;

/**
 * Created by Gozner on 4/1/2017.
 */
public class Validator {

    public static boolean validateStudent(Student student) {
        //4litere + 4cifre
        if(!student.getRegNumber().matches("[a-zA-Z]{4}[\\d]{4}")){
            return false;
        }
        if (!student.getName().matches("[a-zA-Z]+")) {
            return false;
        }
        if (!student.getSurname().matches("[a-zA-Z]+")) {
            return false;
        }
        if(student.getGroup() >= 1000 || student.getGroup() <= 0){
            return false;
        }

        return true;
    }

    public static boolean validateLaboratory(Laboratory laboratory, List<Student> allStudents) {
        if(laboratory.getNumber() < 1) {
            return false;
        }
        if(laboratory.getProblemNumber() < 1) {
            return false;
        }
        if(laboratory.getGrade() < 1.0 || laboratory.getGrade() > 10.0){
            return false;
        }
        Date date = new Date();
        if(date.after(laboratory.getDate())) {
            return false;
        }
        if(!laboratory.getStudentRegNumber().matches("[a-zA-Z]{4}[\\d]{4}")){
            return false;
        }
        return exitNrReg(laboratory.getStudentRegNumber(), allStudents);
        //return false;

        //return true;
    }

    public static boolean validateGrade(float grade) {
        return (grade >= 1 && grade <= 10);
    }

    public static boolean exitNrReg(String nrReg, List<Student> allStudents){
        for(Student stud: allStudents){
            if(stud.getRegNumber().equals(nrReg))
                return true;
        }
        //System.out.println("Inexistent Student!");
        return false;
    }
}