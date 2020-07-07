
//java -ea StudentHashSetTester

import java.util.Random;
import java.lang.Math.*;
import java.util.*;
import java.text.*;

public class StudentHashSetTester {
    public static void main(String args[]) {
        Random r = new Random(1);
        DecimalFormat formatter = new DecimalFormat("#,###,###,###");

        //Test if Student is repeatable
        Student student1 = new Student("Chandler", "Yocca", 1065837);
        Student student2 = new Student("Chandler", "Yocca", 1065837);
        int student1Hash = student1.hashCode();
        int student2Hash = student2.hashCode();
        assert student1Hash == student2Hash:"FAIL: Student is not repeatable";

        //Test if ProductRecord is repeatable
        ProductRecord ProductRecord1 = new ProductRecord("Product", 100.15, 10019, 11, 503, 2);
        ProductRecord ProductRecord2 = new ProductRecord("Product", 100.15, 10019, 11, 503, 2);
        int ProductRecord1Hash = ProductRecord1.hashCode();
        int ProductRecord2Hash = ProductRecord2.hashCode();
        assert ProductRecord1Hash == ProductRecord2Hash:"FAIL: ProductRecord is not repeatable";

        //Check collisions for Student
        int numberOfStudents = 100000;
        int arraySize = numberOfStudents * 2;
        HashSet<Integer> hashCodes = new HashSet<Integer>(numberOfStudents);
        Student[] array = new Student[arraySize];
        int arrayCollisions = 0;
        int hashCollisions = 0;
        for (int i = 0; i < numberOfStudents; i++) {
            Student student = createStudent(r);
            int hash = student.hashCode();
            if (!hashCodes.add(hash))    hashCollisions++;
            if (array[Math.abs(hash) % arraySize] == null)
                array[Math.abs(hash) % arraySize] = student;
            else
                arrayCollisions++;
        }
        System.out.println("\n***Student***");
        System.out.println("Your hashcode collided " + (arrayCollisions * 100.0) / numberOfStudents + "% of the time in the array.");
        System.out.println("(" + formatter.format(arrayCollisions) + " out of " + formatter.format(numberOfStudents) + ")");
        System.out.println("The same hashCode was generated " + (hashCollisions * 100.0) / numberOfStudents + "% of the time.");
        System.out.println("(" + formatter.format(hashCollisions) + " out of " + formatter.format(numberOfStudents) + ")");

        //Check collisions for ProductRecord
        int numberOfProductRecords = 100000;
        arraySize = numberOfProductRecords * 2;
        hashCodes = new HashSet<Integer>(numberOfProductRecords);
        ProductRecord[] array2 = new ProductRecord[arraySize];
        arrayCollisions = 0;
        hashCollisions = 0;
        for (int i = 0; i < numberOfProductRecords; i++) {
            ProductRecord productRecord = createProductRecord(r);
            int hash = productRecord.hashCode();

            if (!hashCodes.add(hash))    hashCollisions++;

            if (array2[Math.abs(hash) % arraySize] == null)
                array2[Math.abs(hash) % arraySize] = productRecord;
            else
                arrayCollisions++;
        }
        System.out.println("\n***ProductRecord***");
        System.out.println("Your hashcode collided " + (arrayCollisions * 100.0) / numberOfProductRecords + "% of the time in the array.");
        System.out.println("(" + formatter.format(arrayCollisions) + " out of " + formatter.format(numberOfProductRecords) + ")");
        System.out.println("The same hashCode was generated " + (hashCollisions * 100.0) / numberOfProductRecords + "% of the time.");
        System.out.println("(" + formatter.format(hashCollisions) + " out of " + formatter.format(numberOfProductRecords) + ")\n");

        //Testing StudentHashSet
        StudentHashSet defaultSet = new StudentHashSet(); //Test default constructor
        assert defaultSet.size() == 0:"Your size should be initialized to 0";
        StudentHashSet sizedSet = new StudentHashSet(25); //Test constructor with size

        StudentHashSet bigAdd = new StudentHashSet();
        for (int i = 0; i < 50000; i++) {
            bigAdd.add(createStudent(r));
            int size = bigAdd.size();
            assert bigAdd.size() == i+1:"Your size is not incremented properly. Your size is "+ size + " Size should be " +(i+1);
        }

        StudentHashSet addTwice = new StudentHashSet();
        Student student = createStudent(r);
        addTwice.add(student);
        addTwice.add(student);
        assert addTwice.size() == 1:"You should not add the same thing to a set twice";
        addTwice.remove(student);
        assert !addTwice.remove(student):"You should not add the same thing to a set twice";

        StudentHashSet emptySet = new StudentHashSet();
        student = createStudent(r);
        assert !emptySet.remove(student):"Your remove should have returned false";

        bigAdd = new StudentHashSet();
        for (int i = 0; i < 50000; i++) {
            student = createStudent(r);
            bigAdd.add(student);
            assert bigAdd.contains(student):"Your contains method should have returned true";
            assert bigAdd.remove(student):"Your remove should have returned true";
            assert bigAdd.size() == 0:"Your size is not decremented properly";
            assert !bigAdd.contains(student):"Your contains method should have returned false";
        }
        /*
        StudentHashSet testReindex = new StudentHashSet();
        Student first = new Student("Chandler", "Yocca", 375540564);
        testReindex.add(first);
        Student second = new Student("Chandler", "Yocca", 375540564);
        testReindex.add(second);
        testReindex.remove(first);
        boolean contains = testReindex.contains(second);
        assert testReindex.contains(second):"You must reindex your StudentHashSet after removing a student. Contains: " + contains;
        */

        System.out.println("Passed :)\n");
    }

    public static String createName(Random r, int shortest, int longest) {
        int nameLength = r.nextInt(longest-shortest+1) + shortest;
        String name = "";
        for (int i = 0; i < nameLength; i++) {
            String letter = null;
            int _case = r.nextInt(2);
            if (_case == 0)
                letter = "" + (char) (r.nextInt(26) + 97);
            else
                letter = "" + (char) (r.nextInt(26) + 65);
            name += letter;
        }
        return name;
    }

    public static int createID(Random r, int length) {
        return r.nextInt((int)Math.pow(10, length+1));
    }

    public static Student createStudent(Random r) {
        return new Student(createName(r, 2, 15), createName(r, 2, 10), createID(r, 8));
    }

    public static double createPrice(Random r, int max) {
        return r.nextInt((int)Math.pow(10, max+3)) / 100.0;
    }

    public static int createCode(Random r, int start, int end) {
        return r.nextInt(end-start+1) + start;
    }

    public static ProductRecord createProductRecord(Random r) {
        return new ProductRecord(createName(r, 5, 20), createPrice(r, 5), createCode(r, 10000, 10021), createCode(r, 10, 12), createCode(r, 500, 520), createCode(r, 0, 4));
    }
}