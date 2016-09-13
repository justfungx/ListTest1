package tw.org.iii.listtest1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private LinkedList<HashMap<String,Object>> data;
    private String[] from = {"title","content","img"};
    private int[] to = {R.id.item_title, R.id.item_content,
            R.id.item_img};
    private SimpleAdapter adapter;
    private EditText inputTitle ;
    private int[] p = {R.drawable.icon,R.drawable.icon2,R.drawable.icon3,R.drawable.icon4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTitle = (EditText)findViewById(R.id.inputTitle);

        list = (ListView)findViewById(R.id.list);
        initListView();


    }

    private void initListView(){
        data = new LinkedList<>();

        adapter = new SimpleAdapter(
                this,data,
                R.layout.layout_item,
                from,to);
        list.setAdapter(adapter);

         //錯誤寫法 不是去關閉整個LIST表單
        //        list.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("brad", "OK");
//            }
//        });

        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {
            Log.d("DK","i="+i);

            }
        });
    }

    public void addItem(View v){
        String input = inputTitle.getText().toString();
        HashMap<String,Object> dd =
                new HashMap<>();
        dd.put(from[0],input);
        dd.put(from[1], "data...");
        dd.put(from[2],p[(int)(Math.random()*4)]);
        data.add(dd);
        adapter.notifyDataSetChanged();
    }
}