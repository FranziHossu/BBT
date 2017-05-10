//package model;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
///**
// * Created by Gozner on 4/1/2017.
// */
//public class StudentTest {
//
//    private Student student;
//    private Student student1;
//    private Student student2;
//    private Student student3;
//
//    @Before
//    public void setUp() throws Exception {
//        student = new Student();
//        student1 = new Student("gjig0013", "Gozner","Judith",731);
//        student2 = new Student("bmig0003", "Barutia", "Monica", 732);
//        student3 = new Student("nmig0026", "Nemes", "Madalina", 733);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//
//    }
//
//    @Test
//    public void testGetRegNumber() throws Exception {
//        assertEquals("gjig0013", student1.getRegNumber());
//        assertEquals("bmig0003",student2.getRegNumber());
//        assertEquals("nmig0026",student3.getRegNumber());
//    }
//
//    @Test
//    public void testSetRegNumber() throws Exception {
//        student.setRegNumber("gjig0013");
//        assertEquals("gjig0013",student.getRegNumber());
//        student.setRegNumber("nmig0026");
//        assertEquals("nmig0026",student.getRegNumber());
//        student.setRegNumber("13");
//        assertEquals("13",student.getRegNumber());
//        student.setRegNumber("0003bmig");
//        assertEquals("0003bmig",student.getRegNumber());
//    }
//
//    @Test
//    public void testGetName() throws Exception {
//        assertEquals("Judith",student1.getName());
//        assertEquals("Monica",student2.getName());
//        assertEquals("Madalina",student3.getName());
//    }
//
//    @Test
//    public void testSetName() throws Exception {
//        student.setName("Ana");
//        assertEquals("Eroare in setName","Ana",student.getName());
//        student.setName("90Ana");
//        assertEquals("Eroare in setName","90Ana",student.getName());
//        student.setName("Ott0");
//        assertEquals("Eroare in setName","Ott0",student.getName());
//        student.setName("*Judith");
//        assertEquals("Eroare in setName","*Judith",student.getName());
//    }
//
//    @Test
//    public void testGetSurname() throws Exception {
//        assertEquals("Gozner",student1.getSurname());
//        assertEquals("Barutia",student2.getSurname());
//        assertEquals("Nemes",student3.getSurname());
//    }
//
//    @Test
//    public void testSetSurname() throws Exception {
//        student.setSurname("Bodor");
//        assertEquals("Eroare in setSurname","Bodor",student.getSurname());
//        student.setSurname("P0p");
//        assertEquals("Eroare in setSurname","P0p",student.getSurname());
//        student.setSurname("-Nagy");
//        assertEquals("Eroare in setSurname","-Nagy",student.getSurname());
//        student.setSurname("Mihaly");
//        assertEquals("Eroare in setSurname","Mihaly",student.getSurname());
//    }
//
//    @Test
//    public void testGetGroup() throws Exception {
//        assertEquals(731,student1.getGroup());
//        assertEquals(732,student2.getGroup());
//        assertEquals(733,student3.getGroup());
//    }
//
//    @Test
//    public void testSetGroup() throws Exception {
//        student.setGroup(741);
//        assertEquals("Eroare in setGroup",741,student.getGroup());
//        student.setGroup(001);
//        assertEquals("Eroare in setGroup",001,student.getGroup());
//        student.setGroup(-1);
//        assertEquals("Eroare in setGroup",-1,student.getGroup());
//        student.setGroup(10000000);
//        assertEquals("Eroare in setGroup",10000000,student.getGroup());
//        student.setGroup(9);
//        assertFalse("Eroare in setGroup", 9 != student.getGroup());
//    }
//
//    @Test
//    public void testEquals() throws Exception {
//        assertFalse(student1.equals(student2));
//        assertTrue(student1.equals(student1));
//
//        Student student4 = new Student("gjig0013", "Gozner", "Judith", 731);
//        assertTrue(student4.equals(student1));
//    }
//}