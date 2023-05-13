package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import sg.edu.np.mad.madpractical.week2prac.MainActivity;
import com.example.week2prac.R;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    final String TITLE = "List Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "On Start:");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TITLE, "On Resume:");

        ImageView image;

        image = findViewById(R.id.imageView);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, "Image pressed.");
                imageAlert();

            }
        });

    }
    protected void onPause(){

        super.onPause();
        Log.v(TITLE, "On Pause:");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TITLE, "On Stop:");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TITLE, "On Destroy:");
    }

    private void imageAlert(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                int num = generateRanNum();
                Intent myIntent = new Intent(ListActivity.this,MainActivity.class);
                myIntent.putExtra("ran number",num);
                startActivity(myIntent);
                Log.v(TITLE,"random number: " + num);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
    private int generateRanNum(){
        Random ran = new Random();
        int myNumber = ran.nextInt(99999999);
        return myNumber;
    };


}