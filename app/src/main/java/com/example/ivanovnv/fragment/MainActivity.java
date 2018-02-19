package com.example.ivanovnv.fragment;



import android.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = findViewById(R.id.button1);
        mButton1.setOnClickListener(this);
        mButton2 = findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
        mButton3 = findViewById(R.id.button3);
        mButton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                switchFragment("one",R.color.red);
                break;
            case R.id.button2:
                switchFragment("two",R.color.green);
                break;
            case R.id.button3:
                switchFragment("three",R.color.blue);
                break;
        }
    }

    void switchFragment (String name, int color) {
        Fragment fragment;
        fragment = getFragmentManager().findFragmentByTag(name);
        if(fragment== null) {
            fragment = SampleFragment.newInstance(name, ContextCompat.getColor(this,color));
            getFragmentManager().beginTransaction()
            .replace(R.id.container,fragment,name)
            .commit();
        }
        else{
            Toast.makeText(this,"Не меняем",Toast.LENGTH_SHORT).show();
        }


    }
}
