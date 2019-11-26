package com.example.intentusedbybistu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonFirst=(Button)findViewById(R.id.FirstButton);
        Button buttonFirst2=(Button)findViewById(R.id.FirstIntentButton);
        buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFirst1=new Intent("com.example.intentusedbybistu.THIRD_LAYOUT");
                intentFirst1.addCategory("android.intent.category.MY_CATEGORY");
                intentFirst1.putExtra("First_date","这里是第一个activity传入界面三的数据");
                startActivityForResult(intentFirst1,1);
            }
        });
        buttonFirst2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentFirst2=new Intent("com.example.intentusedbybistu.ACTION_START");
                intentFirst2.putExtra("First_date","这里是第一个activity传入界面二的数据");
                startActivityForResult(intentFirst2,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    textView=(TextView)findViewById(R.id.textView);
                    String out2=data.getStringExtra("data_return");
                    textView.setText(out2);
                }
                break;
            default:
        }
    }
}
