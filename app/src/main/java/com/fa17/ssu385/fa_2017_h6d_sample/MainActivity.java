package com.fa17.ssu385.fa_2017_h6d_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fa17.ssu385.fa_2017_h6d_sample.model.RecipeList;
import com.fa17.ssu385.fa_2017_h6d_sample.network.RecipeApi;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private final String app_key = "ec3e34e0bb6801670dbd3dbd02ce7608";
    private final String app_id = "4911b643";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecipeApi.adapter().getRecipes(app_key, app_id, "some value")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecipeList>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull RecipeList recipeList) {
                        // results handled here
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
