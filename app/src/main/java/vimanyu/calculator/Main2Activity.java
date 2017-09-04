package vimanyu.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends Activity {

    ArrayList<String> arr = new ArrayList<>();
    String record;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle data = getIntent().getExtras();
        if(data == null)
        {
            return;
        }

        String a = data.getString("alash");

        record = data.getString("alash1");
        arr.add(record);

        TextView v1 = (TextView) findViewById(R.id.textVeiw33);
        v1.setText(a);
    }

    public void return123(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void prevCalc(View view)
    {
        Intent intent1 = new Intent(this,Main3Activity.class);

        //intent1.putExtra("alash",arr);
        intent1.putStringArrayListExtra("alash",arr);
        startActivity(intent1);
    }

}
