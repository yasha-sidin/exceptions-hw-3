package Logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserSaver {
    final static String PATH_TO_SAVE = "src/main/resources/";
    public static boolean saveUserToFile(User user) throws IOException {
        String filePath;
        try {
            filePath = PATH_TO_SAVE + user.getSecondName() + ".txt";
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            throw new RuntimeException("Exception in creating new file. " + e.getMessage());
        }
        try (FileWriter fw = new FileWriter(filePath, true)){
            fw.write(user.toString() + "\n");
        } catch (Exception e) {
            throw new RuntimeException("Exception in writing user to file. " + e.getMessage());
        }
        return true;
    }
}
