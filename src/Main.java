public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        File file1 = new File("report.pdf", 120);
        File file2 = new File("photo.png", 350);

        Directory subDir = new Directory("projects");
        File file3 = new File("java_report.docx", 80);
        File file4 = new File("notes.txt", 10);

        subDir.addElement(file3);
        subDir.addElement(file4);

        root.addElement(file1);
        root.addElement(file2);
        root.addElement(subDir);

        System.out.println("--- Running SizeCalculatorVisitor ---");
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " KB");

        System.out.println("\n--- Running SearchVisitor (keyword: 'report') ---");
        SearchVisitor searchVisitor = new SearchVisitor("report");
        root.accept(searchVisitor);
        for (File file : searchVisitor.getFoundFiles()) {
            System.out.println("Found: " + file.getName() + " (" + file.getSize() + " KB)");
        }
    }
}