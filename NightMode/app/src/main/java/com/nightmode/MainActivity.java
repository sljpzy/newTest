package com.nightmode;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity{
    private ListView lvData;
    private List<Demo> list;
    private Button btnSwitch;

    private ImageView imgLogo;
    private LinearLayout llParent;

    private boolean isNight = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化视图
        lvData = (ListView) findViewById(R.id.lv_data);
        btnSwitch = (Button) findViewById(R.id.btn_switch);
        imgLogo = (ImageView) findViewById(R.id.img_logo);
        llParent = (LinearLayout) findViewById(R.id.bg_view_parent);
        // 初始化数据
        list = new ArrayList<>();
        list.add(new Demo(true, "是的撒大大", R.mipmap.ic_launcher));
        list.add(new Demo(true, "撒大城市", R.mipmap.ic_launcher));
        list.add(new Demo(true, "更符合法规和", R.mipmap.ic_launcher));
        list.add(new Demo(false, "呈现出现在"));
        list.add(new Demo(true, "温热无若", R.mipmap.ic_launcher));
        list.add(new Demo(true, "热让他热", R.mipmap.ic_launcher));
        list.add(new Demo(true, "撒大声地v", R.mipmap.ic_launcher));
        list.add(new Demo(false, "程序从vvcb"));
        list.add(new Demo(true, "热特特让人讨厌", R.mipmap.ic_launcher));
        list.add(new Demo(true, "撒大声地", R.mipmap.ic_launcher));
        list.add(new Demo(false, "发给对方的"));
        list.add(new Demo(true, "符合规范工会", R.mipmap.ic_launcher));
        list.add(new Demo(true, "是的范德萨发的", R.mipmap.ic_launcher));
        list.add(new Demo(true, "多少分太热太热", R.mipmap.ic_launcher));
        list.add(new Demo(false, "房顶上的孙菲菲"));
        list.add(new Demo(true, "鳄鱼Yuii", R.mipmap.ic_launcher));
        list.add(new Demo(false, "红魔噢妈妈离开"));
        list.add(new Demo(true, "这些宣传册V型", R.mipmap.ic_launcher));
        list.add(new Demo(false, "农民工仍然"));
        list.add(new Demo(false, "热同步官方"));
        list.add(new Demo(true, "差别vcvb", R.mipmap.ic_launcher));
        list.add(new Demo(true, "一一批批撒", R.mipmap.ic_launcher));

        // 设置适配器
        lvData.setAdapter(new DemoAdapter(this, list));


        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isNight = !isNight;
                BaseApplication.getInstance().setNight(isNight);
                switchMode(isNight);
                // 得到Window的视图
                View view = getWindow().getDecorView();
                changeTextColor((ViewGroup) view);
                changeImage();
            }
        });
    }

    /**
     * 日夜间模式切换的时候改变自身的图片
     */
    private void changeImage() {
        imgLogo.setImageResource(BaseApplication.getInstance().getResId(R.mipmap.default_user_leftdrawer));
   llParent.setBackgroundColor(BaseApplication.getInstance().isNight()? Color.BLACK:Color.WHITE);
    }


    // 在视图可见可交互的时候才能改变视图
    @Override
    protected void onResume() {
        super.onResume();
        // 一进入Activity，先拿到全局的isNight
        isNight = BaseApplication.getInstance().isNight();
        if (isNight) {
            switchMode(isNight);
        }
        changeTextColor((ViewGroup)getWindow().getDecorView());
        changeImage();
    }
}
