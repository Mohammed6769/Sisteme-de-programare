package lab11;

public interface Subject {

    void subscribe(Observer observer);

    void unsubscribe(MediaInterested observer);

    void notifyObservers(String videoTitle);
}