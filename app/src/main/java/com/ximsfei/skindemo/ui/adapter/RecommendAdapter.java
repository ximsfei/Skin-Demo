package com.ximsfei.skindemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.ximsfei.skindemo.R;
import com.ximsfei.skindemo.databinding.RecommendItemBinding;
import com.ximsfei.skindemo.ui.adapter.baseadapter.BaseRecyclerViewAdapter;
import com.ximsfei.skindemo.ui.adapter.baseadapter.BaseRecyclerViewHolder;

/**
 * Created by ximsfei on 2017/1/15.
 */

public class RecommendAdapter extends BaseRecyclerViewAdapter<RecommendAdapter.RecommendBean> {
    public static final int TYPE_SONG_MENU = 1;
    public static final int TYPE_UNIQUE = 2;
    public static final int TYPE_LASTEST = 3;
    public static final int TYPE_MV = 4;
    public static final int TYPE_RADIO = 5;
    private final LayoutInflater mInflater;

    public RecommendAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecommendItemViewHolder(parent, R.layout.recommend_item);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    private class RecommendItemViewHolder extends BaseRecyclerViewHolder<RecommendBean, RecommendItemBinding> {
        public RecommendItemViewHolder(ViewGroup viewGroup, int layoutId) {
            super(viewGroup, layoutId);
        }

        @Override
        public void onBindViewHolder(RecommendBean bean, int position) {
//            mBinding.title.setText(bean.array.get(0).getTitle());
            Glide.with(mBinding.recommend1.image.getContext()).load(R.drawable.home_six_1)
                    .placeholder(R.drawable.img_two_bi_one)
                    .error(R.drawable.img_two_bi_one)
                    .crossFade(1000)
                    .into(mBinding.recommend1.image);
            Glide.with(mBinding.recommend2.image.getContext()).load(R.drawable.home_six_1)
                    .placeholder(R.drawable.img_two_bi_one)
                    .error(R.drawable.img_two_bi_one)
                    .crossFade(1000)
                    .into(mBinding.recommend2.image);
            Glide.with(mBinding.recommend3.image.getContext()).load(R.drawable.home_six_1)
                    .placeholder(R.drawable.img_two_bi_one)
                    .error(R.drawable.img_two_bi_one)
                    .crossFade(1000)
                    .into(mBinding.recommend3.image);
            Glide.with(mBinding.recommend4.image.getContext()).load(R.drawable.home_six_1)
                    .placeholder(R.drawable.img_two_bi_one)
                    .error(R.drawable.img_two_bi_one)
                    .crossFade(1000)
                    .into(mBinding.recommend4.image);
            Glide.with(mBinding.recommend5.image.getContext()).load(R.drawable.home_six_1)
                    .placeholder(R.drawable.img_two_bi_one)
                    .error(R.drawable.img_two_bi_one)
                    .crossFade(1000)
                    .into(mBinding.recommend5.image);
            Glide.with(mBinding.recommend6.image.getContext()).load(R.drawable.home_six_1)
                    .placeholder(R.drawable.img_two_bi_one)
                    .error(R.drawable.img_two_bi_one)
                    .crossFade(1000)
                    .into(mBinding.recommend6.image);
//            mBinding.recommend1.description.setText(bean.array.get(0).getTitle());
//            mBinding.recommend2.description.setText(bean.array.get(1).getTitle());
//            mBinding.recommend3.description.setText(bean.array.get(2).getTitle());
//            mBinding.recommend4.description.setText(bean.array.get(3).getTitle());
//            mBinding.recommend5.description.setText(bean.array.get(4).getTitle());
//            mBinding.recommend6.description.setText(bean.array.get(5).getTitle());
        }
    }

    public static class RecommendBean {
//        private List<Subjects> array = new ArrayList<>();
//
//        public int getCount() {
//            return array.size();
//        }
//
//        public void add(Subjects subjects) {
//            array.add(subjects);
//        }
    }
}
