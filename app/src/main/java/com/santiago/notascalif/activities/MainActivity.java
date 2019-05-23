package com.santiago.notascalif.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.santiago.notascalif.R;
import com.santiago.notascalif.adapters.NotaAdapter;
import com.santiago.notascalif.models.Nota;
import com.santiago.notascalif.models.User;
import com.santiago.notascalif.repositories.NotaRepository;
import com.santiago.notascalif.repositories.UserRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int REGISTER_FORM_REQUEST = 100;

    private RecyclerView notasList;

    private TextView fullnameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullnameText = findViewById(R.id.welcome_text);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        Long id = sp.getLong("id", 0);

        User user = UserRepository.load(id);

        if(user == null) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        fullnameText.setText("Bienvenido " + user.getFullname());

        // Configure ReciclerView
        notasList = (RecyclerView) findViewById(R.id.nota_list);
        notasList.setLayoutManager(new LinearLayoutManager(this));

        // Set Data Adapter to ReciclerView
        List<Nota> notas = NotaRepository.list();
        notasList.setAdapter(new NotaAdapter(notas));

    }

    public void callRegisterForm(View view){
        startActivityForResult(new Intent(this, NotaRegisterActivity.class), REGISTER_FORM_REQUEST);
    }

    // return from NoteRegisterActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data
        NotaAdapter adapter = (NotaAdapter)notasList.getAdapter();

        List<Nota> notas = NotaRepository.list();
        adapter.setNotas(notas);
        adapter.notifyDataSetChanged();

    }
}
