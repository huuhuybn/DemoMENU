package vn.poly.mob305.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Viet cau lenh
        // intent : chứa các thông tin được gửi tới để service xử lý
        String name = intent
                .getStringExtra("name");
        int age = intent.getIntExtra("Age",
                -1);
        Toast.makeText(this, name,
                Toast.LENGTH_SHORT).show();
        //


        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Good Bye", Toast.LENGTH_SHORT).show();
    }
    

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}