package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String contacts[]={"File1","File2","File3","File4","File5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.list);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(adapter);
        // Register the ListView  for Context menu
        registerForContextMenu(listView);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Select ");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.Add){
            Toast.makeText(this, ""+item.getTitle()+" clicked", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.Edit){
            Toast.makeText(this, ""+item.getTitle()+" clicked", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.Delete){
            Toast.makeText(this, ""+item.getTitle()+" clicked", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId()==R.id.Share){
            Toast.makeText(this, ""+item.getTitle()+" clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}