package CollectionsLab;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentDirectory {

    private final Map<Integer, String> students = new HashMap<>();

    public void addStudent(int id, String name) {
        students.put(id, name);
    }

    public String getStudent(int id) {
        return students.get(id);
    }

    public Set<Integer> getAllIDs() {
        return Collections.unmodifiableSet(students.keySet());
    }

    public static void main(String[] args) {
        StudentDirectory dir = new StudentDirectory();
        dir.addStudent(1, "Ali");
        dir.addStudent(2, "Sara");
        dir.addStudent(3, "Bilal");

        Set<Integer> ids = dir.getAllIDs();
        System.out.println("Student IDs: " + ids);

        try {
            ids.add(4);
        } catch (UnsupportedOperationException e) {
            System.out.println("Caught expected exception: " + e);
        }

        System.out.println("IDs after attempted modification: " + ids);
    }
}