package satlaa.desijewellery.utils;

import org.parceler.Parcel;

import java.io.Serializable;

@Parcel
public class Photos implements Serializable {
    public String url;
    public String weight;
    public String title;
    public String thumb;
    public String date;
    public String hit;

    public Photos() {

    }

    public Photos(String url, String weight, String title, String thumb, String date, String hit) {
        this.url = url;
        this.weight = weight;
        this.title = title;
        this.thumb = thumb;
        this.date = date;
        this.date = hit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }

    public String getHit() {
        return hit;
    }



}

