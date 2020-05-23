package com.example.androidimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch swtAgree;
    RadioGroup rGroup1;
    RadioButton rdoOreo, rdoPie, rdoQ;
    Button btnOK, btnFin, btnHome;
    ImageView imgAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드 버전 사진보기");

        text1 = (TextView) findViewById(R.id.Text1);
        swtAgree = (Switch) findViewById(R.id.SwtAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.RGroup1);
        RadioButton radioArray[] = new RadioButton[3];

        radioArray[0] = (RadioButton) findViewById(R.id.RdoOreo);
        radioArray[1] = (RadioButton) findViewById(R.id.RdoPie);
        radioArray[2] = (RadioButton) findViewById(R.id.RdoQ);

//        rdoOreo = (RadioButton) findViewById(R.id.RdoOreo);
//        rdoPie = (RadioButton) findViewById(R.id.RdoPie);
//        rdoQ = (RadioButton) findViewById(R.id.RdoQ);


        imgAndroid = (ImageView) findViewById(R.id.ImgAndroid);

        btnFin = (Button) findViewById(R.id.BtnFin);
        btnHome = (Button) findViewById(R.id.BtnHome);

        swtAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (swtAgree.isChecked() == true) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    imgAndroid.setVisibility(View.VISIBLE);
                    btnHome.setVisibility(View.VISIBLE);
                    btnFin.setVisibility(View.VISIBLE);
                } else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    imgAndroid.setVisibility(View.INVISIBLE);
                    btnHome.setVisibility(View.INVISIBLE);
                    btnFin.setVisibility(View.INVISIBLE);
                }
            }
        });
        final int draw[] = {R.drawable.oreo, R.drawable.pie, R.drawable.q10};

        for (int i =0; i<radioArray.length; i++) {
            final int index;
            index=i;
            radioArray[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgAndroid.setImageResource(draw[index]);
                }
            });
        }
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setVisibility(View.INVISIBLE);
                rGroup1.setVisibility(View.INVISIBLE);
                imgAndroid.setVisibility(View.INVISIBLE);
                btnFin.setVisibility(View.INVISIBLE);
                btnHome.setVisibility(View.INVISIBLE);

                rGroup1.clearCheck();
                swtAgree.setChecked(false);
            }
        });
        btnFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
