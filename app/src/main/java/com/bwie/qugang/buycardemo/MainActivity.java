package com.bwie.qugang.buycardemo;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.qugang.buycardemo.fragment.BuyCarFragment;
import com.bwie.qugang.buycardemo.fragment.HomeFragment;
import com.bwie.qugang.buycardemo.fragment.MyFragment;
import com.bwie.qugang.buycardemo.fragment.TopicFragment;

/**
 * MainActivity 实现四个Fragment的显示与隐藏
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private HomeFragment mHomeFragment;
    private LinearLayout ll_tab_home;
    private LinearLayout ll_tab_topic;
    private LinearLayout ll_tab_car;
    private LinearLayout ll_tab_my;
    private ImageView tab_home_image;
    private ImageView tab_buycar_image;
    private ImageView tab_my_image;
    private ImageView tab_topic_image;
    private TextView tab_home_text;
    private TextView tab_topic_text;
    private TextView tab_buycar_text;
    private TextView tab_my_text;
    private FragmentManager manager;
    private TopicFragment mTopicFragment;
    private BuyCarFragment mBuyCarFragment;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化资源id
        initView();
        //初始化点击事件
        initEvent();
    }
    //初始化点击事件
    private void initEvent() {
        ll_tab_home.setOnClickListener(this);
        ll_tab_topic.setOnClickListener(this);
        ll_tab_car.setOnClickListener(this);
        ll_tab_my.setOnClickListener(this);
    }

    //初始化资源id
    private void initView() {
        ll_tab_home = (LinearLayout) findViewById(R.id.ll_tab_home);
        ll_tab_topic = (LinearLayout) findViewById(R.id.ll_tab_topic);
        ll_tab_car = (LinearLayout) findViewById(R.id.ll_tab_car);
        ll_tab_my = (LinearLayout) findViewById(R.id.ll_tab_my);

        //按钮图片的ID
        tab_home_image = (ImageView) findViewById(R.id.tab_home_image);
        tab_buycar_image = (ImageView) findViewById(R.id.tab_buycar_image);
        tab_my_image = (ImageView) findViewById(R.id.tab_my_image);
        tab_topic_image = (ImageView) findViewById(R.id.tab_topic_image);

        //按钮上面字的ID
        tab_home_text = (TextView) findViewById(R.id.tab_home_text);
        tab_topic_text = (TextView) findViewById(R.id.tab_topic_text);
        tab_buycar_text = (TextView) findViewById(R.id.tab_buycar_text);
        tab_my_text = (TextView) findViewById(R.id.tab_my_text);
        //默认显示第一个Fragment
        manager = getSupportFragmentManager();
        mHomeFragment = new HomeFragment();
        manager.beginTransaction().add(R.id.frame, mHomeFragment).commit();
    }
    //将所有按钮里面的图片和字都变成黑色
    private void restartBtn(){
        //所有的图片按钮的字体设置为正常为点击的颜色
        tab_home_image.setImageResource(R.drawable.tab_home);
        tab_topic_image.setImageResource(R.drawable.tab_topic);
        tab_buycar_image.setImageResource(R.drawable.main_index_cart_normal);
        tab_my_image.setImageResource(R.drawable.main_index_my_normal);
        //所有的字体的颜色设置为正常的未点击的颜色
        tab_home_text.setTextColor(getResources().getColor(R.color.textColor_grey));
        tab_topic_text.setTextColor(getResources().getColor(R.color.textColor_grey));
        tab_buycar_text.setTextColor(getResources().getColor(R.color.textColor_grey));
        tab_my_text.setTextColor(getResources().getColor(R.color.textColor_grey));
    }
    //隐藏掉所有的Fragment的方法啊
    private void hideFragment(FragmentTransaction ft){
        if(mHomeFragment!=null){
            ft.hide(mHomeFragment);
        }
        if(mTopicFragment!=null){
            ft.hide(mTopicFragment);
        }
        if(mBuyCarFragment!=null){
            ft.hide(mBuyCarFragment);
        }
        if(myFragment!=null){
            ft.hide(myFragment);
        }
    }
    @Override
    public void onClick(View v) {
        restartBtn();
        FragmentTransaction ft = manager.beginTransaction();
        hideFragment(ft);
        switch (v.getId()){
            case R.id.ll_tab_home:
                tab_home_image.setImageResource(R.drawable.tab_home_s);
                tab_home_text.setTextColor(this.getResources().getColor(R.color.textColor_orange));
                //主页面的监听事件
                if(mHomeFragment==null){
                    mHomeFragment = new HomeFragment();
                }
                if(!mHomeFragment.isAdded()){
                    ft.add(R.id.frame,mHomeFragment);
                }
                ft.show(mHomeFragment);
                break;
            case R.id.ll_tab_topic:
                tab_topic_image.setImageResource(R.drawable.tab_topic_s);
                tab_topic_text.setTextColor(this.getResources().getColor(R.color.textColor_orange));
                if(mTopicFragment == null){
                    mTopicFragment = new TopicFragment();
                }
                if(!mTopicFragment.isAdded()){
                    ft.add(R.id.frame,mTopicFragment);
                }
                ft.show(mTopicFragment);
                break;
            case R.id.ll_tab_car:
                tab_buycar_image.setImageResource(R.drawable.main_index_cart_pressed);
                tab_buycar_text.setTextColor(this.getResources().getColor(R.color.textColor_orange));
                if(mBuyCarFragment == null){
                    mBuyCarFragment = new BuyCarFragment();
                }
                if(!mBuyCarFragment.isAdded()){
                    ft.add(R.id.frame,mBuyCarFragment);
                }
                ft.show(mBuyCarFragment);
                break;
            case R.id.ll_tab_my:
                tab_my_image.setImageResource(R.drawable.main_index_my_pressed);
                tab_my_text.setTextColor(this.getResources().getColor(R.color.textColor_orange));
                if(myFragment == null){
                    myFragment = new MyFragment();
                }
                if(!myFragment.isAdded()){
                    ft.add(R.id.frame,myFragment);
                }
                ft.show(myFragment);
                break;
        }
        ft.commit();
    }
}
