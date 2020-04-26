package com.dahua.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SportsFragment extends Fragment {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    SportsAdapter setAdapter;
    String title;
    List<String> mLists;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.fragment_sports, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initData();
    }

    public static SportsFragment getInstance(String po) {
        SportsFragment fragment = new SportsFragment();
        fragment.title = po;
        return fragment;
    }


    protected void initData() {
        mLists = new ArrayList<>();
        mLists.add("https://img.zcool.cn/community/011ad05e27a173a801216518a5c505.jpg");
        mLists.add("https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg");
        mLists.add("https://img.zcool.cn/community/011ad05e27a173a801216518a5c505.jpg");
        mLists.add("https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg");
        mLists.add("https://img.zcool.cn/community/011ad05e27a173a801216518a5c505.jpg");
        mLists.add("https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg");
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        setAdapter = new SportsAdapter(getContext(), mLists);
        recycler.setAdapter(setAdapter);
        setAdapter.setOnItemClickListener(new SportsAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, String contact) {
                Toast.makeText(getActivity(), contact, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }
}
