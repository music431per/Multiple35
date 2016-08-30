package net.freeeeedom.multiple35;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    private TextView scoreTextView;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        scoreTextView = (TextView) findViewById(R.id.result);
        scoreTextView.setText("score : " + score);

    }

    public void clickAgain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void clickStart(View view) {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();
    }
}
