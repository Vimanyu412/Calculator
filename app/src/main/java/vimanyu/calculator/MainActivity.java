package vimanyu.calculator;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import android.content.Intent;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //this is a test comment


    String main = null;
    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void putOnScreen(View view)
    {
        String number = view.getTag().toString();

        if(main ==  null)
        {
            main = number;
        }

        else
        {
            if((number.equals("+") || number.equals("-")) && check==false)

            {
                main = main.concat(" ");
                main = main.concat(number);
                main = main.concat(" ");
                check = true;
            }

            else
            {
                main = main.concat(number);
            }
        }

        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(main);
    }

    public void sum(View view)
    {
        TextView x = (TextView) findViewById(R.id.textView);

        String text = x.getText().toString();
        String first = null;
        String second = null;

        int i=0;
        while(text.charAt(i) != ' ')
        {
            i++;
        }

        first = text.substring(0,i);

        int first1;
        try
        {
            first1 = Integer.parseInt(first);
        }
        catch(NumberFormatException e)
        {
            Toast.makeText(MainActivity.this,"Invalid",Toast.LENGTH_LONG).show();
            main = null;
            check = false;
            x.setText(main);
            return;
        }

        second = text.substring(i+3,text.length());

        int second2;

        try
        {
            second2 = Integer.parseInt(second);
        }

        catch(NumberFormatException e)
        {
            Toast.makeText(MainActivity.this,"Invalid",Toast.LENGTH_LONG).show();
            main = null;
            check = false;
            x.setText(main);
            return;
        }


        int sum = 0;

        if(text.charAt(i+1) == '+')
        {
            sum = second2 + first1;
        }

        else if(text.charAt(i+1) == '-')
        {
            sum = first1 - second2;
        }

        String record = main + " = " + sum;

        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("alash",String.valueOf(sum));
        intent.putExtra("alash1",record);
        startActivity(intent);

    }



}
