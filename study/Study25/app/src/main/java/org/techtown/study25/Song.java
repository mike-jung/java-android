package org.techtown.study25;

import java.io.Serializable;

public class Song implements Serializable {
    String name;
    String singer;
    int imageId;

    public Song(String name, String singer, int imageId) {
        this.name = name;
        this.singer = singer;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
