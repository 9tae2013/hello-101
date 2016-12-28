package it.me.tae.helloandroid.presenter;


import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.DecimalFormat;

public class MyPresenter {
    private DecimalFormat format;
    private View view;

    public interface View {
        String getInputTextToCalculate();
        void onCalculateSuccess(String result);
        void onCalculateFail(String msg);
    }

    public MyPresenter() {
            format = new DecimalFormat("#,###.##;- #");
    }

    public void attachView(View view) {
        this.view = view;
    }

    public void calculate() {
        String text = view.getInputTextToCalculate();
        if (text != null && text.length() > 0) {
            Expression e = new ExpressionBuilder(text).build();
            view.onCalculateSuccess(format.format(e.evaluate()));
        } else {
            view.onCalculateFail("Text not be empty");
        }
    }
}
