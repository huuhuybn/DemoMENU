package vn.poly.mob305.myapplication;


import static vn.poly.mob305.myapplication.ConfigApp.CHANNEL_ID;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import android.Manifest;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showNotification(this,"hello","OK OK",
                222);
    }


    // Phương thức để hiển thị notification
    public void showNotification(Context context, String title, String content, int notificationId) {
        // Tạo notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Lấy NotificationManager từ hệ thống
        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);

        // hoi user -> xin quyen bat thong bao
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.POST_NOTIFICATIONS)
         == PackageManager.PERMISSION_GRANTED){
            // Hiển thị notification
            notificationManager.notify(notificationId, builder.build());
        }else {
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.POST_NOTIFICATIONS
            },999);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 999) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Ban da dong y cho bat thong bao !!!",
                        Toast.LENGTH_SHORT).show();
                showNotification(this,"hello","OK OK",
                        222);
            }
        }
    }
}