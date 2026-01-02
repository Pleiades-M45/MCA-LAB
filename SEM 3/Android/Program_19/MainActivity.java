package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText eName, eLoc;
    Button bAdd, bView;
    TextView t1;

    MyHelper myhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myhelper = new MyHelper(this);

        eName = findViewById(R.id.name);
        eLoc = findViewById(R.id.loc);
        bAdd = findViewById(R.id.add);
        bView = findViewById(R.id.view);
        t1 = findViewById(R.id.textall);

        bAdd.setOnClickListener(this);
        bView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.add) {
            String name = eName.getText().toString();
            String loc = eLoc.getText().toString();

            long id = myhelper.insertData(name, loc);

            if (id > 0)
                Toast.makeText(this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Insert Failed", Toast.LENGTH_SHORT).show();
        }

        if (v.getId() == R.id.view) {
            String data = myhelper.getAllData();
            t1.setText(data);
        }
    }

    // -----------------------------
    // Helper Class (Your Style)
    // -----------------------------
    class MyHelper extends SQLiteOpenHelper {

        MyHelper(Context c) {
            super(c, "deptDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE dept(" +
                    "deptid INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "location TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
            db.execSQL("DROP TABLE IF EXISTS dept");
            onCreate(db);
        }

        public long insertData(String username, String location) {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("name", username);
            cv.put("location", location);
            return db.insert("dept", null, cv);
        }

        public String getAllData() {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cr = db.rawQuery("SELECT * FROM dept", null);

            StringBuilder buffer = new StringBuilder();

            while (cr.moveToNext()) {
                buffer.append(cr.getInt(0)).append(" --- ");
                buffer.append(cr.getString(1)).append(" --- ");
                buffer.append(cr.getString(2)).append("\n");
            }
            return buffer.toString();
        }
    }
}
