package com.example.patrick.test;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity
    implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    private SearchManager searchManager;
    private android.widget.SearchView searchView;
    private MyExpandableListAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<ParentRow> parentList = new ArrayList<ParentRow>();
    private ArrayList<ParentRow> showTheseParentList = new ArrayList<ParentRow>();
    private MenuItem searchItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        parentList = new ArrayList<ParentRow>();
        showTheseParentList = new ArrayList<ParentRow>();

        displayList();

        expandAll();
    }

    //add things on the list here.
    private void loadData(){
        ArrayList<ChildRow> childRows = new ArrayList<ChildRow>();
        ParentRow parentRow = null;

        childRows.add(new ChildRow(R.mipmap.ic_launcher,
                "Bournes Building"));
//        childRows.add(new ChildRow(R.mipmap.ic_launcher,
//                "Bournes Building"));
        parentRow = new ParentRow("Riverside", childRows);
        parentList.add(parentRow);


//        childRows = new ArrayList<ChildRow>();
//        childRows.add(new ChildRow(R.mipmap.ic_launcher,
//                "Bournes Building"));
////        childRows.add(new ChildRow(R.mipmap.ic_launcher,
////                "Bournes Building"));
//        parentRow = new ParentRow("Riverside", childRows);
//        parentList.add(parentRow);
    }

    private void expandAll(){
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            myList.expandGroup(i);
        }
    }

    private void displayList(){
        loadData();

        myList = (ExpandableListView) findViewById(R.id.expandableListView_search);
        listAdapter = new MyExpandableListAdapter(Main2Activity.this, parentList);

        myList.setAdapter(listAdapter);
    }

    @Override
    public boolean onClose() {
        listAdapter.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.filterData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapter.filterData(newText);
        expandAll();
        return false;
    }
}
