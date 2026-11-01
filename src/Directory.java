import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Directory implements FileSystemElement {
    private final String name;
    private final List<FileSystemElement> elements = new ArrayList<>();

    public Directory(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Directory name cannot be null or empty.");
        }
        this.name = name;
    }

    public void addElement(FileSystemElement element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null.");
        }
        elements.add(element);
    }

    public String getName() {
        return name;
    }

    public List<FileSystemElement> getElements() {
        return Collections.unmodifiableList(elements);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("Visitor cannot be null.");
        }
        visitor.visitDirectory(this);
    }
}