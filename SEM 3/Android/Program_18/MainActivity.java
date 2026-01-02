package com.example.task_tracker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int taskCount = 0;
    private TextView countTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTextView = findViewById(R.id.countTextView);
        Button addTaskButton = findViewById(R.id.addTaskButton);
        Button clearTasksButton = findViewById(R.id.clearTasksButton);

        updateCount();

        addTaskButton.setOnClickListener(v -> {
            taskCount++;
            updateCount();
        });

        clearTasksButton.setOnClickListener(v -> {
            taskCount = 0;
            updateCount();
        });
    }

    private void updateCount() {
        countTextView.setText("Tasks: " + taskCount);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_reset) {
            taskCount = 0;
            updateCount();
            return true;
        } else if (id == R.id.menu_about) {
            Toast.makeText(this, "Task Tracker v1.0", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
