package com.example.luckynumber;

import static android.content.ClipData.newIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btn =findViewById(R.id.button2);
        TextView text=findViewById(R.id.textView3);
        text.setText(" "+randomnum());
        Intent i =getIntent();
        String username=i.getStringExtra("name");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareData(username,randomnum());
            }
        });
    }

    public int randomnum(){
        Random random=new Random();
        int upperlimit=10;
        int randomNumber=random.nextInt(upperlimit);
        return randomNumber;
    }
    public void ShareData(String username,int randomnum){
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/bold");
        i.putExtra(Intent.EXTRA_SUBJECT,username+"got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,username+" Lucky number is "+randomnum);
        startActivity(Intent.createChooser(i,"CHOOSE A PLATFORM"));



    }

}