package com.example.abdullah.newgobutton;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;
public class MainActivity extends AppCompatActivity {

    CircularProgressButton circularProgressButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    circularProgressButton=(CircularProgressButton) findViewById(R.id.download);
    circularProgressButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AsyncTask<String,String,String> demo=new AsyncTask<String, String, String>() {
                @Override
                protected String doInBackground(String... voids) {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    return "done";
                }


                @Override
                protected void onPostExecute(String s) {
                    if(s.equals("done"))
                    {
                        Toast.makeText(MainActivity.this,"Download Done",Toast.LENGTH_SHORT).show();
                        circularProgressButton.doneLoadingAnimation(Color.parseColor("#333639"),BitmapFactory.decodeResource(getResources(),R.drawable.ic_done_white_48dp));
                    }
                }
            };
            circularProgressButton.startAnimation();
            demo.execute();

        }
    });

    }

}
