import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user, pwd;
    Button login;
    String u = "Orca";
    String p = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.username);
        pwd = findViewById(R.id.password);
        login = findViewById(R.id.loginButton);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.loginButton) {
            String a = user.getText().toString();
            String b = pwd.getText().toString();
            if (a.equals(u) && b.equals(p)) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Invalid Login", Toast.LENGTH_LONG).show();
            }
        }
    }
}
