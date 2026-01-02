package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText eName, eLoc, eId;
    Button bAdd, bView, bUpdate, bDelete;
    TextView t1;

    MyHelper myhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myhelper = new MyHelper(this);

        eName = findViewById(R.id.name);
        eLoc = findViewById(R.id.loc);
        eId = findViewById(R.id.id);   // field for deptid
        bAdd = findViewById(R.id.add);
        bView = findViewById(R.id.view);
        bUpdate = findViewById(R.id.update);
        bDelete = findViewById(R.id.delete);
        t1 = findViewById(R.id.textall);

        bAdd.setOnClickListener(this);
        bView.setOnClickListener(this);
        bUpdate.setOnClickListener(this);
        bDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.add) {
            String id = eId.getText().toString().trim();
            String name = eName.getText().toString().trim();
            String loc = eLoc.getText().toString().trim();

            if (id.isEmpty() || name.isEmpty() || loc.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            long rowId = myhelper.insertData(id, name, loc);

            if (rowId > 0)
                Toast.makeText(this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Insert Failed (Duplicate ID?)", Toast.LENGTH_SHORT).show();
        }

        if (v.getId() == R.id.view) {
            String data = myhelper.getAllData();
            t1.setText(data);
        }

        if (v.getId() == R.id.update) {
            String id = eId.getText().toString().trim();
            String name = eName.getText().toString().trim();
            String loc = eLoc.getText().toString().trim();

            if (id.isEmpty()) {
                Toast.makeText(this, "Enter ID to update", Toast.LENGTH_SHORT).show();
                return;
            }

            int count = myhelper.updateData(id, name, loc);

            if (count > 0)
                Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Update Failed (ID not found)", Toast.LENGTH_SHORT).show();
        }

        if (v.getId() == R.id.delete) {
            String id = eId.getText().toString().trim();

            if (id.isEmpty()) {
                Toast.makeText(this, "Enter ID to delete", Toast.LENGTH_SHORT).show();
                return;
            }

            int count = myhelper.deleteData(id);

            if (count > 0)
                Toast.makeText(this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Delete Failed (ID not found)", Toast.LENGTH_SHORT).show();
        }
    }

    // Helper Class
    class MyHelper extends SQLiteOpenHelper {

        MyHelper(Context c) {
            super(c, "deptDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE dept(" +
                    "deptid INTEGER PRIMARY KEY," +   // user must enter unique ID
                    "name TEXT," +
                    "location TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
            db.execSQL("DROP TABLE IF EXISTS dept");
            onCreate(db);
        }

        public long insertData(String id, String username, String location) {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("deptid", id);
            cv.put("name", username);
            cv.put("location", location);
            return db.insert("dept", null, cv);  // returns -1 if duplicate ID
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
            cr.close();  // close cursor
            return buffer.toString();
        }

        public int updateData(String id, String username, String location) {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("name", username);
            cv.put("location", location);
            return db.update("dept", cv, "deptid=?", new String[]{id});
        }

        public int deleteData(String id) {
            SQLiteDatabase db = getWritableDatabase();
            return db.delete("dept", "deptid=?", new String[]{id});
        }
    }
}
