import javax.swing.*;
import java.io.*;

public class GroupFileStorage {


    public void saveGroupToCSV(Group gr) {
        File file  = new File("group info.txt");
        try (FileWriter fw = new FileWriter(file, true)) {
            for (Student student : gr.getStudents()) {
                fw.append(student.toCSVString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Group loadGroupFromCSV(File file) throws IOException {
        Group group = new Group(file.getName().substring(0,
                file.getName().lastIndexOf(".")));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                new StudentCreator(group, new Student().fromCSVString(line));
            }
        } catch (IOException e) {
            throw e;
        }
        return group;
    }

    public File findFileByGroupName(String groupName, File workFolder) {
        File[] files = workFolder.listFiles((file, name) ->
                file.getName().endsWith(".txt") &&
                        file.getName().contains(groupName));
        if (files.length != 1) JOptionPane.showMessageDialog(null,
                "For some reasons there are several appropriate file, " +
                        "check request one more time");
        return files[0];
    }
}
