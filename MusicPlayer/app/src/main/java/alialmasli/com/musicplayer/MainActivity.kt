package alialmasli.com.musicplayer

import alialmasli.com.musicplayer.MainActivity.Companion.PERMISSION_REQUEST_CODE
import alialmasli.com.musicplayer.adapters.SongListAdapter
import alialmasli.com.musicplayer.model.SongModel
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    var songModelData : ArrayList<SongModel> = ArrayList()
    var songListAdapter : SongListAdapter? = null

    companion object {
        val PERMISSION_REQUEST_CODE = 12
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(ContextCompat.checkSelfPermission(applicationContext,android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this@MainActivity,
                    arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE), PERMISSION_REQUEST_CODE)
        }
        else
        {
            loadData()
        }
    }

    fun loadData()
    {
        var songCursor = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null,null,null,null)
        while (songCursor != null && songCursor.moveToNext())
        {
            var songName = songCursor.getString(songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            var songDuration = songCursor.getString(songCursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
            songModelData.add(SongModel(songName,songDuration))
        }
        songListAdapter = SongListAdapter(songModelData)
        var layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = songListAdapter
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == PERMISSION_REQUEST_CODE)
        {
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                    Toast.makeText(applicationContext,"Permission Granted",Toast.LENGTH_LONG).show()
                    loadData()
            }
        }
    }
}

