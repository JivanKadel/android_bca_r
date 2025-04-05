package com.jivan.bcamidterm.viewgroups;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jivan.bcamidterm.R;
import com.jivan.bcamidterm.models.Todo;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private Todo[] todos;

    public TodoAdapter(Todo[] todos) {
        this.todos = todos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvDesc;
        private CheckBox cbCompleted;

        public ViewHolder(@NonNull View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tvTodoTitle);
            tvDesc = view.findViewById(R.id.tvTodoDesc);
            cbCompleted = view.findViewById(R.id.cbCompleted);
        }

        public TextView getTvTitle() {
            return tvTitle;
        }

        public TextView getTvDesc() {
            return tvDesc;
        }

        public CheckBox getCbCompleted() {
            return cbCompleted;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTvTitle().setText(todos[position].getTitle());
        holder.getTvDesc().setText(todos[position].getDesc());
        holder.getCbCompleted().setChecked(todos[position].isCompleted());
    }

    @Override
    public int getItemCount() {
        return todos.length;
    }


}
