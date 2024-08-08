package other.end;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Vector;

public class ScoreVector implements Serializable {
    @Serial
    private static final long serialVersionUID = 6503151799513328187L;

    private Vector<User> scores;

    public ScoreVector() {
        Vector<User> initial = FileHandler.readFromFile();
        this.scores = Objects.requireNonNullElseGet(initial, Vector::new);
    }

    public void addRecord(User user) {
        scores.add(user);
        FileHandler.writeToFile(this);
    }

    public static Vector<String> getHighScores() {
        Vector<User> users = FileHandler.readFromFile();
        if (users == null) {
            return null;
        }

        sortScores(users);
        Vector<String> result = new Vector<>();
        for (User u : users) {
            result.add(u.toString());
        }
        return result;
    }

    private static void sortScores(Vector<User> users) {
        Collections.sort(users, Comparator.comparingInt(User::getScore).reversed());
    }

    public Vector<User> getScores() {
        return scores;
    }

    @Override
    public String toString() {
        return "frames.ScoreVector{" +
                "scores=" + scores +
                '}';
    }
}
