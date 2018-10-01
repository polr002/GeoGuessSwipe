package com.example.roy.geoguessswipe;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<GeoObject> mGeoObjects = new ArrayList<>();

        for (int i = 0; i < GeoObject.PRE_DEFINED_OBJECT_SOLUTIONS.length; i++) {

            //mGeoObjects.add(new GeoObject(GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i],
                    //GeoObject.PRE_DEFINED_OBJECT_SOLUTIONS[i]));
            mGeoObjects.add(new GeoObject(GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i], "Question " + (i+1)));
        }

        RecyclerView mGeoRecyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);

        mGeoRecyclerView.setLayoutManager(mLayoutManager);
        final GeoObjectAdapter mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        mGeoRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {

                int position = (viewHolder.getAdapterPosition());
                Context context = getApplicationContext();
                String solution = GeoObject.PRE_DEFINED_OBJECT_SOLUTIONS[position];

                if (solution.equals("yes") & swipeDir == ItemTouchHelper.RIGHT) {

                    //User is correct so inform him
                    Toast.makeText(context, "CORRECT!", Toast.LENGTH_SHORT).show();

                    //set checkmark
                    mGeoObjects.set(position, new GeoObject(R.drawable.checkmark, "Correct!"));
                    mAdapter.notifyItemChanged(position);

                } else if (solution.equals("no") & swipeDir == ItemTouchHelper.LEFT){

                    //User is correct so inform him

                    Toast.makeText(context, "CORRECT!", Toast.LENGTH_SHORT).show();

                    //Set checkmark
                    mGeoObjects.set(position, new GeoObject(R.drawable.checkmark, "Correct!"));
                    mAdapter.notifyItemChanged(position);

                } else {
                    Toast.makeText(context, "WRONG", Toast.LENGTH_SHORT).show();
                    mGeoObjects.set(position, new GeoObject(R.drawable.cross, "Wrong!"));
                    mAdapter.notifyItemChanged(position);
                }



            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mGeoRecyclerView);

    }
}
