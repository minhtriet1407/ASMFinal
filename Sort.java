import java.util.List;

public class Sort {
    public static void bubbleSort(List<Student> list, int criteria) {
        int n = list.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (criteria == 1) {
                    if (list.get(j).getMarks() > list.get(j + 1).getMarks()) {
                        Student temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                        swapped = true;
                    }
                } else if (criteria == 2) {
                    if (list.get(j).getMarks() < list.get(j + 1).getMarks()) {
                        Student temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                        swapped = true;
                    }
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void insertionSort(List<Student> list, int criteria) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            Student key = list.get(i);
            int j = i - 1;
            if (criteria == 1) {
                while (j >= 0 && list.get(j).getMarks() > key.getMarks()) {
                    list.set(j + 1, list.get(j));
                    j--;
                }
            } else if (criteria == 2) {
                while (j >= 0 && list.get(j).getMarks() < key.getMarks()) {
                    list.set(j + 1, list.get(j));
                    j--;
                }
            }
            list.set(j + 1, key);
        }
    }

    public static void quickSort(List<Student> list, int criteria) {
        if (list == null || list.size() < 2) {
            return;
        }
        quickSort(list, 0, list.size() - 1, criteria);
    }

    private static void quickSort(List<Student> list, int low, int high, int criteria) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, criteria);
            quickSort(list, low, pivotIndex - 1, criteria);
            quickSort(list, pivotIndex + 1, high, criteria);
        }
    }

    private static int partition(List<Student> list, int low, int high, int criteria) {
        Student pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(list.get(j), pivot, criteria)) {
                i++;
                Student temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        Student temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }

    private static boolean compare(Student a, Student b, int criteria) {
        if (criteria == 1) {
            return a.getMarks() <= b.getMarks();
        }
        return a.getMarks() >= b.getMarks();
    }
}
