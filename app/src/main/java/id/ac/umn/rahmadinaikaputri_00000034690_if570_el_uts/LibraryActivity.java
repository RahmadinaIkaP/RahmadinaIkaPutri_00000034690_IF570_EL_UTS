package id.ac.umn.rahmadinaikaputri_00000034690_if570_el_uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.LinkedList;

public class LibraryActivity extends AppCompatActivity {
    Toolbar toolbar2;
    RecyclerView rvListSfx;
    DaftarSfxAdapter mAdapter;
    LinkedList<DaftarSfx> daftarSfx = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);

        Intent uIntent = getIntent();
        String usernameKiriman = uIntent.getStringExtra("namaUser");

        getSupportActionBar().setTitle(usernameKiriman);

        isiDaftarSfx();
        rvListSfx = (RecyclerView) findViewById(R.id.recyclerViewSfx);
        rvListSfx.setHasFixedSize(true);
        mAdapter = new DaftarSfxAdapter(this,this, daftarSfx);
        rvListSfx.setAdapter(mAdapter);
        rvListSfx.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiDaftarSfx(){
        daftarSfx.add(new DaftarSfx("Annyeonghaseyo", "Junkyu Iconic Line", "android.resource://"
                +getPackageName()+ "/" + R.raw.annyeonghaseyo));
        daftarSfx.add(new DaftarSfx("Burgir", "Boorgir", "android.resource://"
                +getPackageName()+ "/" + R.raw.burgir));
        daftarSfx.add(new DaftarSfx("Ding Dong~", "Jungkook Iconic Line", "android.resource://"
                +getPackageName()+ "/" + R.raw.dingdong));
        daftarSfx.add(new DaftarSfx("No God Please No", "Reaksi aku ketika deadline nambah :(", "android.resource://"
                +getPackageName()+ "/" + R.raw.no_god_please_no));
        daftarSfx.add(new DaftarSfx("무궁화 꽃 이 피었 습니다", "Ketagihan nonton Squid Game :(", "android.resource://"
                +getPackageName()+ "/" + R.raw.red_light_green_light));
        daftarSfx.add(new DaftarSfx("Wow", "omg wow", "android.resource://"
                +getPackageName()+ "/" + R.raw.wow));
    }

    // Untuk tombol profile dan home pada toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.toProfile:
                Intent backProfileIntent = new Intent(LibraryActivity.this, ProfileActivity.class);
                startActivity(backProfileIntent);
                return true;
            case  R.id.toHome:
                Intent backHomeIntent = new Intent(LibraryActivity.this, MainActivity.class);
                backHomeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(backHomeIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.library_menu, menu);
        return true;
    }

    //Untuk transisi
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}