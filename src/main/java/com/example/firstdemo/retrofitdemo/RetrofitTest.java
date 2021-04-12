package com.example.firstdemo.retrofitdemo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.ArrayList;
import java.util.List;

public class RetrofitTest {
    List<SearchResult.DataBean.TbkDgMaterialOptionalResponseBean.ResultListBean.MapDataBean> mapDataBeanList=new
            ArrayList<>();
    public RetrofitTest() {
        Retrofit retrofit = RetrofitManager.getInstance().getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<SearchResult> task = api.doSearch(1, "键盘");

        task.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                if (response.code()==200){
                    SearchResult searchResult = response.body();
                    List<SearchResult.DataBean.TbkDgMaterialOptionalResponseBean.ResultListBean.MapDataBean> map_data = searchResult.getData().getTbk_dg_material_optional_response().getResult_list().getMap_data();
                    mapDataBeanList.addAll(map_data);
                    System.out.println(map_data.size());
                }
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable throwable) {

            }
        });
        Call<SearchResult> task1=api.doSearch(1,"手机");
        task1.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                if (response.code()==200){
                    SearchResult searchResult = response.body();
                    List<SearchResult.DataBean.TbkDgMaterialOptionalResponseBean.ResultListBean.MapDataBean> map_data = searchResult.getData().getTbk_dg_material_optional_response().getResult_list().getMap_data();
                    mapDataBeanList.addAll(map_data);

                }
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable throwable) {

            }
        });

    }

    public List<SearchResult.DataBean.TbkDgMaterialOptionalResponseBean.ResultListBean.MapDataBean> getMapDataBeanList() {
        return mapDataBeanList;
    }

    public void setMapDataBeanList(List<SearchResult.DataBean.TbkDgMaterialOptionalResponseBean.ResultListBean.MapDataBean> mapDataBeanList) {
        this.mapDataBeanList = mapDataBeanList;
    }

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                RetrofitTest retrofitTest = new RetrofitTest();
                System.out.println("size:"+retrofitTest.getMapDataBeanList().size());
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();




    }
}
