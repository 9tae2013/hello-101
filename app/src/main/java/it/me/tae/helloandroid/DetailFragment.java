package it.me.tae.helloandroid;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    private static String ARGS_VALUE = "ARGS_VALUE";

    public static DetailFragment newInstance(String value) {
        Bundle args = new Bundle();
        args.putString(ARGS_VALUE, value);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView tvValue = (TextView) view.findViewById(R.id.tvValue);
        tvValue.setText("value : " + getArguments().getString(ARGS_VALUE));
        return view;
    }
}
