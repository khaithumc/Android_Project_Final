package khaithumc.com;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnThem;
    Spinner spinner;
    List<String> musics;
    TextView textView;
    ImageView imageView;
    String input;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThem = (Button) findViewById(R.id.btnThem);
        spinner = (Spinner) findViewById(R.id.music);
        context = new MainActivity();

        textView = (TextView) findViewById(R.id.selection);
        imageView = (ImageView) findViewById(R.id.imageView);
        this.imageView.setImageResource(R.drawable.alarmclock);
        musics = new ArrayList<>();

        musics.add("Bohemian Rhapsody");
        musics.add("Let It Go");
        musics.add("We Will Rock You");


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentThem = new Intent(MainActivity.this, AlarmClock.class);
                startActivity(intentThem);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,musics);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                input = musics.get(i);
                Intent intent = new Intent(Music.class.getName());
                if (input.equals("Let it Go")) {
                    intent.putExtra("1","Let it Go");
                }
                if (input.equals("Let it Go")) {
                    intent.putExtra("1","We Will Rock You");
                }
                if (input.equals("Let it Go")) {
                    intent.putExtra("1", "Bohemian Rhapsody");
                }
                //context.startService(intent);;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }
}