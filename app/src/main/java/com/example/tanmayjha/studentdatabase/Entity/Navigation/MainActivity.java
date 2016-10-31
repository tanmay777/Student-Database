package com.example.tanmayjha.studentdatabase.Entity.Navigation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tanmayjha.studentdatabase.Entity.About.AboutFragment;
import com.example.tanmayjha.studentdatabase.Entity.AddStudentDetails.AddStudentDetailFragment;
import com.example.tanmayjha.studentdatabase.Entity.FamilyDetails.FamilyDetailsFragment;
import com.example.tanmayjha.studentdatabase.Entity.GuardianDetails.GuardianDetailFragment;
import com.example.tanmayjha.studentdatabase.Entity.ProctorDetails.ProctorDetailsFragment;
import com.example.tanmayjha.studentdatabase.Entity.StudentDetails.StudentDetailsFragment;
import com.example.tanmayjha.studentdatabase.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        AddStudentDetailFragment studentDetailFragment=new AddStudentDetailFragment();
        ft.replace(R.id.container,studentDetailFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();

        if (id == R.id.nav_add_data) {
            AddStudentDetailFragment addStudentDetailFragment=new AddStudentDetailFragment();
            ft.replace(R.id.container,addStudentDetailFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else if (id == R.id.nav_student_detail) {
            StudentDetailsFragment studentDetailsFragment=new StudentDetailsFragment();
            ft.replace(R.id.container,studentDetailsFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else if (id == R.id.nav_family_detail) {
            FamilyDetailsFragment familyDetailsFragment=new FamilyDetailsFragment();
            ft.replace(R.id.container,familyDetailsFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else if (id == R.id.nav_proctor_detail) {
            ProctorDetailsFragment proctorDetailsFragment=new ProctorDetailsFragment();
            ft.replace(R.id.container,proctorDetailsFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else if (id == R.id.nav_guardian_detail) {
            GuardianDetailFragment guardianDetailFragment=new GuardianDetailFragment();
            ft.replace(R.id.container,guardianDetailFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else if (id == R.id.nav_about) {
            AboutFragment aboutFragment=new AboutFragment();
            ft.replace(R.id.container,aboutFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
