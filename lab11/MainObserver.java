package lab11;

public abstract class MainObserver {

    public static void main(String[] args) {

        YouTubeChannel channel =
                new YouTubeChannel("TechChannel") {
                    @Override
                    public void subscribe(Observer observer) {

                    }
                };

        MediaInterested person1 =
                new MediaInterested("Alex");

        MediaInterested person2 =
                new MediaInterested("Maria");

        // adaug observatori
        channel.notifyObservers(person1.toString());
        channel.notifyObservers(person2.toString());

        // primul upload -> 2 observatori
        channel.uploadVideo("Java Observer Pattern");

        System.out.println();

        // scot un observator
        channel.unsubscribe(person2);

        // al doilea upload -> 1 observator
        channel.uploadVideo("Decorator Pattern");
    }

    public abstract void update(String videoTitle);
}