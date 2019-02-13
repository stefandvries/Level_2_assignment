package nl.stefandv.level_2_assignment_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import static nl.stefandv.level_2_assignment_2.Location.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Location> locations = new ArrayList<>();

        for (int i=0; i < LOCATION_NAMES.length; i++ ){
            locations.add(new Location(LOCATION_NAMES[i],LOCATION_ANSWERS[i],LOCATION_IMAGES[i]));
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, locations);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
