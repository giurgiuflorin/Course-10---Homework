import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RaportGenerator {

    private List<StudentGrade> raportGeneratorList;
    private Classroom classroom;


    public RaportGenerator(List<StudentGrade> raportGeneratorList, Classroom classroom) {
        this.raportGeneratorList = raportGeneratorList;
        this.classroom = classroom;
    }


    public static void generateReport(List<StudentGrade> list, Classroom classroom) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("files/grade-reports.out"));

        writer.write("Maxim grade is: " + getMaxGrade(list) + ". Student name: " + nameBigGrade(list));
        writer.newLine();
        writer.write("Average grade is: " + averageGrade(list));
        writer.newLine();
        writer.write("Smallest grade is: " + getLowestGrade(list) + ". Student name: " + nameLowGrade(list));

        writer.flush();
        writer.close();
    }

    private static int getMaxGrade(List<StudentGrade> listOfStudents) {

        int maxGrade = 1;
        String studentName = "";
        for (StudentGrade s : listOfStudents) {
            if (s.getGrade() > maxGrade) {
                maxGrade = s.getGrade();
                studentName = s.getName();
            }
        }
        return maxGrade;
    }

    private static String nameBigGrade(List<StudentGrade> listOfStudents) {

        int maxGrade = 1;
        String studentName = "";
        for (StudentGrade s : listOfStudents) {
            if (s.getGrade() > maxGrade) {
                maxGrade = s.getGrade();
                studentName = s.getName();
            }
        }
        return studentName;
    }

    private static int averageGrade(List<StudentGrade> listOfStudents) {

        int averageGrade = 0;
        int counter = 0;
        for (StudentGrade s : listOfStudents) {
            if (s.getGrade() == 0) {
                continue;
            }
            averageGrade += s.getGrade();
            counter++;
        }
        averageGrade = averageGrade / counter;
        return averageGrade;
    }

    private static int getLowestGrade(List<StudentGrade> listOfStudents) {

        int lowestGrade = 10;
        String studentName = "";
        for (StudentGrade s : listOfStudents) {
            if (s.getGrade() < lowestGrade && s.getGrade() > 0) {
                lowestGrade = s.getGrade();
                studentName = s.getName();
            }
        }
        return lowestGrade;
    }

    private static String nameLowGrade(List<StudentGrade> listOfStudents) {

        int lowestGrade = 10;
        String studentName = "";
        for (StudentGrade s : listOfStudents) {
            if (s.getGrade() < lowestGrade && s.getGrade() > 0) {
                lowestGrade = s.getGrade();
                studentName = s.getName();
            }
        }
        return studentName;
    }
}
