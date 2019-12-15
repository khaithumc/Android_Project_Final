package khaithumc.com;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class Music extends Service {
    MediaPlayer mediaPlayer;
    String value;
    boolean bool;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        value = intent.getStringExtra("1");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String nhanKey = intent.getExtras().getString("extra");
        if(nhanKey.equals("on")) {
            bool = true;
        } else if(nhanKey.equals("off")) {
            bool = false;
        }
        if(bool) {
            mediaPlayer = MediaPlayer.create(this,R.raw.borhap);
            /*String value = intent.getExtras().getString("1");
           if (value.equals("Let it Go")) {
                mediaPlayer = MediaPlayer.create(this,R.raw.letitgo);
            }
           if (value.equals("We Will Rock You")) {
                mediaPlayer = MediaPlayer.create(this,R.raw.wewillrockyou);
            }
           if (value.equals("Bohemian Rhapsody")){
                mediaPlayer = MediaPlayer.create(this,R.raw.borhap);
            }*/
            mediaPlayer.start();
            bool = false;
        } else if(!bool){
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
        return START_NOT_STICKY;
    }
}