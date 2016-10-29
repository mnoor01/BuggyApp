package nyc.c4q.ramonaharrison.buggyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    EditText wordInput;
    Button nextButton, analyzeButton;
    TextView resultDisplay;

    WordAnalyzer wordAnalyzer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        wordAnalyzer = new WordAnalyzer();

        nextButton = (Button) findViewById(R.id.button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
                startActivity(intent);
            }
        });

        wordInput = (EditText) findViewById(R.id.word_input);
        resultDisplay = (TextView) findViewById(R.id.results);

        analyzeButton = (Button) findViewById(R.id.analyze_button);
        analyzeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = wordInput.getText().toString();
                char result = wordAnalyzer.firstMultipleCharacter(word);

                if (result == 0) {
                    resultDisplay.setText("No multiple character.");
                } else {
                    resultDisplay.setText("First multiple character = " + result);
                }
            }
        });
    }
}
