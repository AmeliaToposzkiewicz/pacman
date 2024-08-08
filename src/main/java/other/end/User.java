package other.end;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private int score;

    public User(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return username + ' ' + score;
    }
}
