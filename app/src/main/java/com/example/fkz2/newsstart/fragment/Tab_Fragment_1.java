package com.example.fkz2.newsstart.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.fkz2.newsstart.R;

/**
 * Created by Fkz on 17-5-16.
 */
public class Tab_Fragment_1 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewTab_1 = inflater.inflate(R.layout.tab_1, container, false);
        Click(viewTab_1);
        return viewTab_1;
    }

    private void Click(View view) {
        Button btnToast_1 = (Button) view.findViewById(R.id.button1_Toast);
        btnToast_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "第一个界面的Button", Toast.LENGTH_SHORT).show();
            }
        });
    }

}





















