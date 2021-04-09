package cat.itb.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button buttonBack;
    private TextView textViewTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        buttonBack = findViewById(R.id.buttonBackSecondActivity);
        textViewTitle = findViewById(R.id.textViewWelcomeBack);

        String username = getIntent().getExtras().getString("username");
        String text = getString(R.string.welcome_back , username);
        textViewTitle.setText(text);


        buttonBack.setOnClickListener(v -> finish());
    }
}