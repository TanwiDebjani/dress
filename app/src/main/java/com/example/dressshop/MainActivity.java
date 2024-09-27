package com.example.dressshop;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxCasual, checkBoxFormal;
    private RadioGroup radioGroupSize;
    private RatingBar ratingBar;
    private SeekBar seekBarQuantity;
    private TextView quantityText;
    private Switch switchDelivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkBoxCasual = findViewById(R.id.checkBoxCasual);
        checkBoxFormal = findViewById(R.id.checkBoxFormal);
        radioGroupSize = findViewById(R.id.radioGroupSize);
        ratingBar = findViewById(R.id.ratingBar);
        seekBarQuantity = findViewById(R.id.seekBarQuantity);
        quantityText = findViewById(R.id.quantityText);
        switchDelivery = findViewById(R.id.switchDelivery);
        Button buttonNext = findViewById(R.id.buttonNext);


        seekBarQuantity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                quantityText.setText("Quantity: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });


        buttonNext.setOnClickListener(v -> {
            StringBuilder orderSummary = new StringBuilder();

            orderSummary.append("Dress Type: ");
            if (checkBoxCasual.isChecked()) {
                orderSummary.append(checkBoxCasual.getText()).append(" ");
            }
            if (checkBoxFormal.isChecked()) {
                orderSummary.append(checkBoxFormal.getText()).append(" ");
            }

            int selectedSizeId = radioGroupSize.getCheckedRadioButtonId();
            if (selectedSizeId != -1) {
                RadioButton selectedSize = findViewById(selectedSizeId);
                orderSummary.append("\nSize: ").append(selectedSize.getText());
            }

            orderSummary.append("\nRating: ").append(ratingBar.getRating());
            orderSummary.append("\nQuantity: ").append(seekBarQuantity.getProgress());
            orderSummary.append("\nHome Delivery: ").append(switchDelivery.isChecked() ? "Yes" : "No");


            Intent intent = new Intent(MainActivity.this, OrderSummaryActivity.class);
            intent.putExtra("orderSummary", orderSummary.toString());
            startActivity(intent);
        });
    }
}



