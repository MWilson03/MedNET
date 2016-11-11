package com.michaelwilson.android.aca.mednet3;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.michaelwilson.android.aca.mednet3.model.Surgery;

import java.util.ArrayList;

import static com.michaelwilson.android.aca.mednet3.R.id.procedure;


public class SurgHistoryActivity extends AppCompatActivity {

    Button mSaveButton;
    EditText mDate;
    EditText mLocation;
    EditText mProcedure;

    DatabaseReference myRef;

    private ListView mListView;
    private ArrayList<Surgery> mSurgeryList;

    private SurgeryAdapter mSurgeryAdapter;


    public static final String TAG = SurgHistoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.surg_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListView = (ListView) findViewById(R.id.surgeryListView);

        mSaveButton = (Button) findViewById(R.id.btnSave);
        mDate = (EditText) findViewById(R.id.date);
        mLocation = (EditText) findViewById(R.id.location);
        mProcedure = (EditText) findViewById(procedure);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("surgery");

        mSurgeryList = new ArrayList<>();

        mSurgeryAdapter = new SurgeryAdapter();
        mListView.setAdapter(mSurgeryAdapter);

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Surgery value = dataSnapshot.getValue(Surgery.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String procedure;
                String date;
                String location;

                procedure = mProcedure.getText().toString();
                location = mLocation.getText().toString();
                date = mDate.getText().toString();
                writeNewSurgery(procedure, date, location);

                mDate.setText("");
                mLocation.setText("");
                mProcedure.setText("");

            }
        });
    }

    private void writeNewSurgery(String procedure, String date, String location) {
        Surgery surgery = new Surgery(procedure, date, location);
        mSurgeryAdapter.addSurgery(surgery);

        myRef.child("surgery").setValue(surgery);
    }

    public class SurgeryAdapter extends BaseAdapter {


        // Declare and initialize a List that will hold notes
        ArrayList<Surgery> surgeryList = new ArrayList<Surgery>();

        public SurgeryAdapter() {
            surgeryList = mSurgeryList;
        } // end constructor

        // Get the number of notes in the list (ArrayList)
        @Override
        public int getCount() {
            return surgeryList.size();
        }

        // Get an item at a particular index (whichItem) in the array
        @Override
        public Surgery getItem(int whichItem) {
            return surgeryList.get(whichItem);
        }

        // Get the id of an item in the array
        @Override
        public long getItemId(int whichItem) {
            return whichItem;
        }

        /*
        The view object reference is an instance of the list item that is
        necessary to be displayed as evaluated by BaseAdapter, and whichItem is
        the position in the ArrayList of the Note object that needs to be
        displayed in it.
         */
        @Override
        public View getView(int whichItem, View view, ViewGroup viewGroup) {

            // Implement this method next
            // Has view been inflated already
            if (view == null) {

                // If not, do so here
                // First create a LayoutInflater
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                // Now instantiate view using inflater.inflate
                // using the listitem layout
                view = inflater.inflate(R.layout.listitem, viewGroup, false);
                // The false parameter is neccessary
                // because of the way that we want to use listitem

            }// End if

            // Grab a reference to all our TextView and ImageView widgets
            TextView date = (TextView) view.findViewById(R.id.prodecureDate);
            TextView location = (TextView) view.findViewById(R.id.procedureLocation);
            TextView procedure = (TextView) view.findViewById(R.id.prodecureName);

            // Hide any ImageView widgets that are not relevant
            Surgery tempSurgery = surgeryList.get(whichItem);


            // Add the text to the heading and description
            date.setText(tempSurgery.getDate());
            location.setText(tempSurgery.getLocation());
            procedure.setText(tempSurgery.getProcedure());

            return view;
        } // end getView()

        /*
        This method adds a new note to our array list.
        notifyDataSetChanged() will tell SurgeryAdapter that the data in
        noteList has changed and that the ListView might need to be
        updated.
         */
        public void addSurgery(Surgery n) {
            surgeryList.add(n);
            notifyDataSetChanged();
        }



    } // end SurgeryAdapter.class
        // endregion inner classes

}