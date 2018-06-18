package alialmasli.com.wallpapermanager;

import android.Manifest;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ThemeActivity extends AppCompatActivity {

    ConstraintLayout theme_preview;
    Button save_btn;
    Button back_btn;
    String newString;
    Button download_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        ActivityCompat.requestPermissions(ThemeActivity.this,new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},1);


        theme_preview = findViewById(R.id.theme_preview);
        save_btn = findViewById(R.id.save_btn);
        back_btn = findViewById(R.id.back_btn);
        download_btn = findViewById(R.id.download_btn);

        if(savedInstanceState == null)
        {
            Bundle extras = getIntent().getExtras();
            if(extras == null)
            {
                newString = null;
            }
            else
            {
                newString = extras.getString("PATH_PICTURE");
                if(newString.equals("bg_item1"))
                {
                    theme_preview.setBackgroundResource(R.drawable.bg_item1);

                    save_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            WallpaperManager wlp = WallpaperManager.getInstance(getApplicationContext());
                            Toast.makeText(ThemeActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                            try
                            {
                                wlp.setResource(+ R.drawable.bg_item1);
                            }catch (IOException e)
                            {
                                 e.printStackTrace();
                            }
                        }
                    });

                    download_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Bitmap bitmap;
                            OutputStream outputStream;

                            bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bg_item1);

                            File filePath = Environment.getExternalStorageDirectory();
                            File dir = new File(filePath+"/MyWallp/");
                            dir.mkdirs();
                            File file = new File(dir,"mybackground_1.png");

                            try
                            {
                                outputStream = new FileOutputStream(file);
                                bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
                                outputStream.flush();
                                outputStream.close();
                                Toast.makeText(getApplicationContext(),"Image Saved",Toast.LENGTH_SHORT).show();
                            }catch (Exception e)
                            {
                                e.printStackTrace();
                            }

                        }
                    });
                }
                else if(newString.equals("bg_item2"))
                {
                    theme_preview.setBackgroundResource(R.drawable.bg_item2);

                    save_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            WallpaperManager wlp = WallpaperManager.getInstance(getApplicationContext());
                            Toast.makeText(ThemeActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                            try
                            {
                                wlp.setResource(+ R.drawable.bg_item2);
                            }catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    });

                    download_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Bitmap bitmap;
                            OutputStream outputStream;

                            bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bg_item2);

                            File filePath = Environment.getExternalStorageDirectory();
                            File dir = new File(filePath+"/MyWallp/");
                            dir.mkdirs();
                            File file = new File(dir,"mybackground_2.png");

                            try
                            {
                                outputStream = new FileOutputStream(file);
                                bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
                                outputStream.flush();
                                outputStream.close();
                                Toast.makeText(getApplicationContext(),"Image Saved",Toast.LENGTH_SHORT).show();
                            }catch (Exception e)
                            {
                                e.printStackTrace();
                            }

                        }
                    });
                }
                else
                {
                    //write statements
                }
            }
        }

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
