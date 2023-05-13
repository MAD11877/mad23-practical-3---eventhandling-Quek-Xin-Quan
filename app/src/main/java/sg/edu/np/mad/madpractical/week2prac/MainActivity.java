package sg.edu.np.mad.madpractical.week2prac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.week2prac.R;

import sg.edu.np.mad.madpractical.MessageGroup;

public class MainActivity extends AppCompatActivity {
    final String TITLE = "Main Activity";
    User user1;
    Button followButton;
    Button messageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TITLE, "On Create:");
        Intent myRecIntent = getIntent();
        int num;
        num = myRecIntent.getIntExtra("ran number",0);

        TextView myTextview;

        myTextview = findViewById(R.id.textView);
        myTextview.setText("MAD "+num);
        messageButton = findViewById(R.id.button2);
        user1 = new User("user1","hello",001,false);
        followButton =findViewById(R.id.button);
        if (user1.Followed)
        {
            followButton.setText("Unfollow");
        }
        else
        {
            followButton.setText("Follow");
        }

    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "On Start:");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TITLE, "On Resume:");
        followButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)

            {
                if (user1.Followed)
                {
                    user1.Followed = false;
                    followButton.setText("Follow");
                    Log.v(TITLE,"follow");
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();

                }
                else {
                    user1.Followed = true;
                    followButton.setText("Unfollow");
                    Log.v(TITLE,"Unfollow");
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                }


            }

        }
        );
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE,"Message Button pressed");
                Intent messageGroup = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(messageGroup);
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

}