package validator;

import model.Laboratory;
import model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;



/**
 * Created by Gozner on 4/1/2017.
 */
public class ValidatorTest {

    private Validator validator;
    private List<Student> studList;

    private Student student1;
    private Student student2;
    private Student student3;

    @Before
    public void setUp() throws Exception {
        validator = new Validator();

        student1 = new Student("gjig0013", "Gozner", "Judith", 731);
        student2 = new Student("nmig0026", "Nemes", "Mada", 731);
        student3 = new Student("bmig0003", "Barutia", "Monica", 731);

        studList = new ArrayList<Student>();
        studList.add(student1);
        studList.add(student2);
        studList.add(student3);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testValidateStudent() throws Exception {
        Student student4 = new Student("3","Gozner", "Judith", 731);
        Student student5 = new Student("gjig0013","Gozner", "Judith-Eniko", 731);
        Student student6 = new Student("bmig0003","Barutia Stef", "Monica", 731);
        Student student7 = new Student("srig0028","Sab0", "Roxana", 721);
        Student student8 = new Student("srig0028","Sabo", "Roxana", -1);

        assertEquals(validator.validateStudent(student1), true);
        assertEquals(validator.validateStudent(student2), true);
        assertEquals(validator.validateStudent(student4), false);
        assertEquals(validator.validateStudent(student5), false);
        assertEquals(validator.validateStudent(student6),false);
        assertEquals(validator.validateStudent(student7),false);
        assertEquals(validator.validateStudent(student8),false);
    }

    @Test
    public void testValidateLaboratory() throws Exception {
        Laboratory lab1 = new Laboratory(1,"29/03/2018", 2, 10, "gjig0013");
        //Laboratory lab2 = new Laboratory(2,"29.03.2017", 3, "nmig0026");
        Laboratory lab3 = new Laboratory(1,"29/03/2018", 3, "nmig0027");
        Laboratory lab4 = new Laboratory(-1,"29/03/2018", 3, "nmig0026");
        Laboratory lab5 = new Laboratory(1,"29/02/2017", 3, "gjig0013");
        //Laboratory lab6 = new Laboratory(1,"28/03/2017", 3, "bmig0003");
        Laboratory lab7 = new Laboratory(1,"28/02/2019", 12, "nmig0026");
        Laboratory lab8 = new Laboratory(1,"28/02/2018", 12, 12, "nmig0026");

        assertEquals(validator.validateLaboratory(lab1, studList),true);
        //assertEquals(validator.validateLaboratory(lab2, studList), false);
        assertEquals(validator.validateLaboratory(lab3, studList), false);
        assertEquals(validator.validateLaboratory(lab4, studList), false);
        assertEquals(validator.validateLaboratory(lab5, studList), false);
        //assertEquals(validator.validateLaboratory(lab6, studList), true);
        assertEquals(validator.validateLaboratory(lab7, studList), true);
        assertEquals(validator.validateLaboratory(lab8, studList), false);
    }

    @Test
    public void testValidateGrade() throws Exception {
        Laboratory lab1;

        lab1 = new Laboratory(1, "29/03/2019",2,10f,"gjig0013");
        assertTrue(validator.validateGrade(lab1.getGrade()));

        lab1.setGrade(0);
        assertFalse(validator.validateGrade(lab1.getGrade()));

        lab1.setGrade(11);
        assertFalse(validator.validateGrade(lab1.getGrade()));
    }

    @Test
    public void testExitNrReg() throws Exception {
        assertTrue(validator.exitNrReg(student1.getRegNumber(), studList));
        assertTrue(validator.exitNrReg(student2.getRegNumber(), studList));
        assertTrue(validator.exitNrReg(student3.getRegNumber(), studList));

        String nrReg, nrReg2;

        Student stud = new Student("srig0028","Sabo", "Roxana", 731);
        Student stud2 = new Student("fsig0014","Feher", "Sandor", 731);
        nrReg = stud.getRegNumber();
        nrReg2 = stud2.getRegNumber();

        assertFalse(validator.exitNrReg(nrReg, studList));
        studList.add(stud);
        assertTrue(validator.exitNrReg(nrReg, studList));

        assertFalse(validator.exitNrReg(nrReg2, studList));
        studList.add(stud2);
        assertTrue(validator.exitNrReg(nrReg2, studList));
    }
}