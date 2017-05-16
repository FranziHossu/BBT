package controller;

import controller.LaboratoriesController;
import model.Laboratory;
import model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Gozner on 4/1/2017.
 */
public class LaboratoriesControllerTest {

    private LaboratoriesController controller;

    private Student student;
    private Student student2;
    private Student student3;

    private Laboratory lab;
    private Laboratory lab2;
    private Laboratory lab3;

    private BufferedReader labReader;
    private BufferedReader studReader;

    @Before
    public void setUp() throws Exception {
        controller = new LaboratoriesController("studfile.txt", "labfile.txt");

        student = new Student("gjig0013", "Gozner", "Judith", 731);
        student2 = new Student("nmig0026", "Nemes", "Mada", 731);
        student3 = new Student("bmig0003", "Barutia", "Monica", 731);

        lab = new Laboratory(1, "29/03/2019", 2, 4, "gjig0013");
        lab2 = new Laboratory(1, "29/03/2019", 2, 8, "nmig0026");
        lab3 = new Laboratory(1, "29/03/2019", 2, 7, "bmig0003");

        labReader = new BufferedReader(new FileReader("labfile.txt"));
        studReader = new BufferedReader(new FileReader("studfile.txt"));
    }

    @After
    public void tearDown() throws Exception {
        PrintWriter w = new PrintWriter("studfile.txt");
        w.print("");
        w.close();

        PrintWriter w2 = new PrintWriter("labfile.txt");
        w2.print("");
        w2.close();

        studReader.close();
        labReader.close();
    }

    @Test
    public void testSaveStudent() throws Exception {
        if(controller.saveStudent(student)){
            List<Student> studList = controller.getallStudents();
            Student s = studList.get(studList.size() - 1);
            assertEquals(s.toString(),student.toString());

        }else throw new Exception("Student could not be saved!");

        if(controller.saveStudent(student2)){
            List<Student> studList = controller.getallStudents();
            Student s = studList.get(studList.size() - 1);
            assertEquals(s.toString(),student2.toString());

        }else throw new Exception("Student could not be saved!");

        if(controller.saveStudent(student3)){
            List<Student> studList = controller.getallStudents();
            Student s = studList.get(studList.size() - 1);
            assertEquals(s.toString(),student3.toString());

        }else throw new Exception("Student could not be saved!");
    }

    @Test
    public void testSaveLaboratory() throws Exception {
        controller.saveStudent(student);
        if(controller.saveLaboratory(lab)){
            String line;
            Laboratory lab2 = null;

            while ((line = labReader.readLine()) != null) {
                String[] temp = line.split(" ");
                lab2 = new Laboratory(Integer.valueOf(temp[0]), temp[1],  Integer.valueOf(temp[2]), Float.parseFloat(temp[3]),temp[4]);
            }
            assertEquals(lab2.toString(), lab.toString());

        }else throw new Exception("Laboratory could not be saved!");
    }

   /* @Test
    public void testAddGrade() throws Exception {
        controller.saveStudent(student);
        controller.saveLaboratory(lab);
        if (controller.addGrade(lab.getStudentRegNumber(),Integer.toString(lab.getNumber()),9.0f)){
            String line;
            Laboratory lab2 = null;

            while ((line = labReader.readLine()) != null) {
                String[] temp = line.split(" ");
                lab2 = new Laboratory(Integer.valueOf(temp[0]), temp[1],  Integer.valueOf(temp[2]), Float.parseFloat(temp[3]),temp[4]);
            }
            lab.setGrade(9.0f);

            assertEquals(lab2.toString(), lab.toString());

        }else throw new Exception("Could not save new grade!");
    }*/

    @Test
    public void testPassedStudents() throws Exception {
        controller.saveStudent(student);
        controller.saveStudent(student2);
        controller.saveStudent(student3);

        controller.saveLaboratory(lab);
        controller.saveLaboratory(lab2);
        controller.saveLaboratory(lab3);

        List<Student> passedfileStud = controller.passedStudents();
        List<Student> passedStud = new ArrayList<Student>();
        passedStud.add(student3);
        passedStud.add(student2);

        assertEquals(passedfileStud, passedStud);
    }

    @Test
    public void testGetallStudents() throws Exception {
        controller.saveStudent(student2);
        controller.saveStudent(student3);

        String line;
        List<Student> studlist = new ArrayList<Student>();
        Student stud;

        while ((line = studReader.readLine()) != null) {
            String[] temp = line.split(" ");
            stud = new Student(temp[0], temp[1], temp[2], Integer.valueOf(temp[3]));
            studlist.add(stud);
        }
        studReader.close();

        assertEquals(student2, studlist.get(0));
        assertEquals(student3, studlist.get(1));
    }
}