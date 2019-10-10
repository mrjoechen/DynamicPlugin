package com.chenqiao.dynamicplugin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Method;


/**
 * 将 pluginapp 编译完成后，
 * push到 " /storage/emulated/0/Android/data/$packageName/files/plugin "
 *
 */


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.tv_test);

        Class<?> clazzz = null;
        try {
            clazzz = Class.forName("com.chenqiao.pluginapp.TestUtils");
            System.out.println("类名："+clazzz.getName());

            Method method = clazzz.getMethod("printHello"); // 后去getMessage方法
            method.invoke(clazzz); // 调用返回结果


        } catch (Exception e) {
            e.printStackTrace();
        }


        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class<?> clazzz = null;
                try {
                    clazzz = Class.forName("com.chenqiao.pluginapp.TestUtils");
                    System.out.println("类名："+clazzz.getName());

                    Object o = clazzz.newInstance();
                    Method add = clazzz.getMethod("add", int.class, int.class);
                    Integer invoke = (Integer) add.invoke(o, 1, 2);

                    textView.setText(""+invoke);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
