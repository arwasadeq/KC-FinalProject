package com.example.exptriate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class shapeadapter extends ArrayAdapter<shapes> {

    List<shapes> shapesList;

    public shapeadapter(@NonNull Context context, int resource, @NonNull List<shapes> objects) {
        super(context, resource, objects);
        shapesList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        shapes currentshape = shapesList.get(position);

        TextView shapename = view.findViewById(R.id.text);
        ImageView shapeimage = view.findViewById(R.id.book);
        TextView type = view.findViewById(R.id.text2);

        shapename.setText(currentshape.getShapename());
        shapeimage.setImageResource(currentshape.getShapeimage());
        type.setText(currentshape.getShapename());

        return view;
    }
}
