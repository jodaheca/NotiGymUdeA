package notificaciones.udea.edu.co.notigymudea;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * @author Joaquin Hernandez
 * Activity principal que se ejecuta cuando abrimos la aplicación.
 */
public class CrearNotificacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_notificacion);
    }
    /**
     *
     * @param view
     */
   public void crearNotificacion(View view){
       // Preparamos el Intent que sera el encargado de llamar el metodo que activa la notificación
       Intent intent = new Intent(this, ReceptorNotificacionActivity.class);
       PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

       // Contruimos la notificación
       Notification noti = new Notification.Builder(this)
               .setContentTitle("Sistema del gimnasio de la UdeA")
               .setContentText("Recordatorio de asistencia").setSmallIcon(R.drawable.notification_template_icon_bg)
               .setContentIntent(pIntent)
               .addAction(R.drawable.notification_template_icon_bg, "Ver", pIntent)
               .addAction(R.drawable.notification_template_icon_bg, "Ignorar", pIntent).build();
       NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
       // Despues de tocar la notificación esta desaparece
       noti.flags |= Notification.FLAG_AUTO_CANCEL;

       // Metodo para que la notificación suene al llegar y haga vibrar el celular al llegar
       noti.defaults |= Notification.DEFAULT_SOUND;
       noti.defaults |= Notification.DEFAULT_VIBRATE;

       notificationManager.notify(0, noti);
   }
}
