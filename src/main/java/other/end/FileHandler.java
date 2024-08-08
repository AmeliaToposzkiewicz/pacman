package other.end;

import java.io.*;
import java.util.Vector;

public class FileHandler {

    public static void writeToFile(ScoreVector scoreVector) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/main/java/scores.txt"));
            oos.writeObject(scoreVector);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    public static Vector<User> readFromFile() {
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("src/main/java/scores.txt"));
            ScoreVector scoreVector = (ScoreVector) ois.readObject();
            return scoreVector.getScores();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        return null;
    }
}
