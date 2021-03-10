package com.example.rateapp

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.DialogTitle
import hotchemi.android.rate.AppRate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*

            The default functions such as setInstallDays allows the dialog box to appear after a certain number of days from the day of install of the app,
            setLaunchTimes  is the minimum number of times the app should be launched by the user and setRemindInterval is the number of days after which the
             dialog box comes after the user chooses the neutral option (Remind me later).

        */


        // Here 0 means
        // the installation date.
        AppRate.with(this)
                .setInstallDays(0) // default 10, 0 means install day.
                .setLaunchTimes(3) // default 10
                .setRemindInterval(2) // default 1
                .setShowLaterButton(true) // default true
                .setDebug(false) // default false
                .setOnClickButtonListener {
                    when(it) {
                        DialogInterface.BUTTON_POSITIVE ->
                            Toast.makeText(this, "Rate app Clicked", Toast.LENGTH_SHORT).show()

                        DialogInterface.BUTTON_NEGATIVE ->
                            Toast.makeText(this, "Cancel Clicked", Toast.LENGTH_SHORT).show()

                        DialogInterface.BUTTON_NEUTRAL ->
                            Toast.makeText(this, "Rate later clicked", Toast.LENGTH_SHORT).show()
                    }
                }
                .monitor();




        
        // Show a dialogue
        // if meets conditions
        AppRate.showRateDialogIfMeetsConditions(this)

    }
}