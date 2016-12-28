package it.me.tae.helloandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.NameService;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("=== onCreate()");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MyFragment())
                .commit();







        /*DecimalFormat format = new DecimalFormat("#,###.##;- #");
        Expression e = new ExpressionBuilder("3 * 2.4").build();
        System.out.println(format.format(e.evaluate()) + " oooooooooooooo");*/
    }

    public void onClickValue(String value) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, DetailFragment.newInstance(value))
                .addToBackStack(null)
                .commit();
    }
}
