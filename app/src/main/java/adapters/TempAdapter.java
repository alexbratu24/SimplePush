package adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alex.simplepush.R;

import java.util.ArrayList;
import java.util.List;

import model.Temperature;

/**
 * Created by Alex on 1/9/2016.
 */
public class TempAdapter extends ArrayAdapter<Temperature>{

    private Context context;
    private ArrayList<Temperature> items;

    public TempAdapter(Context context, ArrayList<Temperature> objects) {
        super(context, -1, objects);
        this.context=context;
        this.items= objects;
    }

    @Override
     public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);
        TextView tvCreatedAt = (TextView) rowView.findViewById(R.id.createdat);
        TextView tvTemp = (TextView) rowView.findViewById(R.id.temp);
        Temperature t = items.get(position);
        tvCreatedAt.setText(t.getCreatedAt().toString());
        tvTemp.setText(String.valueOf((t.getTemp())));
        tvTemp.setTextColor(Color.BLACK);
        tvCreatedAt.setTextColor(Color.CYAN);
        if(t.getTemp() > 24)
        {
            tvTemp.setTextColor(Color.RED);
        }
        if(t.getTemp() < 22)
        {
            tvTemp.setTextColor(Color.GREEN);
        }
       return rowView;
    }
}
