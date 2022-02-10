package dev.ogabek.java.model;

public class InfoPage {

    private String animation, title, text;

    public InfoPage(String animation, String title, String text) {
        this.animation = animation;
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getAnimation() {
        return animation;
    }

    public String getText() {
        return text;
    }
}
