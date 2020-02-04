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

public class CondominiumActivity extends AppCompatActivity {

    ListView homeList;
    HomeAdapter homeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment);

        homeList= (ListView)findViewById(R.id.listView3);
        setTitle("Condos ");
        ArrayList<Home> homesArrayList= new ArrayList<>();
        homesArrayList.add(new Home( R.drawable.condo1, "8 Mercer Street, Toronto, Ontario", "$1,059,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.condo2, "35 Eakins Dr, Aurora, Ontario", "$988,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.condo3, "88 Blue Jays Way, Toronto, Ontario", "$429,900 CAD" ));
        homesArrayList.add(new Home( R.drawable.condo4, "395 Fairway, Tecumseh, Ontario", "$899,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.condo5, "770 Bay Street, Toronto, Ontario", "$949,000 CAD" ));

        homeAdapter = new HomeAdapter(this,homesArrayList);
        homeList.setAdapter(homeAdapter);


        homeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CondominiumActivity.this, "Hello from Main Menu", Toast.LENGTH_SHORT).show();

                switch (position){
                    case 0:
                        Intent intent = new Intent(CondominiumActivity.this,ApartmentActivity.class);
                        startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        menu.getItem(3).setEnabled(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.apartment:
                Toast.makeText(this, "you clicked Apartment", Toast.LENGTH_SHORT).show();
                intent = new Intent(CondominiumActivity.this, ApartmentActivity.class);
                startActivity(intent);
                return true;

            case R.id.detached_home:
                Toast.makeText(this, "you clicked detached_home", Toast.LENGTH_SHORT).show();
                intent = new Intent(CondominiumActivity.this, DetachedActivity.class);
                startActivity(intent);
                return true;
            case R.id.semiDetached_home:
                Toast.makeText(this, "you clicked Semi-detached_home", Toast.LENGTH_SHORT).show();
                intent = new Intent(CondominiumActivity.this, SmiDetachedActivity.class);
                startActivity(intent);
                return true;

            case R.id.town_house:
                Toast.makeText(this, "you clicked Town House", Toast.LENGTH_SHORT).show();
                intent = new Intent(CondominiumActivity.this, TownHouseActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void goToSelectedHomes(View view)
    {
        Intent intent = new Intent(getApplicationContext(), SelectedHomes.class);
        startActivity(intent);
    }
}
