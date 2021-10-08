package id.ac.umn.rahmadinaikaputri_00000034690_if570_el_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

public class DetailSfxActivity extends AppCompatActivity {
    Toolbar toolbar3;
    TextView dJudulSfx, dKeteranganSfx;
    Button playBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sfx);

        toolbar3 = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        dJudulSfx = (TextView) findViewById(R.id.dJudulSfx);
        dKeteranganSfx = (TextView) findViewById(R.id.dKeteranganSfx);
        playBtn = (Button) findViewById(R.id.btnPlay);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        DaftarSfx ds = (DaftarSfx) bundle.getSerializable("DetailSfx");

        getSupportActionBar().setTitle(ds.getJudulSfx());

        dJudulSfx.setText(ds.getJudulSfx());
        dKeteranganSfx.setText(ds.getKeteranganSfx());

        MediaPlayer mPlayer;
        Uri songUri = Uri.parse(ds.getSfxURI());
        mPlayer = MediaPlayer.create(this,songUri);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.start();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        finish();
        return true;
    }

    //Untuk transisi
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}