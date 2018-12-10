package com.example.jenniferniang.karatetournament_app.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.jenniferniang.karatetournament_app.R;
import com.example.jenniferniang.karatetournament_app.db.Event;
import com.example.jenniferniang.karatetournament_app.general.EventAdapter;
import com.example.jenniferniang.karatetournament_app.viewModel.EventViewModel;

import java.util.List;

public class EventActivity extends AppCompatActivity {

    public static final int ADD_EVENT_REQUEST = 1;
    public static final int EDIT_EVENT_REQUEST = 2;

    private EventViewModel eventViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_event);

        FloatingActionButton buttonAddEvent = findViewById(R.id.btn_add_event);
        buttonAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, AddEditEventActivity.class);
                startActivityForResult(intent, ADD_EVENT_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final EventAdapter adapter = new EventAdapter();
        recyclerView.setAdapter(adapter);

        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        eventViewModel.getAllEvents().observe(this, new Observer<List<Event>>() {
            @Override
            public void onChanged(@Nullable List<Event> events) {
                adapter.submitList(events);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                eventViewModel.delete(adapter.getEventAt(viewHolder.getAdapterPosition()));
                Toast.makeText(EventActivity.this, "Event Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new EventAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Event event) {
                Intent intent = new Intent(EventActivity.this, AddEditEventActivity.class);
                intent.putExtra(AddEditEventActivity.EXTRA_ID, event.getId());
                intent.putExtra(AddEditEventActivity.EXTRA_TITLE, event.getTitle());
                intent.putExtra(AddEditEventActivity.EXTRA_DESCRIPTION, event.getDescription());
                intent.putExtra(AddEditEventActivity.EXTRA_PRIORITY, event.getPriority());
                startActivityForResult(intent, EDIT_EVENT_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_EVENT_REQUEST && resultCode == RESULT_OK) {
            String title = data.getStringExtra(AddEditEventActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddEditEventActivity.EXTRA_DESCRIPTION);
            int priority = data.getIntExtra(AddEditEventActivity.EXTRA_PRIORITY, 1);

            Event event = new Event(title, description, priority);
            eventViewModel.insert(event);

            Toast.makeText(this, "Event Saved", Toast.LENGTH_SHORT).show();
        } else if (requestCode == EDIT_EVENT_REQUEST && resultCode == RESULT_OK) {
            int id = data.getIntExtra(AddEditEventActivity.EXTRA_ID, -1);

            if (id == -1) {
                Toast.makeText(this, "Event Not Updated", Toast.LENGTH_SHORT).show();
                return;
            }

            String title = data.getStringExtra(AddEditEventActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddEditEventActivity.EXTRA_DESCRIPTION);
            int priority = data.getIntExtra(AddEditEventActivity.EXTRA_PRIORITY, 1);

            Event event = new Event(title, description, priority);
            event.setId(id);
            eventViewModel.update(event);

            Toast.makeText(this, "Event Updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Event Not Saved", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all_events:
                eventViewModel.deleteAllEvents();
                Toast.makeText(this, "All Events Deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
