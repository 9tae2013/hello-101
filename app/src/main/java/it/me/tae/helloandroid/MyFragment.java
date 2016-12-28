package it.me.tae.helloandroid;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.DosomethingService;
import com.example.HelloService;
import com.example.NameService;

import it.me.tae.helloandroid.presenter.MyPresenter;

import static it.me.tae.helloandroid.R.id.edtValue;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment implements MyPresenter.View {

    private MainActivity mainActivity;
    private MyPresenter presenter;

    private EditText edtValue;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        presenter = new MyPresenter();
        presenter.attachView(this);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        edtValue = (EditText) view.findViewById(R.id.edtValue);
        Button btnValue = (Button) view.findViewById(R.id.btnVaule);
        btnValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.calculate();
            }
        });
        return view;
    }

    @Override
    public String getInputTextToCalculate() {
        return edtValue.getText().toString();
    }

    @Override
    public void onCalculateSuccess(String result) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(result);
        builder.setTitle("Result");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                edtValue.setText("");
            }
        });
        builder.show();
    }

    @Override
    public void onCalculateFail(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }
}
