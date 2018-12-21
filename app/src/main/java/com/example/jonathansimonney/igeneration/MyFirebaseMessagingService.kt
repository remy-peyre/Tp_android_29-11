package com.example.jonathansimonney.igeneration

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

public class MyFirebaseMessagingService: FirebaseMessagingService() {

    private lateinit var database: DatabaseReference

    //Méthode appelée chaque foisque le token change
    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        //Envoyer le token
        Log.d("RealToken", "Refreshed token: $token")
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        database = FirebaseDatabase.getInstance().reference
        //        sendRegistrationToServer(token)
        database.child("fcmToken").setValue(token).addOnSuccessListener {
            Log.d("RealToken", "updated token in db: $token")
        }
        .addOnFailureListener {
            Log.e("RealToken", "refused refresh: $it")
        }

    }


    override fun onMessageReceived(message : RemoteMessage) {

        //On récuperer les données envoyées
        message.data;

        // Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated.

        //Log.d(TAG, "From: " + remoteMessage!!.from)
        //Log.d(TAG, "Notification Message Body: " + remoteMessage.notification.body!!)
    }
}
