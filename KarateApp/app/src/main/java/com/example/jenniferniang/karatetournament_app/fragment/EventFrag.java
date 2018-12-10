package com.example.jenniferniang.karatetournament_app.fragment;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jenniferniang.karatetournament_app.R;

import com.example.jenniferniang.karatetournament_app.activity.AddEditEventActivity;
import com.example.jenniferniang.karatetournament_app.db.Event;
import com.example.jenniferniang.karatetournament_app.general.EventAdapter;
import com.example.jenniferniang.karatetournament_app.viewModel.EventViewModel;


import java.util.List;

public class EventFrag extends Fragment {

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_event, container, false);
//
//        return view;
//    }

    public static final int ADD_EVENT_REQUEST = 1;
    public static final int EDIT_EVENT_REQUEST = 2;

    private  EventViewModel eventViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        FloatingActionButton buttonAddEvent = view.findViewById(R.id.btn_add_event);
        buttonAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddEditEventActivity.class);
                startActivityForResult(intent, ADD_EVENT_REQUEST);
            }
        });


        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        final EventAdapter adapter = new EventAdapter();
        recyclerView.setAdapter(adapter);



        //ViewModelProvider.Factory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        // ViewModelProvider viewModelProvider = new ViewModelProvider(this, factory);
        // eventViewModel = viewModelProvider.get(EventViewModel.class);

        eventViewModel.getAllEvents().observe(this, new Observer<List<Event>>() {
            @Override
            public void onChanged(@Nullable List<Event> events) {
                //update Recycler View
                //Toast.makeText(MainActivity.this, "UnChanged", Toast.LENGTH_SHORT).show();
                adapter.submitList(events);
            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                eventViewModel.delete(adapter.getEventAt(viewHolder.getAdapterPosition()));
                Toast.makeText(getActivity(), "Event Deleted", Toast.LENGTH_SHORT).show();

            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new EventAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Event event) {
                Intent intent = new Intent(getActivity(), AddEditEventActivity.class);
                intent.putExtra(AddEditEventActivity.EXTRA_ID, event.getId());
                intent.putExtra(AddEditEventActivity.EXTRA_TITLE, event.getTitle());
                intent.putExtra(AddEditEventActivity.EXTRA_DESCRIPTION, event.getDescription());
                intent.putExtra(AddEditEventActivity.EXTRA_PRIORITY, event.getPriority());

                startActivityForResult(intent, EDIT_EVENT_REQUEST);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_EVENT_REQUEST && resultCode == getActivity().RESULT_OK){
            String title = data.getStringExtra(AddEditEventActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddEditEventActivity.EXTRA_DESCRIPTION);
            int priority = data.getIntExtra(AddEditEventActivity.EXTRA_PRIORITY, 1);

            Event event = new Event(title, description,priority);
            eventViewModel.insert(event);

            Toast.makeText(getActivity(), "Event Saved", Toast.LENGTH_SHORT).show();
        } else if(requestCode == EDIT_EVENT_REQUEST && resultCode == getActivity().RESULT_OK){
            int id = data.getIntExtra(AddEditEventActivity.EXTRA_ID,-1);

            if(id == -1){
                Toast.makeText(getActivity(), "Event Can't Be Updated", Toast.LENGTH_SHORT).show();
                return;
            }
            String title = data.getStringExtra(AddEditEventActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddEditEventActivity.EXTRA_DESCRIPTION);
            int priority = data.getIntExtra(AddEditEventActivity.EXTRA_PRIORITY, 1);

            Event event = new Event(title, description, priority);
            event.setId(id);
            eventViewModel.update(event);

            Toast.makeText(getActivity(), "Event Updated", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getActivity(), "Event Not Saved", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
//        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
//        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete_all_events:
                eventViewModel.deleteAllEvents();
                Toast.makeText(getActivity(), "All Events Deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
