package vimanyu.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

public class DBHandler extends SQLiteOpenHelper
{
    private static DBHandler sInstance;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "product.db";
    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_ID  = "_id";
    public static final String COLUMN_PRODUCTNAME = "productname";


    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    private DBHandler(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" + COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PRODUCTNAME +
                " TEXT " + ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_PRODUCTS);
        onCreate(db);
    }

    public void addRow(Products product)
    {
        ContentValues x = new ContentValues();
        x.put(COLUMN_PRODUCTNAME, product.get_productname());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, x);
        db.close();

    }

    public void delete()
    {
        SQLiteDatabase db = getWritableDatabase();
        /*db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME
                + "=\"" + productName + "\";");*/

        //delete everything
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE 1");
    }

    public String print()
    {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1";

        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();

        while(!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex("productname")) != null)
            {
                dbString += c.getString(c.getColumnIndex("productname"));
                dbString += "\n";
            }

            c.moveToNext();
        }

        db.close();
        return dbString;

    }

    public static synchronized DBHandler getInstance(Context context)
    {
        if(sInstance == null)
        {
            sInstance = new DBHandler(context.getApplicationContext());
        }

        return sInstance;
    }
}
