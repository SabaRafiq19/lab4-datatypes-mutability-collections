package CollectionsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class CourseManager {

    private List<String> subjects = new ArrayList<>(
            Arrays.asList("6.045", "6.005", "8.03", "6.813", "14.03")
    );

    public List<String> getSubjects() {
        return subjects;
    }

    // BROKEN version - will throw ConcurrentModificationException
    public void dropCourse6Broken() {
        for (String subject : subjects) {
            if (subject.startsWith("6.")) {
                subjects.remove(subject);  // modifying list while for-each iterates it
            }
        }
    }

    // FIXED version - safe removal with Iterator
    public void dropCourse6Fixed() {
        Iterator<String> iter = subjects.iterator();
        while (iter.hasNext()) {
            String subject = iter.next();
            if (subject.startsWith("6.")) {
                iter.remove();   // safe - Iterator knows about the removal
            }
        }
    }

    public static void main(String[] args) {
        CourseManager brokenDemo = new CourseManager();
        System.out.println("Original: " + brokenDemo.getSubjects());

        try {
            brokenDemo.dropCourse6Broken();
        } catch (ConcurrentModificationException e) {
            System.out.println("Caught expected exception: " + e);
        }

        CourseManager fixedDemo = new CourseManager();
        fixedDemo.dropCourse6Fixed();
        System.out.println("After dropCourse6Fixed(): " + fixedDemo.getSubjects());
    }
}