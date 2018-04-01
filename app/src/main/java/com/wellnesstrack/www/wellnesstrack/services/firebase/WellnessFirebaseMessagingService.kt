package com.wellnesstrack.www.wellnesstrack.services.firebase

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.util.Log

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.wellnesstrack.www.wellnesstrack.R
import com.wellnesstrack.www.wellnesstrack.activities.MainActivity

class WellnessFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        //        Toast.makeText(getApplicationContext(), remoteMessage.getNotification().getBody(),
        //                Toast.LENGTH_LONG).show();
        // Start activity with the questions
        // startActivity(new Intent(this, MainActivity.class));
        if (remoteMessage != null) {
            sendNotification(remoteMessage)
            Log.d(TAG, "message received: " + remoteMessage)
        }
    }

    /**
     * Create and show a simple notification containing the received FCM message.

     * @param remoteMessage FCM RemoteMessage received.
     */
    private fun sendNotification(remoteMessage: RemoteMessage) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT)

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        //        .setContentTitle(remoteMessage.getFrom()) // shows the phone number origination
        var notificationBuilder: NotificationCompat.Builder = NotificationCompat.Builder(this)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(remoteMessage.notification!!.body)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)

        notificationBuilder = notificationBuilder.setSmallIcon(getNotificationIcon(notificationBuilder))

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())
    }

    private fun getNotificationIcon(notificationBuilder: NotificationCompat.Builder): Int {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val color = 0x008000
            notificationBuilder.color = color
            return R.drawable.sun_icon_trans

        } else {
            return R.drawable.sun_icon_trans
        }
    }

    companion object {
        private val TAG = WellnessFirebaseMessagingService::class.java.getSimpleName()
    }
}
