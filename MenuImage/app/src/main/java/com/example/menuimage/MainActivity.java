package com.example.menuimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtAngle;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사진 회전시키기");

        edtAngle = (EditText) findViewById(R.id.edtAngle);
        imageView1 =(ImageView) findViewById(R.id.Img);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0,1,0,"그림회전");
        menu.add(0,2,0,"한라산");
        menu.add(0,3,0,"추자도");
        menu.add(0,4,0,"범섬");

//        SubMenu sMenu = menu.addSubMenu("버튼변경 >>" );
//        sMenu.add(0,4,0, "버튼 45도 회전");
//        sMenu.add(0,5,0, "버튼 2배 확대");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 1:
                imageView1.setRotation(Float.parseFloat(edtAngle.getText().toString()));
                return true;
            case 2:
                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                imageView1.setImageResource(R.drawable.jeju02);
                break;
            case 3:
                imageView1.setImageResource(R.drawable.jeju6);
                break;
            case 4:
                imageView1.setImageResource(R.drawable.jeju14);
                break;
        }
        return false;
    }
}
