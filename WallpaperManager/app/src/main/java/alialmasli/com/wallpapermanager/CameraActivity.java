package alialmasli.com.wallpapermanager;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class CameraActivity extends AppCompatActivity {

    Button save_btn;
    Button back_btn;
    Button download_btn;
    ImageView place_pic;
    Bitmap camBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        save_btn = findViewById(R.id.save_btn);
        back_btn = findViewById(R.id.back_btn);
        download_btn = findViewById(R.id.download_btn);
        place_pic = findViewById(R.id.place_pic);

        Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cam,0);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WallpaperManager wlp = WallpaperManager.getInstance(getApplicationContext());
                Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_SHORT).show();
                try
                {
                    wlp.setBitmap(camBitmap);
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });

        download_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pending
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        camBitmap = (Bitmap) data.getExtras().get("data");
        place_pic.setImageBitmap(camBitmap);
    }
}
