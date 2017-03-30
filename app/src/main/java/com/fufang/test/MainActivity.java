package com.fufang.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


import com.tencent.bugly.crashreport.CrashReport;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tv = (TextView)findViewById(R.id.tv);

        CrashReport.initCrashReport(getApplicationContext(), "df40effa78", true);
        init();

    }

    private void init() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "AA");
        map.put("2", "BB");
        map.put("3", "CC");
        map.put("4", "DD");

        String s = toJson(map);

        tv.setText(s);
    }

    /**
     * 返回Json字符串
     *
     * @param jsonMap
     *            需要返回的数据集
     * @return Json字符串
     */
    public static String toJson( Map<String, String> jsonMap) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");

        if (jsonMap.size() > 0) {
            buffer.append(",");
            for (String key : jsonMap.keySet()) {
                buffer.append("\""+key  + "\":\"" + jsonMap.get(key) + "\",");
            }
            // 去掉最后一个','
            buffer.deleteCharAt(1);
            buffer.deleteCharAt(buffer.length() - 1);
        }
        buffer.append("}");
        return buffer.toString();
    }
}
