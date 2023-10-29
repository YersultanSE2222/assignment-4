import java.util.ArrayList;
import java.util.List;

// Observer Pattern

interface FootballObserver {
    void update(String message);
}

class Fan implements FootballObserver {
    private String name;

    public Fan(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received an update: " + message);
    }
}

class FootballPlayer {
    private List<FootballObserver> observers = new ArrayList<>();
    private String name;

    public FootballPlayer(String name) {
        this.name = name;
    }

    public void registerObserver(FootballObserver observer) {
        observers.add(observer);
    }

    public void scoreGoal() {
        String message = name + " scored a goal!";
        System.out.println(message);
        notifyObservers(message);
    }

    private void notifyObservers(String message) {
        for (FootballObserver observer : observers) {
            observer.update(message);
        }
    }
}

// Factory Pattern

class FanFactory {
    public static Fan createFan(String name) {
        return new Fan(name);
    }
}

class FootballMatch {
    public static void main(String[] args) {
        FootballPlayer player1 = new FootballPlayer("Player 1");
        Fan fan1 = FanFactory.createFan("Fan 1");

        player1.registerObserver(fan1);
        player1.scoreGoal();
    }
}