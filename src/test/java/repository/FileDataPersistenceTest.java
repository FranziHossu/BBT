package repository;

import model.Laboratory;
import model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Gozner on 4/1/2017.
 */
public class FileDataPersistenceTest {

    private FileDataPersistence fdp;
    private FileDataPersistence fdp2;

    private Student student1;
    private Student student2;
    private Student student3;

    private Laboratory lab1;
    private Laboratory lab2;
    private Laboratory lab3;

    private BufferedReader labReader;
    private BufferedReader studReader;

    @Before
    public void setUp() throws Exception {
        fdp = new FileDataPersistence("studTest.txt");
        fdp2 = new FileDataPersistence("labTest.txt");
        //fdp = new FileDataPersistence("students.txt");
        //fdp2 = new FileDataPersistence("labcopy.txt");

        labReader = new BufferedReader(new FileReader("labTest.txt"));
        studReader = new BufferedReader(new FileReader("studTest.txt"));

        //labReader = new BufferedReader(new FileReader("labcopy.txt"));

        student1 = new Student("gjig0013", "Gozner", "Judith", 731);
        student2 = new Student("bmig0003", "Barutia", "Monica", 731);
        student3 = new Student("nmig0026", "Nemes", "Madalina", 731);

        lab1 = new Laboratory(1, "29/03/2019", 2, 4, "gjig0013");
        lab2 = new Laboratory(1, "29/03/2019", 2, 8, "nmig0026");
        lab3 = new Laboratory(1, "29/03/2019", 2, 7, "bmig0003");
    }

    @After
    public void tearDown() throws Exception {
        PrintWriter w = new PrintWriter("studTest.txt");
        w.print("");
        w.close();

        PrintWriter w2 = new PrintWriter("labTest.txt");
        w2.print("");
        w2.close();

        studReader.close();
        labReader.close();
    }


    @Test
    public void testGetFile() throws Exception {
        assertEquals(fdp.getFile(), "studTest.txt");
        assertEquals(fdp2.getFile(), "labTest.txt");
    }

    @Test
    public void testSetFile() throws Exception {
        fdp.setFile("studfile.txt");
        assertEquals(fdp.getFile(),"studfile.txt");

        fdp.setFile("studfile2.txt");
        assertEquals(fdp.getFile(),"studfile2.txt");

        fdp.setFile("studFile.txt");
        assertFalse(fdp.getFile().equals("studfile.txt"));
    }

    @Test
    public void testSaveStudent() throws Exception {
        List<Student> studList;
        Student s;

        fdp.saveStudent(student1);
        studList = fdp.getStudentsList();
        s = studList.get(studList.size() - 1);
        assertEquals(s.toString(),student1.toString());

        fdp.saveStudent(student2);
        studList = fdp.getStudentsList();
        s = studList.get(studList.size() - 1);
        assertEquals(s.toString(),student2.toString());


        fdp.saveStudent(student3);
        studList = fdp.getStudentsList();
        s = studList.get(studList.size() - 1);
        assertEquals(s.toString(),student3.toString());


    }

    @Test
    public void testSaveLaboratory() throws Exception {
        String line;
        Laboratory lab = null;

        fdp2.saveLaboratory(lab1);
        while ((line = labReader.readLine()) != null) {
            String[] temp = line.split(" ");
            lab = new Laboratory(Integer.valueOf(temp[0]), temp[1],  Integer.valueOf(temp[2]), Float.parseFloat(temp[3]),temp[4]);
        }
        assertEquals(lab.toString(), lab1.toString());

        fdp2.saveLaboratory(lab2);
        while ((line = labReader.readLine()) != null) {
            String[] temp = line.split(" ");
            lab = new Laboratory(Integer.valueOf(temp[0]), temp[1],  Integer.valueOf(temp[2]), Float.parseFloat(temp[3]),temp[4]);
        }
        assertEquals(lab.toString(), lab2.toString());

        fdp2.saveLaboratory(lab3);
        while ((line = labReader.readLine()) != null) {
            String[] temp = line.split(" ");
            lab = new Laboratory(Integer.valueOf(temp[0]), temp[1],  Integer.valueOf(temp[2]), Float.parseFloat(temp[3]),temp[4]);
        }
        assertEquals(lab.toString(), lab3.toString());

    }

   /* @Test
    public void testAddGrade() throws Exception {
        fdp.saveStudent(student1);
        //fdp.saveStudent(student2);
        //fdp.saveStudent(student3);

        fdp2.saveLaboratory(lab1);
        //fdp2.saveLaboratory(lab2);
        //fdp2.saveLaboratory(lab3);

        //fdp2.addGrade("asdf1234", "1", 5);
        fdp2.addGrade("gjig0013","1", 10);

        /*String line;
        Laboratory lab = null;

        while ((line = labReader.readLine()) != null && lab == null) {
            String[] temp = line.split(" ");
            if (temp[4].equals("gjig0013")) {
                lab = new Laboratory(Integer.valueOf(temp[0]), temp[1], Integer.valueOf(temp[2]), Float.parseFloat(temp[3]), temp[4]);
            }
        }
        lab1.setGrade(10);
        assertEquals(lab.toString(), lab1.toString());*

    }*/

    @Test
    public void testGetLaboratoryMap() throws Exception {
        fdp2.saveLaboratory(lab1);
        fdp2.saveLaboratory(lab2);
        fdp2.saveLaboratory(lab3);

        List<Laboratory> list = new ArrayList<Laboratory>();
        Map<String, List<Laboratory>> map = new HashMap<String, List<Laboratory>>();

        list.add(lab1);
        map.put(lab1.getStudentRegNumber(), list);

        list = new ArrayList<Laboratory>();
        list.add(lab2);
        map.put(lab2.getStudentRegNumber(), list);

        list = new ArrayList<Laboratory>();
        list.add(lab3);
        map.put(lab3.getStudentRegNumber(), list);

        assertEquals(map.get(lab1.getStudentRegNumber()).get(0).toString(),
                fdp2.getLaboratoryMap().get(lab1.getStudentRegNumber()).get(0).toString());

        assertEquals( map.get(lab2.getStudentRegNumber()).get(0).toString(),
                fdp2.getLaboratoryMap().get(lab2.getStudentRegNumber()).get(0).toString());

        assertEquals( map.get(lab3.getStudentRegNumber()).get(0).toString(),
                fdp2.getLaboratoryMap().get(lab3.getStudentRegNumber()).get(0).toString());

    }

    @Test
    public void testGetStudentsList() throws Exception {
        fdp.saveStudent(student1);
        fdp.saveStudent(student2);
        fdp.saveStudent(student3);

        List<Student> studList = new ArrayList<Student>();
        studList.add(student1);
        studList.add(student2);
        studList.add(student3);

        assertEquals(studList, fdp.getStudentsList());

    }
}