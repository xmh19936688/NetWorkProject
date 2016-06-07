package com.xmh.networkdemo.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xmh.networkdemo.R;
import com.xmh.networkdemo.biz.JokeLoader;
import com.xmh.networkdemo.model.JokeResult;
import com.xmh.networkdemo.ui.adapter.JokeListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private View mRootView;
    @Bind(R.id.rv_list)RecyclerView rvList;
    private JokeListAdapter mJokeListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,mRootView);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mJokeListAdapter = new JokeListAdapter(getActivity());
        rvList.setAdapter(mJokeListAdapter);
        rvList.setLayoutManager(new LinearLayoutManager(getActivity()));

        //region 使用原生HttpURLConnection
//        JokeLoader.LoadJokeByWeb(new JokeLoader.OnJokeLoadFinishListener() {
//            @Override
//            public void onFinish(final JokeResult result) {
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mJokeListAdapter.setJokeList(result.getShowapi_res_body().getContentlist());
//                    }
//                });
//            }
//        });
        //endregion

        //region 使用volley
//        JokeLoader.LoadJokeByVolley(getActivity(),new JokeLoader.OnJokeLoadFinishListener() {
//            @Override
//            public void onFinish(JokeResult result) {
//                mJokeListAdapter.setJokeList(result.getShowapi_res_body().getContentlist());
//            }
//        });
        //endregion

        //region 使用okHttp
        JokeLoader.LoadJokeByOkHttp(new JokeLoader.OnJokeLoadFinishListener() {
            @Override
            public void onFinish(final JokeResult result) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mJokeListAdapter.setJokeList(result.getShowapi_res_body().getContentlist());
                    }
                });
            }
        });
        //endregion
    }
}
