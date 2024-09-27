package com.example.dressshop;



import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OrderSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);


        String orderSummary = getIntent().getStringExtra("orderSummary");


        TextView textViewOrderSummary = findViewById(R.id.textViewOrderSummary);
        textViewOrderSummary.setText(orderSummary);
    }
}
