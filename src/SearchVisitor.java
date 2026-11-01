import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private final String keyword;
    private final List<File> foundFiles = new ArrayList<>();

    public SearchVisitor(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            throw new IllegalArgumentException("Search keyword cannot be null or empty.");
        }
        this.keyword = keyword;
    }

    @Override
    public void visitFile(File file) {
        if (file.getName().contains(keyword)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visitDirectory(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }

    public List<File> getFoundFiles() {
        return Collections.unmodifiableList(foundFiles);
    }
}