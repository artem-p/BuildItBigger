package ru.artempugachev.jokesactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {
    public static final String JOKE_EXTRA = "joke_extra";
    private TextView jokeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        jokeText = (TextView) findViewById(R.id.joke_text);

        fillJoke();
    }

    private void fillJoke() {
        Intent intent = getIntent();

        if (intent != null && intent.hasExtra(JOKE_EXTRA)) {
            String joke = intent.getStringExtra(JOKE_EXTRA);
            jokeText.setText(joke);
        }
    }
}
