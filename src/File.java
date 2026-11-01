public class File implements FileSystemElement {
    private final String name;
    private final int size;

    public File(String name, int size) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("File name cannot be null or empty.");
        }
        if (size < 0) {
            throw new IllegalArgumentException("File size cannot be negative.");
        }
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("Visitor cannot be null.");
        }
        visitor.visitFile(this);
    }
}