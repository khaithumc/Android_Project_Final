package khaithumc.com;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AlarmClock extends AppCompatActivity {
    Button btnHatGio, btnDung, btnXemdanhsach, btnQuaylai;
    TextView txtHienThi;
    TimePicker timePicker;
    Calendar calendar;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_clock);
        btnHatGio = (Button) findViewById(R.id.btnHenGio);
        btnDung = (Button) findViewById(R.id.btnDung);
        btnXemdanhsach = (Button) findViewById(R.id.btnXemdanhsach);
        btnQuaylai = (Button) findViewById(R.id.btnQuayVe);
        txtHienThi = (TextView) findViewById(R.id.textView);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        calendar = Calendar.getInstance();
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        final Intent intent = new Intent(AlarmClock.this,AlarmReceiver.class);

        btnHatGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();
                String str_hour = String.valueOf(hour);
                String str_minute = String.valueOf(minute);
                if(minute < 10) {
                    str_minute = "0" + String.valueOf(minute);
                }
                intent.putExtra("extra","on");
                pendingIntent = PendingIntent.getBroadcast(
                        AlarmClock.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT
                );
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
                time = str_hour +":"+ str_minute;
                txtHienThi.setText("ĐẶT BÁO THỨC LÚC " + time);

            }
        });


        btnDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHienThi.setText("ĐÃ TẮT BÁO THỨC");
                alarmManager.cancel(pendingIntent);
                intent.putExtra("extra","off");
                sendBroadcast(intent);
            }
        });

        btnXemdanhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(AlarmClock.this, ListView.class);
                Bundle bundle = new Bundle();
                bundle.putString("xem",txtHienThi.getText().toString());
                intent1.putExtra("intent", bundle);
                startActivity(intent1);
            }
        });

        btnQuaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(AlarmClock.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}





