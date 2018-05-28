package com.a16046562.demoalarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnsetalarmm;
    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsetalarmm = (Button) this.findViewById(R.id.btnsetalarm);
        btnsetalarmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND,5);

                //create pendingintent and add to alarmmanager
                Intent intent = new Intent(MainActivity.this, alarmreceiveractivity.class);
                int reqcode = 12345;
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, reqcode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                //get alarmmanager instance
                am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                //set alarm
                am.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pendingIntent);
            }
        });

    }
}
