package com.newspaper.dusz7.newspapermanagement.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.newspaper.dusz7.newspapermanagement.R;
import com.newspaper.dusz7.newspapermanagement.location_module.LocDemo;

public class MainActivity extends AppCompatActivity {

    private LocDemo myLocDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLocDemo = new LocDemo();
        myLocDemo.initLocation();
        myLocDemo.startLocation();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myLocDemo.destroyLocation();
    }

    public void scan_start_onClick(View v){
        //打开扫描界面，返回扫描结果
        startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            //从二维码扫描界面获得结果
            String content = data.getStringExtra(CaptureActivity.EXTRA_RESULT);
            Log.d("decode_result",content);

        } else {
            Toast toast = Toast.makeText(getApplicationContext(),"扫描失败，请重试",Toast.LENGTH_SHORT);
            toast.show();

        }
    }


}
