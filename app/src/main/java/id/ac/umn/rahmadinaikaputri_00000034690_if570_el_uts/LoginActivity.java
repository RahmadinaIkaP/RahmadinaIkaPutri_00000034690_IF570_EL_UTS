package id.ac.umn.rahmadinaikaputri_00000034690_if570_el_uts;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText nameLogin;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nameLogin = (EditText) findViewById(R.id.loginNama);
        nextBtn = findViewById(R.id.btnNext);

        // Validate
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = nameLogin.getText().toString();

                if(username.isEmpty() == false){
                    Toast.makeText(v.getContext(), "Selamat Datang, " +
                            username, Toast.LENGTH_SHORT).show();
                    Intent listIntent = new Intent(LoginActivity.this, LibraryActivity.class);
                    listIntent.putExtra("namaUser", username);
                    startActivity(listIntent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                else{
                    nameLogin.setError("Harap diisi yaa");
                }
            }
        });
    }
    //Untuk transisi
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}