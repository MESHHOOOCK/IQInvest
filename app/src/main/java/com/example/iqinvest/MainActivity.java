 package com.example.iqinvest;

 import androidx.appcompat.app.ActionBarDrawerToggle;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.appcompat.widget.Toolbar;
 import androidx.core.view.GravityCompat;
 import androidx.drawerlayout.widget.DrawerLayout;

 import android.content.SharedPreferences;
 import android.os.Bundle;
 import android.view.Menu;
 import android.view.MenuItem;
 import android.view.View;
 import android.widget.Button;
 import android.widget.TextView;

 import com.google.android.material.navigation.NavigationView;

 public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
  private int balance;
  private int clicks;
  private int totalEarnings;
  private int passiveIncome;
  private Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_main);

   if (savedInstanceState != null) {
    balance = savedInstanceState.getInt("balance");
    clicks = savedInstanceState.getInt("clicks");
    totalEarnings = savedInstanceState.getInt("totalEarnings");
    passiveIncome = savedInstanceState.getInt("passiveIncome");
   }

   DrawerLayout drawer = findViewById(R.id.drawer_layout);
   ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
           this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
   drawer.addDrawerListener(toggle);
   toggle.syncState();

   NavigationView navigationView = findViewById(R.id.nav_view);
   navigationView.setNavigationItemSelectedListener(this);
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
   outState.putInt("balance", balance);
   outState.putInt("clicks", clicks);
   outState.putInt("totalEarnings", totalEarnings);
   outState.putInt("passiveIncome", passiveIncome);
   super.onSaveInstanceState(outState);
  }

  // Обработка выбора пунктов меню в боковом меню
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
   int id = item.getItemId();

   if (id == R.id.action_earning) {
    // Переключение на фрагмент EarningFragment
    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EarningFragment()).commit();
   } else if (id == R.id.action_account_stats) {
    // Переключение на фрагмент AccountStatsFragment
    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AccountStatsFragment()).commit();
   } else if (id == R.id.action_shop) {
    // Переключение на фрагмент ShopFragment
    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShopFragment()).commit();
   }

   DrawerLayout drawer = findViewById(R.id.drawer_layout);
   drawer.closeDrawer(GravityCompat.START);
   return true;
  }
 }