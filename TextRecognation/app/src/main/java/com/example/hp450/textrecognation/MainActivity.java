package com.example.hp450.textrecognation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button buttonProcess;
    TextView textView;
    Bitmap bitmap;

    public void prossessButton(View view)
    {
        TextRecognizer textRecognizer =  new TextRecognizer.Builder(getApplicationContext()).build();
        bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.helloworld);
        imageView.setImageBitmap(bitmap);
        if(!textRecognizer.isOperational())
        {
            Toast.makeText(MainActivity.this, "Invalid Content", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Frame frame = new Frame.Builder().setBitmap(bitmap).build();
            SparseArray<TextBlock> items = textRecognizer.detect(frame);
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < items.size(); i++)
            {
                TextBlock item = items.valueAt(i);
                stringBuilder.append(item.getValue());
                stringBuilder.append("\n");
            }
            textView.setText(stringBuilder.toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        buttonProcess = findViewById(R.id.button);
        textView = findViewById(R.id.textView);



    }
}
