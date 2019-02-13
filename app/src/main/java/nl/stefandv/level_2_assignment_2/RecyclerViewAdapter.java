package nl.stefandv.level_2_assignment_2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nl.stefandv.level_2_assignment_2.OnSwipeTouchListener.*;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Location> mData;
    private LayoutInflater mInflater;
    private Context mContext;

    RecyclerViewAdapter(Context context, ArrayList<Location> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mContext = context;
    }

    public String getLocation(int position) {
        Location loc = mData.get(position);
        return loc.getCountry();
    }

    public boolean getAnswer(int position) {
        Location loc = mData.get(position);
        return loc.isEurope();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final Location loc = mData.get(position);
        holder.image.setImageResource(loc.getmPlaceImage());


        holder.image.setOnTouchListener(new View.OnTouchListener() {
            long CLICK_DURATION = 200;
            float x1, x2, y1, y2, t1, t2;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
            boolean answer;
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        x1 = event.getX();
                        y1 = event.getY();
                        t1 = System.currentTimeMillis();
                        return true;
                    case MotionEvent.ACTION_UP:
                        x2 = event.getX();
                        y2 = event.getY();
                        t2 = System.currentTimeMillis();

                        if (x1 == x2 && y1 == y2 && (t2 - t1) < CLICK_DURATION) {
                            Toast.makeText(mContext, "You clicked " + getLocation(position), Toast.LENGTH_SHORT).show();
                        } else if (x1 > x2) {
                            answer = false;
                            if (answer != getAnswer(position)){
                                Toast.makeText(mContext, "Good Answer!", Toast.LENGTH_SHORT).show();
                            }else Toast.makeText(mContext, "Wrong Answer!", Toast.LENGTH_SHORT).show();

                        } else if (x2 > x1) {
                            answer = true;
                            if (answer != getAnswer(position)){
                                Toast.makeText(mContext, "Good Answer!", Toast.LENGTH_SHORT).show();
                            }else Toast.makeText(mContext, "Wrong Answer!", Toast.LENGTH_SHORT).show();

                        }


                        return true;
                }

                return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        RelativeLayout parentLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}

