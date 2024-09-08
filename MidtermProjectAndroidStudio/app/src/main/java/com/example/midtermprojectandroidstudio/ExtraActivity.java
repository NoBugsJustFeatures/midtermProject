package com.example.midtermprojectandroidstudio;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class ExtraActivity extends AppCompatActivity {

    private EditText fromInput, toInput, dateInput;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cities);

        // Find views by ID
        fromInput = findViewById(R.id.fromInput);
        toInput = findViewById(R.id.toInput);
        dateInput = findViewById(R.id.dateInput);
        searchButton = findViewById(R.id.searchButton);

        // Set click listener for date input to show DatePickerDialog
        dateInput.setOnClickListener(v -> showDatePickerDialog());

        // Set click listener for search button
        searchButton.setOnClickListener(v -> {
            String from = fromInput.getText().toString();
            String to = toInput.getText().toString();
            String selectedDate = dateInput.getText().toString();

            if (!from.isEmpty() && !to.isEmpty() && !selectedDate.isEmpty()) {
                // Display a toast message (replace with actual search logic)
                Toast.makeText(ExtraActivity.this, "Searching flights from " + from + " to " + to + " on " + selectedDate, Toast.LENGTH_SHORT).show();
            } else {
                // Show error if any field is empty
                Toast.makeText(ExtraActivity.this, "Please enter all the required fields.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDatePickerDialog() {
        // Get the current date
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create and show the DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                ExtraActivity.this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    // Date format: MM/DD/YYYY
                    String selectedDate = (selectedMonth + 1) + "/" + selectedDay + "/" + selectedYear;
                    dateInput.setText(selectedDate);
                },
                year, month, day);
        datePickerDialog.show();
    }
}
