package vimanyu.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;
import java.util.ArrayList;

public class Main3Activity extends Activity
{
    ArrayList<String> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle data = getIntent().getExtras();

        if(data == null)
        {
            return;
        }

        //arr = data.getStringArray("alash");
        arr = data.getStringArrayList("alash");

        ListAdapter vimsAdapterList = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arr);

        ListView vimsListView = (ListView) findViewById(R.id.listView3);
        vimsListView.setAdapter(vimsAdapterList);
    }

    public void return6(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
