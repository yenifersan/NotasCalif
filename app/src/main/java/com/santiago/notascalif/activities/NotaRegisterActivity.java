package com.santiago.notascalif.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.santiago.notascalif.R;
import com.santiago.notascalif.repositories.NotaRepository;

public class NotaRegisterActivity extends AppCompatActivity {

    private EditText titleInput;
    private EditText contentInput;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_register);

        titleInput = findViewById(R.id.title_input);
        contentInput = findViewById(R.id.content_input);
        registerButton = findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callRegister();
            }
        });
    }

    public void callRegister(){
        try {

            String title = titleInput.getText().toString();
            String content = contentInput.getText().toString();

            if(title.isEmpty() || content.isEmpty()){
                Toast.makeText(this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            NotaRepository.create(title, content);
            Toast.makeText(this, "Nota registrada", Toast.LENGTH_SHORT).show();

            finish();

        }catch (Exception e) {
            Toast.makeText(this, "ERROR" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}

