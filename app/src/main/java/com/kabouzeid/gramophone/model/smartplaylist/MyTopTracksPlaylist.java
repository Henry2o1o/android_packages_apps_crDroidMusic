package com.kabouzeid.gramophone.model.smartplaylist;

import android.content.Context;
import android.os.Parcel;
import android.support.annotation.NonNull;

import com.kabouzeid.gramophone.loader.TopAndRecentlyPlayedTracksLoader;
import com.kabouzeid.gramophone.model.Song;
import com.kabouzeid.gramophone.provider.SongPlayCountStore;

import com.crdroid.music.R;

import java.util.ArrayList;

/**
 * @author Karim Abou Zeid (kabouzeid)
 */
public class MyTopTracksPlaylist extends AbsSmartPlaylist {

    public MyTopTracksPlaylist(@NonNull Context context) {
        super(context.getString(R.string.my_top_tracks), R.drawable.ic_trending_up_white_24dp);
    }

    @NonNull
    @Override
    public ArrayList<Song> getSongs(@NonNull Context context) {
        return TopAndRecentlyPlayedTracksLoader.getTopTracks(context);
    }

    @Override
    public void clear(@NonNull Context context) {
        SongPlayCountStore.getInstance(context).clear();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    protected MyTopTracksPlaylist(Parcel in) {
        super(in);
    }

    public static final Creator<MyTopTracksPlaylist> CREATOR = new Creator<MyTopTracksPlaylist>() {
        public MyTopTracksPlaylist createFromParcel(Parcel source) {
            return new MyTopTracksPlaylist(source);
        }

        public MyTopTracksPlaylist[] newArray(int size) {
            return new MyTopTracksPlaylist[size];
        }
    };
}