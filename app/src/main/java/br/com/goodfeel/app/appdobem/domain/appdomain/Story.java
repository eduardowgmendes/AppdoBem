package br.com.goodfeel.app.appdobem.domain.appdomain;

import android.widget.ImageView;
import android.widget.TextView;

import br.com.goodfeel.app.appdobem.domain.Quote;

public class Story {

    private String content, background;

    public Story(String content, String background) {
        this.content = content;
        this.background = background;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
