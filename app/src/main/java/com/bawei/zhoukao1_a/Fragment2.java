package com.bawei.zhoukao1_a;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/10/0010.
 */

public class Fragment2 extends Fragment {


    private RecyclerView recyclerView2;
    private List<Bean1> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2, container, false);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerView2);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        list = new ArrayList<Bean1>();

        for (int i=0; i<10; i++){

            Bean1 bean1 = new Bean1();
            bean1.setTitle("标题"+i);

            list.add(bean1);

        }


        //设置适配器
        View2Adapter adapter = new View2Adapter(getContext(), list);
        recyclerView2.setAdapter(adapter);


        //表格管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);

        recyclerView2.setLayoutManager(gridLayoutManager);


        //StaggeredGridLayoutManager 瀑布流
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(staggeredGridLayoutManager);


        //设置item之间的间隔
//        SpacesItemDecoration decoration=new SpacesItemDecoration(50);
//        recyclerView2.addItemDecoration(decoration);


    }
}
