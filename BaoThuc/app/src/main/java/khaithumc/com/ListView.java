package khaithumc.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {
    android.widget.ListView listView;
    ArrayList<String> listTime;
    Button btnThem, btnXoa;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        listView = (android.widget.ListView) findViewById(R.id.listView);
        btnThem = (Button) findViewById(R.id.btnThemInList);
        btnXoa = (Button) findViewById(R.id.btnXoaInList);
        listTime = new ArrayList<String>();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentThem = new Intent(ListView.this, AlarmClock.class);
                startActivity(intentThem);
            }
        });

        final ArrayAdapter arrayAdapter = new ArrayAdapter(ListView.this,
                android.R.layout.simple_list_item_1, listTime);
        listView.setAdapter(arrayAdapter);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("intent");
        String value = bundle.getString("xem");

        if (bundle != null) {
            listTime.add(value);
            arrayAdapter.notifyDataSetChanged();
        }

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listTime.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }
        });





    }
}
