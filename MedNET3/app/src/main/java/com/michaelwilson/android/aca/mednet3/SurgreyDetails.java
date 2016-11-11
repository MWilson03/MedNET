/*import com.michaelwilson.android.aca.mednet3.model.Surgery;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.michaelwilson.android.aca.mednet3.R;
import com.michaelwilson.android.aca.mednet3.model.Surgery;

/package com.michaelwilson.android.aca.mednet3;

public class DialogShowNote extends DialogFragment {

    // Member Variables
    private Surgery mSurgery;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        /*
        1. Declare an initialize an instance of AlertDialog.Builder
        2. Declare and initialize LayoutInflater and then use it to
           create a View object that contains the layout for the dialog.
           In this case, it is the layout from dialog_show_note.xml
        3. Get a reference to each of the UI widgets and set the text
           properties on txtTitle and textDescription from the appropriate
           member variables of mNote, which was initialized in sendNoteSelected.
         */
/*
        // 1.
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // 2.
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.surgery_details, null);

        // 3.
        TextView date = (TextView) dialogView.findViewById(R.id.prodecureDate);
        TextView location = (TextView) dialogView.findViewById(R.id.procedureLocation);
        TextView procedure = (TextView) dialogView.findViewById(R.id.prodecureName);

        date.setText(mSurgery.getDate());
        location.setText(mSurgery.getLocation());
        procedure.setText(mSurgery.getProcedure());




        /*
        This next block of code will listen for a click on the button, and dismiss (close)
        the dialog window when the user clicks.  This is done with an anonymous class
        in the onClick method.
         */

        /*Button btnOK = (Button) dialogView.findViewById(R.id.btnOK);

        builder.setView(dialogView).setTitle("Your Note");

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return builder.create();
    }


    /*
    This method will be called by MainActivity and it will
    pass in the Note object the user has clicked on.
     */
    /*public void sendNoteSelected(Surgery noteSelected) {
        mSurgery = noteSelected;
    }
}*/