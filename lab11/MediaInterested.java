package lab11;

public class MediaInterested extends MainObserver {

    private String name;

    public MediaInterested(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(name +
                " received notification about new video: "
                + videoTitle);
    }
}