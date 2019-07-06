package br.com.goodfeel.app.appdobem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import br.com.goodfeel.app.appdobem.domain.appdomain.Story;

public class Rendered_Story_Activity extends AppCompatActivity {

    private ImageView renderedStory;
    private Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendered__story_);

        story = (Story) getIntent().getSerializableExtra("rendered_story");

        renderedStory = findViewById(R.id.story_layout_render);
        //renderedStory.setImageBitmap(story.getBitmap());
    }
}
