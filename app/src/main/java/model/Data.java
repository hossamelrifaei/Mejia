package model;

import java.util.ArrayList;

/**
 * Created by Hossam on 4/6/2016.
 */
public class Data {
    private ArrayList<Video> videos;
    private int total;

    public Data() {
        this.videos = new ArrayList<Video>();
    }


    public ArrayList<Video> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
