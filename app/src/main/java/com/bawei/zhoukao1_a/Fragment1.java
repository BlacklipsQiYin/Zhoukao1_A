package com.bawei.zhoukao1_a;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/10/0010.
 */

public class Fragment1 extends Fragment implements ViewAdapter.OnItemClickListener {


    private RecyclerView recyclerView1;
    private List<Bean1> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1, container, false);
        recyclerView1 = (RecyclerView) view.findViewById(R.id.recyclerView1);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        list = new ArrayList<Bean1>();

        for (int i=0; i<10; i++){

            Bean1 bean1 = new Bean1();
            bean1.setTitle("标题"+i);
            bean1.setText("内容"+i);

            list.add(bean1);

        }


        //设置适配器
        ViewAdapter adapter = new ViewAdapter(getContext(), list);
        recyclerView1.setAdapter(adapter);


        //必须设置布局管理器
        //线性布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager);



        //添加分割线
        recyclerView1.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).build());


        //RecyclerView条目监听
        adapter.setOnItemClickListener(this);



    }

    @Override
    public void onItemClickListener(int position, View view) {

        Intent intent = new Intent(getContext(), Second.class);
        intent.putExtra("title", list.get(position).getTitle());
        intent.putExtra("text", list.get(position).getText());
        startActivity(intent);


    }

    @Override
    public void onItemLongClickListener(int position, View view) {

    }
}
