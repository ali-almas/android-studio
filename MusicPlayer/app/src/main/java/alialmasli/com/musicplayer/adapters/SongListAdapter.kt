package alialmasli.com.musicplayer.adapters

import alialmasli.com.musicplayer.R
import alialmasli.com.musicplayer.model.SongModel
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.music_row.view.*

class SongListAdapter(SongModel : ArrayList<SongModel>) : RecyclerView.Adapter<SongListAdapter.SongListViewHolder>()
{

    var mSongModel = SongModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongListViewHolder {

        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.music_row,parent,false);
        return SongListViewHolder(view)

    }

    override fun getItemCount(): Int {

        return mSongModel.size

    }

    override fun onBindViewHolder(holder: SongListViewHolder, position: Int) {

        var model = mSongModel[position]
        var songName = model.mSongName
        var songDuration = model.mSongDuration
        holder!!.songTv.text = songName
        holder!!.durationTv.text = songDuration


    }


    class SongListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        var songTv : TextView
        var durationTv : TextView
        var albumaArt : ImageView
        init {
            songTv = itemView.findViewById(R.id.song_name)
            durationTv = itemView.findViewById(R.id.song_duration_tv)
            albumaArt = itemView.findViewById(R.id.al_img_view)
        }
    }
}