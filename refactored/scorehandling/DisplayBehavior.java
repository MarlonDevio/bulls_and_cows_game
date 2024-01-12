package bullscows.refactored.scorehandling;

import java.util.List;

public interface DisplayBehavior {
    void display();

    void display(String message);

    void display(int bull, int cow);

}
