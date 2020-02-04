package com.example.kobraNateghi_COMP304_Lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetachedActivity extends AppCompatActivity {

    ListView homeList;
    HomeAdapter homeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detached);

        homeList= (ListView)findViewById(R.id.listView3);
        setTitle("Detached Homes");
        ArrayList<Home> homesArrayList= new ArrayList<>();
        homesArrayList.add(new Home( R.drawable.detached1, "8 Mercer Street, Toronto, Ontario", "$1,059,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.detached2, "35 Eakins Dr, Aurora, Ontario", "$988,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.detached3, "88 Blue Jays Way, Toronto, Ontario", "$429,900 CAD" ));
        homesArrayList.add(new Home( R.drawable.detached4, "395 Fairway, Tecumseh, Ontario", "$899,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.detached5, "770 Bay Street, Toronto, Ontario", "$949,000 CAD" ));

        homeAdapter = new HomeAdapter(this,homesArrayList);
        homeList.setAdapter(homeAdapter);


        homeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DetachedActivity.this, "Hello from Main Menu", Toast.LENGTH_SHORT).show();

                switch (position){
                    case 0:
                        Intent intent = new Intent(DetachedActivity.this,ApartmentActivity.class);
                        startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        menu.getItem(1).setEnabled(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        //Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {


            case R.id.apartment:
                Toast.makeText(getApplicationContext(), "you clicked detached home", Toast.LENGTH_SHORT).show();
                intent= new Intent(DetachedActivity.this,ApartmentActivity.class);
                startActivity(intent);
                return true;
            case R.id.semiDetached_home:
                intent= new Intent(DetachedActivity.this,SmiDetachedActivity.class);
                startActivity(intent);
                return true;
            case R.id.condominium_apartment:
                Toast.makeText(this, "You click Show Condominium", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.town_house:
                Toast.makeText(this, "You click Show Town House", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
