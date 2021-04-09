package cat.itb.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private MaterialButton button;
    private EditText editTextUsername, editTextPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.theButton);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPass = findViewById(R.id.editTextPassword);

        button.setOnClickListener(v -> {
            button.setText(R.string.logged);
            Intent i = new Intent(this, SecondActivity.class);
            i.putExtra("username", editTextUsername.getText().toString());
            startActivity(i);
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        editTextUsername.setText("");
        editTextPass.setText("");
    }
}