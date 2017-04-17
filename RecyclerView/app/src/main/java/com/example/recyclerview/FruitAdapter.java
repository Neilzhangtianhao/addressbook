package com.example.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{

    private List<Fruit1> mFruitList;
    //实体类
    private Fruit1 model;



    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;
        TextView chinesename;
        TextView number;
        TextView shape;
        TextView colour;

        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
            chinesename = (TextView) view.findViewById(R.id.chinese_name);
            number = (TextView) view.findViewById(R.id.number);
            shape = (TextView) view.findViewById(R.id.shape);
            colour = (TextView) view.findViewById(R.id.colour);
        }

    }

    public FruitAdapter(List<Fruit1> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }//取得下标

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit1 fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit1 fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

                //选中下标
                model = mFruitList.get(viewType);
                //获取首字母显示人
                int firstPosition = getNmaeForPosition(viewType);
                //第一个
                int index = getPositionForNmae(firstPosition);
                //需要显示字母
                if (index == viewType) {
                    holder.chinesename.setVisibility(View.VISIBLE);
                    holder.chinesename.setText(model.getChinesename());
                } else {
                    holder.chinesename.setVisibility(View.GONE);
                }
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit1 fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
        holder.chinesename.setText(fruit.getChinesename());
        holder.number.setText(fruit.getNumber());
        holder.shape.setText(fruit.getShape());
        holder.colour.setText(fruit.getColour());

    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }



    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * 通过首字母获取该首字母要显示的第一个人的下标
     *
     * @param position
     * @return
     */
    public int getPositionForNmae(int position) {
        for (int i = 0; i < getItemCount(); i++) {
            String letter = mFruitList.get(i).getChinesename();
            //首字母显示
            char firstChar = letter.toUpperCase().charAt(0);
            if (firstChar == position) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据名称拿到下标
     *
     * @param position
     * @return
     */
    private int getNmaeForPosition(int position) {
        return mFruitList.get(position).getChinesename().charAt(0);
    }


}
