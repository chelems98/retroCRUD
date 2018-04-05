package com.user.prueba3.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.user.prueba3.R;
import com.user.prueba3.models.DepartmentModel;

import java.util.List;


public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.ViewHolder > {

    private List<DepartmentModel> departments;

    public DepartmentAdapter(List<DepartmentModel> departments) {
        this.departments = departments;
    }

    @Override
    public DepartmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_department, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DepartmentAdapter.ViewHolder holder, int position) {
        DepartmentModel DepartmentModel = departments.get(position);
        holder.name.setText(String.valueOf(DepartmentModel.getName()));
        holder.price.setText(String.valueOf(DepartmentModel.getPrice()));
        holder.description.setText(String.valueOf(DepartmentModel.getDescription()));


    }

    @Override
    public int getItemCount() {
        return departments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
        TextView description;
        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            description = itemView.findViewById(R.id.description);
        }
    }
}
