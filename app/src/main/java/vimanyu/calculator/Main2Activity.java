package vimanyu.calculator;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.view.View;
import java.util.ArrayList;

public class Main2Activity extends Activity {

    ArrayList<String> arr = new ArrayList<>();
    String record;
    DBHandler dbHandler;


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

        TextView v1 = (TextView) findViewById(R.id.textVeiw33);
        v1.setText(a);

        dbHandler = DBHandler.getInstance(this);
        Products product = new Products(record);
        dbHandler.addRow(product);

    }

    public void return123(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void prevCalc(View view)
    {
        Intent intent1 = new Intent(this,Main3Activity.class);
        startActivity(intent1);
    }

}
