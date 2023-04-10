import java.util.ArrayList;
import java.util.List;

public class Classroom {


    private List<StudentGrade> list;

    public Classroom(List<StudentGrade> list) {
        this.list = list;
    }

    public static List<Integer> getGradesForDiscipline(List<StudentGrade> listOfStudents, String discipline) {

        List<Integer> gradeList = new ArrayList<>();
        for (StudentGrade s : listOfStudents) {
            if (s.getDiscipline().equals(discipline)) {
                gradeList.add(s.getGrade());
            }
        }
        System.out.println("Here are all the grades for " + discipline + ": " + gradeList);
        return gradeList;
    }

    public static List<Integer> getGradesForStudent(List<StudentGrade> listOfStudents, String student) {

        List<Integer> gradeList = new ArrayList<>();

        for (StudentGrade s : listOfStudents) {
            if (s.getName().equals(student)) {
                gradeList.add(s.getGrade());
            }
        }
        System.out.println(student + " has the following grade -> " + gradeList);
        return gradeList;
    }

    public static String getMaxGrade(List<StudentGrade> listOfStudents, String discipline) {

        int maxGrade = 1;
        String studentName = "";
        for (StudentGrade s : listOfStudents) {
            if (s.getDiscipline().equals(discipline)) {
                maxGrade = s.getGrade();
                studentName = s.getName();
            }
        }
        return "The biggest grade at " + discipline + " is " + maxGrade + "(" + studentName + ")";
    }

    public static int getMaxGrade(List<StudentGrade> listOfStudents) {

        int maxGrade = 1;
        for (StudentGrade s : listOfStudents) {
            if (s.getGrade() > maxGrade) {
                maxGrade = s.getGrade();
            }
        }

        System.out.println("The biggest grade is: " + maxGrade);
        return maxGrade;
    }

    public static int getAverageGrade(List<StudentGrade> listOfStudents, String discipline) {

        int averageGrade = 0;
        int counter = 0;
        for (StudentGrade s : listOfStudents) {
            if (s.getGrade() == 0) { // nota 0 este atribuita acelor studenti din grades.txt carora nu li s-a oferit
                continue;            // o nota in cadrul grades.txt, astfel ei sunt ignorati prin aceasta conditie
            }
            if (s.getDiscipline().equals(discipline)) {
                averageGrade += s.getGrade();
                counter++;
            }
        }
        averageGrade = averageGrade / counter;
        System.out.println("The average grade at " + discipline + " is " + averageGrade);
        return averageGrade;
    }

    public static int getWorstGrade(List<StudentGrade> listOfStudents, String discipline) {

        int worstGrade = 10;
        for (StudentGrade s : listOfStudents) {
            if (s.getDiscipline().equals(discipline)) {
                if (s.getGrade() < worstGrade && s.getGrade() > 0) { //conditia s.getGrade() > 0 este folosita pentru
                    worstGrade = s.getGrade();                       //a ignora notele de 0 atribuite in mod automat
                }                                                    // elevilor carora nu li s-a oferit o nota in cadrul grades.txt
            }
        }
        System.out.println("The smallest grade at " + discipline + " is: " + worstGrade);
        return worstGrade;
    }

    public List<StudentGrade> getList() {
        return list;
    }

    public void setList(List<StudentGrade> list) {
        this.list = list;
    }
}
