package it.me.tae.helloandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static String EXTRA_VALUE = "EXTRA_VALUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        TextView tvValue = (TextView) findViewById(R.id.tvValue);
        tvValue.setText("value : " + intent.getStringExtra(EXTRA_VALUE));
    }
}
