package vimanyu.calculator;

import android.os.Bundle;
import android.app.Activity;

import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;


import java.util.ArrayList;

public class Main3Activity extends Activity
{
    DBHandler dbHandler;
    ArrayList<String> arr  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        dbHandler = DBHandler.getInstance(this);
        String a = dbHandler.print();

        int x=0;

        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i) == '\n')
            {
                arr.add(a.substring(x,i));
                x = i+1;
            }
        }


        ListAdapter vimsAdapterList = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arr);
        ListView vimsListView = (ListView) findViewById(R.id.listView3);
        vimsListView.setAdapter(vimsAdapterList);
    }

    public void return6(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void delete(View view)
    {
        dbHandler.delete();
        //try to delete the whole list here
    }

}
