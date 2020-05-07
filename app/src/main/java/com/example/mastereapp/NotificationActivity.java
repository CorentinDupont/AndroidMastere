package com.example.mastereapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NotificationActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // cas Android 8 et plus :
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && manager != null)
        {
            // description du groupe :
            NotificationChannel channel = new NotificationChannel("groupe1",
                    "Nom du groupe", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Description du groupe");
            channel.enableLights(true);
            // comportement des notifications du groupe :
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{100, 200, 300});
            manager.createNotificationChannel(channel);
        }

        // construction notification :
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "groupe1")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Ma notification")
            .setAutoCancel(true)
            .setContentText("Bienvenue !");

        Intent intent = new Intent(this, NotificationActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // ajoute la back stack de l'activité à afficher :
        stackBuilder.addParentStack(NotificationActivity.class);
        // ajoute l'intent en haut de la stack :
        stackBuilder.addNextIntent(intent);


        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        // affichage notification (si ID existant, remplace la précédente) :
        manager.notify(1234, builder.build());
    }
}
