package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    private DrawerLayout drawer;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationview =findViewById(R.id.nav_view);
        navigationview.setNavigationItemSelectedListener(this);
        fab = findViewById(R.id.fab);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_open,R.string.navigation_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new tab()).commit();

        navigationview.setCheckedItem(R.id.nav_home);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new tab()).commit();
                fab = findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, "Hello", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
                break;
            case R.id.nav_calendar:
                //TODO:Remove this tab fragment and create a calendar module and add the activity
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new tab()).commit();
                fab = findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, "Hello", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
        super.onBackPressed();}
    }
}