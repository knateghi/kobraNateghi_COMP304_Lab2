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

public class SmiDetachedActivity extends AppCompatActivity {


    HomeAdapter homeAdapter;
    ListView homeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smi_detached);

        homeList= (ListView)findViewById(R.id.listView3);
        setTitle("Semi-detached homes");
        ArrayList<Home> homesArrayList= new ArrayList<>();
        homesArrayList.add(new Home( R.drawable.semidetached1, "8 Mercer Street, Toronto, Ontario", "$1,059,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.semidetached2, "35 Eakins Dr, Aurora, Ontario", "$988,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.semidetached3, "88 Blue Jays Way, Toronto, Ontario", "$429,900 CAD" ));
        homesArrayList.add(new Home( R.drawable.semidetached4, "395 Fairway, Tecumseh, Ontario", "$899,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.semidetached5, "770 Bay Street, Toronto, Ontario", "$949,000 CAD" ));

        homeAdapter = new HomeAdapter(this,homesArrayList);
        homeList.setAdapter(homeAdapter);

        Toast.makeText(this, "Hello from  smi_detached", Toast.LENGTH_SHORT).show();

        homeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SmiDetachedActivity.this, "hello from list", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        menu.getItem(2).setEnabled(false);
        return true;
    }
    public void goToSelectedHomes(View view)
    {
        Intent intent = new Intent(getApplicationContext(), SelectedHomes.class);
        startActivity(intent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.apartment:
                Toast.makeText(this, "you clicked Apartment", Toast.LENGTH_SHORT).show();
                intent = new Intent(SmiDetachedActivity.this, ApartmentActivity.class);
                startActivity(intent);
                return true;

            case R.id.detached_home:
                Toast.makeText(this, "you clicked detached_home", Toast.LENGTH_SHORT).show();
                intent = new Intent(SmiDetachedActivity.this, DetachedActivity.class);
                startActivity(intent);
                return true;

            case R.id.condominium_apartment:
                Toast.makeText(this, "you clicked Condominium", Toast.LENGTH_SHORT).show();
                intent = new Intent(SmiDetachedActivity.this, CondominiumActivity.class);
                startActivity(intent);
                return true;
            case R.id.town_house:
                Toast.makeText(this, "you clicked Town House", Toast.LENGTH_SHORT).show();
                intent = new Intent(SmiDetachedActivity.this, TownHouseActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
