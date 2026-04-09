import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner sc = new Scanner(System.in);
    private final List<Student> list = new ArrayList<>();
    private String id;
    private String name;
    private float mark;

    public void create() {
        int amount = readInt("Number of students you want to enter:");
        for (int i = 1; i <= amount; i++) {
            Student student = new Student();
            System.out.print("ID :");
            id = readLine();
            student.setId(id);
            System.out.print("Name student :" + i + ": ");
            name = readLine();
            student.setName(name);
            mark = readFloat("Mark: ");
            student.setMarks(mark);
            list.add(student);
        }
        System.out.print("Add student success!!!");
    }

    public void print(Student st) {
        System.out.println("Student id: " + st.getId());
        System.out.println("Student name: " + st.getName());
        System.out.println("Student mark: " + st.getMarks());
        System.out.println("Student academic ability: " + st.getAcademicAbility());
        System.out.println("");
    }

    public void printOut() {
        System.out.println("List student: ");
        for (Student st : list) {
            print(st);
        }
    }

    public void listMenu() {
        System.out.println("\t\t\t\t|----------------------------Menu-----------------------------------|");
        System.out.println("\t\t\t\t|  1. Enter a list of students                                      |");
        System.out.println("\t\t\t\t|  2. Print out list of students.                                   |");
        System.out.println("\t\t\t\t|  3. Find student by ID entered from the keyboard. (Linear Search) |");
        System.out.println("\t\t\t\t|  4. Find student by ID entered from the keyboard. (Binary Search) |");
        System.out.println("\t\t\t\t|  5. Delete student by ID                                          |");
        System.out.println("\t\t\t\t|  6. Sort student by mark. (Bubble Sort)                           |");
        System.out.println("\t\t\t\t|  7. Sort student by mark. (Insertion Sort)                        |");
        System.out.println("\t\t\t\t|  8. Sort student by mark. (Quick Sort)                            |");
        System.out.println("\t\t\t\t|  0. Exit                                                          |");
        System.out.println("\t\t\t\t|-------------------------------------------------------------------|");
    }

    public boolean repeatFunction() {
        do {
            int option = readInt("Press 1 to continue with function or 0 to Menu: ");
            if (option == 0) {
                return false;
            }
            if (option == 1) {
                return true;
            }
        } while (true);
    }

    public void menu() {
        while (true) {
            listMenu();
            try {
                System.out.println("");
                int function = readInt("Enter the program you want to choose: ");
                System.out.println("");
                switch (function) {
                    case 1:
                        do {
                            create();
                        } while (repeatFunction());
                        break;
                    case 2:
                        do {
                            printOut();
                        } while (repeatFunction());
                        break;
                    case 6:
                        do {
                            sortMarksBubble();
                        } while (repeatFunction());
                        break;
                    case 7:
                        do {
                            sortMarksInsertion();
                        } while (repeatFunction());
                        break;
                    case 8:
                        do {
                            sortMarksQuick();
                        } while (repeatFunction());
                        break;
                    case 0:
                        System.out.println("Exited. ");
                        return;
                    default:
                        System.out.println(" !!Wrong option !! .");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("");
                System.out.println(ex.getMessage());
                sc.nextLine();
            }
        }
    }

    public void sortMarksBubble() {
        while (true) {
            int chose = readInt("Ascending (1) or Descending (2) : ");
            if (chose == 1 || chose == 2) {
                Sort.bubbleSort(list, chose);
                break;
            }
        }
        System.out.println("List student after Sort:");
        printOut();
    }

    public void sortMarksInsertion() {
        while (true) {
            int chose = readInt("Ascending (1) or Descending (2) : ");
            if (chose == 1 || chose == 2) {
                Sort.insertionSort(list, chose);
                break;
            }
        }
        System.out.println("List student after Sort:");
        printOut();
    }

    public void sortMarksQuick() {
        while (true) {
            int chose = readInt("Ascending (1) or Descending (2) : ");
            if (chose == 1 || chose == 2) {
                Sort.quickSort(list, chose);
                break;
            }
        }
        System.out.println("List student after Sort:");
        printOut();
    }

    public static void main(String[] args) {
        Main menu = new Main();
        menu.menu();
    }

    private String readLine() {
        String line = sc.nextLine();
        while (line.isEmpty()) {
            line = sc.nextLine();
        }
        return line;
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a number.");
            }
        }
    }

    private float readFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Float.parseFloat(line);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
