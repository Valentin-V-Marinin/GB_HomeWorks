package exceptions_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileControl {

    final String FILE_PATH = "C:/GB_home_works";
    public void addFile(String[] data, String path){
        if (path.length() == 0) path = FILE_PATH;
        File dir = new File(path);
        if (!dir.exists()) dir.mkdirs();
        String filename = data[0] + ".txt";
        File file = new File(path, filename);
        String str = "";
        for (int i = 0; i < data.length; i++) {
            str = str + data[i] + " ";
        }

        try {
            if (file.exists()) {
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(str + "\n");
                fileWriter.close();
            } else {
                FileWriter fileWriter = new FileWriter(file, false);
                fileWriter.write(str + "\n");
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            for (StackTraceElement n: e.getStackTrace()) {
                System.out.println(n);
            }
        }
    }
}
