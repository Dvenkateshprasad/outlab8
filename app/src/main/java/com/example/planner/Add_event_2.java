package com.example.planner;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.planner.databinding.ActivityAddEvent2Binding;

public class Add_event_2 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityAddEvent2Binding binding;
    String[] Event_Type={"Study Plans", "Assignments", "Exams", "Lectures"};
    EditText et_title, et_description, et_time, et_date;
    String eventType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //binding = ActivityAddEvent2Binding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());

        //setSupportActionBar(binding.toolbar);

        setContentView(R.layout.activity_add_event2);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        //spin.setOnItemSelectedListener();
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                Event_Type);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        et_title = findViewById(R.id.edit_Title);
        et_description=findViewById(R.id.Description);
        et_date = findViewById(R.id.editTextDate);
        et_time = findViewById(R.id.editTextTime);
        eventType = spin.getSelectedItem().toString();

        Button btn_add_event = (Button) findViewById(R.id.button);
        btn_add_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                design Design;
                try {
                    Design = new design(-1, et_title.getText().toString(), et_date.getText().toString(), et_description.getText().toString(), et_time.getText().toString(), eventType);
                } catch (Exception e) {
                    //e.printStackTrace();
                    Design = new design(-1,"error", "error", "error", "error", "Study Plans");
                }
                DatabaseHelper databaseHelper = new DatabaseHelper(Add_event_2.this);
                boolean success = databaseHelper.addOne(Design);
                Toast.makeText(Add_event_2.this, "Success="+success, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_add_event2);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}