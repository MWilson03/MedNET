package com.michaelwilson.android.aca.mednet3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class NavigationActivity extends AppCompatActivity {

    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFirebaseAuth = FirebaseAuth.getInstance();

        Button angry_btn;
        Button button5;
        Button button6;
        Button button2;
        Button button3;
        Button button4;

        angry_btn = (Button) findViewById(R.id.angry_btn);
        angry_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MedHistoryActivity.class);
                startActivity(intent);


            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SurgHistoryActivity.class);
                startActivity(intent);

            }
        });

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), DrugAllergyActivity.class);
                startActivity(intent);

            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MedsTableActivity.class);
                startActivity(intent);

            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), InsuranceActivity.class);
                startActivity(intent);

            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), LicensesActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {

            mFirebaseAuth.signOut();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
