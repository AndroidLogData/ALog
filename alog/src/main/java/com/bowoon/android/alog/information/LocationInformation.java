package com.bowoon.android.alog.information;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;

public class LocationInformation {
    private Location userLocation;
    private LocationManager locationManager;

    public LocationInformation(Context context) {
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        if (Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        if (locationManager != null) {
            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                locationManager.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER,
                        1000,
                        10,
                        locationListener
                );
                userLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                Log.i("listener", String.valueOf(userLocation.getLatitude()));
                Log.i("listener", String.valueOf(userLocation.getLongitude()));
            }
        }
    }

    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            userLocation = location;
            Log.i("Longitude", String.valueOf(location.getLongitude()));
            Log.i("Latitude", String.valueOf(location.getLatitude()));
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    };

    public Location getUserLocation() {
        return userLocation;
    }

    public void stopLocation() {
        locationManager.removeUpdates(locationListener);
    }
}
