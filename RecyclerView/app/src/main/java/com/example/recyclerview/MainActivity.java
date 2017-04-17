package com.example.recyclerview;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LettersView.OnLettersListViewListener ,View.OnClickListener  {


    private List<Fruit1> fruitList = new ArrayList<>();

    private FruitAdapter adapter;

    private SearchView mSearchView;

    private LinearLayoutManager layoutManager;

    //字母提示
    private TextView tvToast;
    //字母列表
    private LettersView mLettersView;

    private String[] strName = {"苹果目","香蕉目","橘子目","西瓜目","梨目","葡萄目","风梨目",
            "草莓目","樱桃目","芒果目"};

    private String[] strFind={"苹", "香", "橘", "西", "葡", "风", "草", "樱", "芒"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        tvToast = (TextView) findViewById(R.id.tvToast);

        mLettersView = (LettersView) findViewById(R.id.mLettersView);
        mLettersView.setmTextView(tvToast);
        //绑定
        mLettersView.setOnLettersListViewListener(this);

        mSearchView = (SearchView) findViewById(R.id.search);
        mSearchView.setIconifiedByDefault(true);
        mSearchView.setFocusable(false);
        mSearchView.clearFocus();
        mSearchView.setSubmitButtonEnabled(true);
        mSearchView.setQueryHint("请输入搜索内容");

        mSearchView.setOnQueryTextListener(new OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String queryText) {

                System.out.println("onQueryTextChange:" + queryText);

                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String queryText) {

                System.out.println("onQueryTextSubmit:" + queryText);

                return true;
            }
        });



        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
         adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));//分割线
    }




    private void initFruits() {

            Fruit1 apple = new Fruit1(strName[0],"Apple", R.drawable.apple_pic,"#01 苹果","yuan","red");
            fruitList.add(apple);
            Fruit1 banana = new Fruit1(strName[1],"Banana", R.drawable.banana_pic,"#02 香蕉","chang","yellow");
            fruitList.add(banana);
            Fruit1 orange = new Fruit1(strName[2],"Orange", R.drawable.orange_pic,"#03 橘子","yuan","orange");
            fruitList.add(orange);
            Fruit1 watermelon = new Fruit1(strName[3],"Watermelon", R.drawable.watermelon_pic,"#04 西瓜","tuo yuan","green");
            fruitList.add(watermelon);
            Fruit1 pear = new Fruit1(strName[4],"Pear", R.drawable.pear_pic,"#05 梨","jian","yellow");
            fruitList.add(pear);
            Fruit1 grape = new Fruit1(strName[5],"Grape", R.drawable.grape_pic,"#06 葡萄","fang","purple");
            fruitList.add(grape);
            Fruit1 pineapple = new Fruit1(strName[6],"Pineapple", R.drawable.pineapple_pic,"#07 凤梨","fang","yellow");
            fruitList.add(pineapple);
            Fruit1 strawberry = new Fruit1(strName[7],"Strawberry", R.drawable.strawberry_pic,"#08 草莓","xiao","red");
            fruitList.add(strawberry);
            Fruit1 cherry = new Fruit1(strName[8],"Cherry", R.drawable.cherry_pic,"#09 樱桃","yuan","red");
            fruitList.add(cherry);
            Fruit1 mango = new Fruit1(strName[9],"Mango", R.drawable.mango_pic,"#10 芒果","tuo yuan","yellow");
            fruitList.add(mango);

    }
    /**
     * ListView与字母导航联动
     *
     * @param s
     */
    @Override
    public void onLettersListener(String s) {
        //对应的位置
        int position = adapter.getPositionForNmae(s.charAt(0));
        //移动
        layoutManager.scrollToPosition(position);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //            case R.id.tv_cancel:
            //                et_search.setText("");
            //                tv_cancel.setVisibility(View.GONE);
            //                break;
        }
    }



}