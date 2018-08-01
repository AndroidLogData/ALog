package com.bowoon.android.alog.information;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

public class BatteryInformation {
    private IntentFilter intentFilter;
    private Intent batteryStatus;

    public BatteryInformation(Context context) {
        this.intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        this.batteryStatus = context.registerReceiver(null, intentFilter);
    }

    public String batteryStatus() {
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

        if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
            return "BATTERY_STATUS_CHARGING";
        } else if (status == BatteryManager.BATTERY_STATUS_FULL) {
            return "BATTERY_STATUS_FULL";
        } else if (status == BatteryManager.BATTERY_STATUS_DISCHARGING) {
            return "BATTERY_STATUS_DISCHARGING";
        } else if (status == BatteryManager.BATTERY_STATUS_NOT_CHARGING) {
            return "BATTERY_STATUS_NOT_CHARGING";
        } else if (status == BatteryManager.BATTERY_STATUS_UNKNOWN) {
            return "BATTERY_STATUS_UNKNOWN";
        }

        return null;
    }

    public String batteryChargeStatus() {
        int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);

        if (chargePlug == BatteryManager.BATTERY_PLUGGED_AC) {
            return "BATTERY_PLUGGED_AC";
        } else if (chargePlug == BatteryManager.BATTERY_PLUGGED_USB) {
            return "BATTERY_PLUGGED_USB";
        }

        return null;
    }
}
