package lab11;

import org.apache.commons.io.input.ObservableInputStream;

import java.io.IOException;
import java.util.ArrayList;

public abstract class YouTubeChannel implements Subject {

    private String channelName;

    private ArrayList<ObservableInputStream.Observer> observers;

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
        observers = new ArrayList<ObservableInputStream.Observer>();
    }

    @Override
    public void subscribe(ObservableInputStream.Observer observer) {
        observers.add(observer);
    }

    @Override
    public void subscribe(ObservableInputStream.Observer observer) {

    }

    @Override
    public void subscribe(Observer observer) {

    }

    @Override
    public void unsubscribe(MediaInterested observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String videoTitle) {

        for (ObservableInputStream.Observer observer : observers) {
            try {
                observer.data(Integer.parseInt(videoTitle));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void uploadVideo(String videoTitle) {

        System.out.println(channelName +
                " uploaded video: " + videoTitle);

        notifyObservers(videoTitle);
    }

    private class Observer {
    }
}