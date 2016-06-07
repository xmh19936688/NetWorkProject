package com.xmh.networkdemo.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xmh.networkdemo.R;
import com.xmh.networkdemo.ui.fragment.MainFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MainFragment fragment=new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_content,fragment,null).commit();
    }
}
