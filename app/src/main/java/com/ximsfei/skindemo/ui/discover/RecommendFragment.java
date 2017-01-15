package com.ximsfei.skindemo.ui.discover;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ximsfei.skindemo.R;
import com.ximsfei.skindemo.databinding.FooterRecommendItemBinding;
import com.ximsfei.skindemo.databinding.FragmentRecommendBinding;
import com.ximsfei.skindemo.databinding.HeaderRecommendItemBinding;
import com.ximsfei.skindemo.ui.adapter.RecommendAdapter;
import com.ximsfei.skindemo.ui.base.BaseFragment;
import com.ximsfei.skindemo.utils.TimeUtil;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * Created by ximsfei on 17-1-8.
 */

public class RecommendFragment extends BaseFragment<FragmentRecommendBinding> {
    private ArrayList<Integer> mBannerImages = new ArrayList<>();
    private HeaderRecommendItemBinding mHeaderBinding;
    private FooterRecommendItemBinding mFooterBinding;
    private RecommendAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void onCreateVew(LayoutInflater inflater, Bundle savedInstanceState) {
        super.onCreateVew(inflater, savedInstanceState);
        mHeaderBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.header_recommend_item, null, false);
        initRecyclerView();
    }

    private void initRecyclerView() {
        mDataBinding.recyclerView.setPullRefreshEnabled(false);
        mDataBinding.recyclerView.setLoadingMoreEnabled(true);
        mDataBinding.recyclerView.addHeaderView(mHeaderBinding.getRoot());
        mFooterBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.footer_recommend_item, null, false);
        mDataBinding.recyclerView.setFootView(mFooterBinding.getRoot());
        mDataBinding.recyclerView.setNoMore(true);
        mFooterBinding.getRoot().setVisibility(View.VISIBLE);
        mDataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mDataBinding.recyclerView.setNestedScrollingEnabled(false);
        mDataBinding.recyclerView.setHasFixedSize(false);
        mDataBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new RecommendAdapter(getActivity());
        mDataBinding.recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void loadData() {
        loadLocalData();
        loadBannerAd();
    }

    private void loadLocalData() {
        mHeaderBinding.dailyTxt.setText(getTodayTime().get(2).indexOf("0") == 0
                ? getTodayTime().get(2).replace("0", "")
                : getTodayTime().get(2));
    }

    /**
     * 获取当天日期
     */
    private ArrayList<String> getTodayTime() {
        String data = TimeUtil.getData();
        String[] split = data.split("-");
        String year = split[0];
        String month = split[1];
        String day = split[2];
        ArrayList<String> list = new ArrayList<>();
        list.add(year);
        list.add(month);
        list.add(day);
        return list;
    }

    private void loadBannerAd() {
        mBannerImages.clear();
        mBannerImages.add(R.drawable.home_banner_1);
        mBannerImages.add(R.drawable.home_banner_2);
        mBannerImages.add(R.drawable.home_banner_3);
        mBannerImages.add(R.drawable.home_banner_4);
        mBannerImages.add(R.drawable.home_banner_5);
        mBannerImages.add(R.drawable.home_banner_6);
        mBannerImages.add(R.drawable.home_banner_7);
        mBannerImages.add(R.drawable.home_banner_8);
        mBannerImages.add(R.drawable.home_banner_9);
        mBannerImages.add(R.drawable.home_banner_10);
        mBannerImages.add(R.drawable.home_banner_11);
        mBannerImages.add(R.drawable.home_banner_12);

        mHeaderBinding.banner
                .setDelayTime(5000)
                .setImages(mBannerImages)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path)
                                .placeholder(R.drawable.img_two_bi_one)
                                .error(R.drawable.img_two_bi_one)
                                .crossFade(1000)
                                .into(imageView);
                    }
                }).start();
    }
}
