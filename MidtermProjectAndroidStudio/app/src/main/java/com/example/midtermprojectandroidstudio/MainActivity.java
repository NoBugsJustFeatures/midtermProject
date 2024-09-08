package com.example.midtermprojectandroidstudio;

import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText flightNumberInput, fromInput, toInput, dateInput;
    private Button searchButton;
    private RadioGroup searchByGroup;
    private RadioButton flightNumberRadio, citiesRadio;
    private View flightNumberLayout, citiesLayout;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate called");

        // Find views by ID
        flightNumberInput = findViewById(R.id.flightNumberInput);
        fromInput = findViewById(R.id.fromInput);
        toInput = findViewById(R.id.toInput);
        dateInput = findViewById(R.id.dateInput);
        searchButton = findViewById(R.id.searchButton);
        searchByGroup = findViewById(R.id.searchByGroup);
        flightNumberRadio = findViewById(R.id.flightNumberRadio);
        citiesRadio = findViewById(R.id.citiesRadio);
        flightNumberLayout = findViewById(R.id.flightNumberLayout);
        citiesLayout = findViewById(R.id.citiesLayout);

        // Set click listener for radio buttons
        searchByGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.flightNumberRadio) {
                flightNumberLayout.setVisibility(View.VISIBLE);
                citiesLayout.setVisibility(View.GONE);
            } else if (checkedId == R.id.citiesRadio) {
                flightNumberLayout.setVisibility(View.GONE);
                citiesLayout.setVisibility(View.VISIBLE);
            }
        });

        // Set click listener on the search button
        searchButton.setOnClickListener(v -> {
            if (flightNumberRadio.isChecked()) {
                searchByFlightNumber();
            } else {
                searchByCities();
            }
        });

        // Set up date picker dialog
        setupDatePicker(dateInput);
    }

    private void searchByFlightNumber() {
        String flightNumber = flightNumberInput.getText().toString();
        String selectedDate = dateInput.getText().toString();

        if (!flightNumber.isEmpty() && !selectedDate.isEmpty()) {
            Toast.makeText(MainActivity.this, "Searching for Flight " + flightNumber + " on " + selectedDate, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Please enter both flight number and date.", Toast.LENGTH_SHORT).show();
        }
    }

    private void searchByCities() {
        String from = fromInput.getText().toString();
        String to = toInput.getText().toString();
        String selectedDate = dateInput.getText().toString();

        if (!from.isEmpty() && !to.isEmpty() && !selectedDate.isEmpty()) {
            Toast.makeText(MainActivity.this, "Searching flights from " + from + " to " + to + " on " + selectedDate, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Please enter all the required fields.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setupDatePicker(EditText dateEditText) {
        dateEditText.setOnClickListener(v -> {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        String selectedDate = (selectedMonth + 1) + "/" + selectedDay + "/" + selectedYear;
                        dateEditText.setText(selectedDate);
                    },
                    year, month, day);
            datePickerDialog.show();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy called");
    }

}
