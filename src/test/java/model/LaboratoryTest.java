//package model;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.DoubleSummaryStatistics;
//
//import static org.junit.Assert.*;
//
///**
// * Created by Gozner on 4/1/2017.
// */
//public class LaboratoryTest {
//
//    private SimpleDateFormat format;
//
//    private Laboratory lab;
//    private Laboratory lab1;
//    private Laboratory lab2;
//    private Laboratory lab3;
//
//    @Before
//    public void setUp() throws Exception {
//
//        format = new SimpleDateFormat("dd/MM/yyyy");
//
//        lab = new Laboratory(1, "01/04/2017", 1, 10, "gjig0013");
//        lab1 = new Laboratory(2, "02/04/2019", 2, 9, "nmig0026");
//        lab2 = new Laboratory(3, "29/02/2016", 1, 8, "bmig0003");
//        lab3 = new Laboratory(10, "28/02/2017", 3, 7, "srig0028");
//    }
//
//    @After
//    public void tearDown() throws Exception {
//
//    }
//
//    @Test
//    public void testGetNumber() throws Exception {
//        assertEquals(1,lab.getNumber());
//        assertEquals(2,lab1.getNumber());
//        assertEquals(3, lab2.getNumber());
//        assertEquals(10,lab3.getNumber());
//    }
//
//    @Test
//    public void testSetNumber() throws Exception {
//        lab.setNumber(11);
//        assertEquals(11,lab.getNumber());
//
//        lab.setNumber(100);
//        assertEquals(100, lab.getNumber());
//
//        lab.setNumber(-1);
//        assertEquals(-1, lab.getNumber());
//
//        lab.setNumber(2);
//        assertEquals(2, lab.getNumber());
//    }
//
//    @Test
//    public void testGetDate() throws Exception {
//
//        assertEquals(format.parse("01/04/2017"), lab.getDate());
//        assertEquals(format.parse("02/04/2019"), lab1.getDate());
//        assertEquals(format.parse("29/02/2016"), lab2.getDate());
//        assertEquals(format.parse("28/02/2017"), lab3.getDate());
//    }
//
//    @Test
//    public void testSetDate() throws Exception {
//        Date date;
//
//        date = format.parse("01/07/2017");
//        lab.setDate(date);
//        assertEquals(date, lab.getDate());
//
//        date = format.parse("29/02/2012");
//        lab.setDate(date);
//        assertEquals(date, lab.getDate());
//
//        date = format.parse("23/01/1995");
//        lab.setDate(date);
//        assertEquals(date, lab.getDate());
//
//    }
//
//    @Test
//    public void testGetProblemNumber() throws Exception {
//        assertEquals(1, lab.getProblemNumber());
//        assertEquals(2, lab1.getProblemNumber());
//        assertEquals(1, lab2.getProblemNumber());
//        assertEquals(3, lab3.getProblemNumber());
//    }
//
//    @Test
//    public void testSetProblemNumber() throws Exception {
//        lab.setProblemNumber(10);
//        assertEquals(10, lab.getProblemNumber());
//
//        lab.setProblemNumber(100000);
//        assertEquals(100000,lab.getProblemNumber());
//
//        lab.setProblemNumber(-1);
//        assertEquals(-1, lab.getProblemNumber());
//    }
//
//    @Test
//    public void testGetGrade() throws Exception {
//        assertEquals(Double.toString(10), Double.toString(lab.getGrade()));
//        assertEquals(Double.toString(9), Double.toString(lab1.getGrade()));
//        assertEquals(Double.toString(8), Double.toString(lab2.getGrade()));
//        assertEquals(Double.toString(7), Double.toString(lab3.getGrade()));
//    }
//
//    @Test
//    public void testSetGrade() throws Exception {
//        lab.setGrade(6);
//        assertEquals(Double.toString(6),Double.toString(lab.getGrade()));
//
//        lab.setGrade(-1);
//        assertEquals(Double.toString(-1), Double.toString(lab.getGrade()));
//
//        lab.setGrade(100);
//        assertEquals(Double.toString(100), Double.toString(lab.getGrade()));
//    }
//
//    @Test
//    public void testGetStudentRegNumber() throws Exception {
//        assertEquals("gjig0013", lab.getStudentRegNumber());
//        assertEquals("nmig0026", lab1.getStudentRegNumber());
//        assertEquals("bmig0003", lab2.getStudentRegNumber());
//        assertEquals("srig0028", lab3.getStudentRegNumber());
//    }
//
//    @Test
//    public void testSetStudentRegNumber() throws Exception {
//        lab.setStudentRegNumber("giig0053");
//        assertEquals("giig0053", lab.getStudentRegNumber());
//
//        lab.setStudentRegNumber("fsig0014");
//        assertEquals("fsig0014", lab.getStudentRegNumber());
//
//        lab.setStudentRegNumber("2");
//        assertEquals("2", lab.getStudentRegNumber());
//    }
//}