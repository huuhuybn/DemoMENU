package vn.poly.mob305.myapplication;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

public class ConfigApp extends Application {

    // Định nghĩa ID của channel
    public static final String CHANNEL_ID = "my_channel_id";
    public static final CharSequence CHANNEL_NAME = "My Channel";
    private static final String CHANNEL_DESCRIPTION = "Description of my channel";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel(this);
    }
    // Phương thức để tạo và thiết lập channel
    public static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription(CHANNEL_DESCRIPTION);

            // Lấy NotificationManager từ hệ thống
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);


            // Tạo channel
            notificationManager.createNotificationChannel(channel);
        }
    }



}
