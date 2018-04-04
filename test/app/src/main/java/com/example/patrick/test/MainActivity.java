package com.example.patrick.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText edittext;
    // String pswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext = findViewById(R.id.editText);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pswd = edittext.getText().toString();
                Toast.makeText(MainActivity.this, pswd, Toast.LENGTH_SHORT).show(); // toast is output on screen
                if(pswd.equals("test")) {

                    Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                    MainActivity.this.startActivity(myIntent);
                }
            }

        });



    }
}
