package com.example.pcworld.return0_final;


import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;


public class freg1 extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private FragmentManager fragmentManager;
private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freg1);
        drawerLayout = (DrawerLayout) findViewById(R.id.Draw);
        fragmentManager = getSupportFragmentManager();
    }

    public void addFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment).addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
        drawerLayout.closeDrawer(Gravity.LEFT);

    }

    public void onAllProd(View view) {
        MyProd1 myProd1=new MyProd1();
        addFragment(myProd1);
    }

    public void onMyProd(View view) {
        AllPro allPro=new AllPro();
        addFragment(allPro);
    }

    public void onAddProd(View view) {
        AddProd addProd=new AddProd();
        addFragment(addProd);
    }
}
