import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        List<StudentGrade> studentGrades = readStudents("files/grades.txt");
        printListOfStudentNames(studentGrades);


        //Have an object Classroom that will receive a list of StudentGrade and implement the following methods:
        //getGradesForDiscipline(String discipline) : List<Integer>

        Classroom classroom = new Classroom(studentGrades);
        List<Integer> mathematicsGrades = classroom.getGradesForDiscipline(studentGrades, "Mathematics");
        List<Integer> historyGrades = classroom.getGradesForDiscipline(studentGrades, "History");

        //getGradesForStudent(String student) : List<Integer>
        List<Integer> gradesFroS = classroom.getGradesForStudent(studentGrades, "Asim");
        List<Integer> gradesForS2 = classroom.getGradesForStudent(studentGrades, "Dulf");

        //getMaxGrade(String discipline) : StudentGrade
        System.out.println(classroom.getMaxGrade(studentGrades, "History"));

        //getMaxGrade() : StudentGrade
        classroom.getMaxGrade(studentGrades);

        //getAverageGrade(String discipline) : Integer
        classroom.getAverageGrade(studentGrades, "Physics");

        //getWorstGrade(String discipline) : StudentGrade
        classroom.getWorstGrade(studentGrades, "Physics");



        RaportGenerator raportGenerator = new RaportGenerator(studentGrades, classroom);
        raportGenerator.generateReport(studentGrades, classroom);
    }

    public static List<StudentGrade> readStudents(String filePath) throws FileNotFoundException {

        List<StudentGrade> students = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filePath));

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(Pattern.quote("|"));
            students.add(new StudentGrade(getOnlyName(tokens[0]),
                    tokens.length >= 2 ? tokens[1].replaceAll(String.valueOf(0-9), " ") : "Missing Discipline",
                    tokens.length >= 3 ? Integer.parseInt(tokens[2].replaceAll("[^(0-9)]", " ")) : 0));
            for (StudentGrade s : students) {
                if (s.getGrade() > 10) { // am observat ca exista o nota cu valoarea lui 17;
                    s.setGrade(0);       // in astfel de cazuri, valoarea va fi setata la 0, aceasta valoare fiind ignorata in
                }                       // metodele folosite asupra listei
            }
        }
        return students;
    }



    // pentru ca token[0] contine numele complet (ex. Gasparo Sava), folosim metoda de mai jos pentru a separa cele doua nume
    // si a returna doar numele (Gasparo).
    private static String getOnlyName(String fullName) {

        String[] onlyName = fullName.split(Pattern.quote(" ")); //onlyName[0] == name & onlyName[1] == surname
        return onlyName[0];
    }

    public static void printListOfStudentNames(List<StudentGrade> list) {

        for (StudentGrade student : list) {
            System.out.println(student.getName());
        }
    }

}