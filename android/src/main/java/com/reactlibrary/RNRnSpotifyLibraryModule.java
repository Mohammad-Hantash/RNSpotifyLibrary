
package com.reactlibrary;

import android.os.Debug;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;

public class RNRnSpotifyLibraryModule extends ReactContextBaseJavaModule {

  private SpotifyAppRemote mSpotifyAppRemote;
  private final ReactApplicationContext reactContext;

  public RNRnSpotifyLibraryModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNRnSpotifyLibrary";
  }

  @ReactMethod
  public void initialize(String clientId) {
    //final int imageSize = (int) getResources().getDimension(R.dimen.image_size);

    if (mSpotifyAppRemote != null && mSpotifyAppRemote.isConnected()) {
      SpotifyAppRemote.CONNECTOR.disconnect(mSpotifyAppRemote);
      mSpotifyAppRemote = null;
    }

    SpotifyAppRemote.CONNECTOR.connect(
            this.reactContext.getApplicationContext(),
            new ConnectionParams.Builder(clientId)
                    .setRedirectUri("comspotifytestsdk://callback")
                    .setPreferredImageSize(0)
                    .showAuthView(true)
                    .build(),
            new Connector.ConnectionListener() {
              @Override
              public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                mSpotifyAppRemote = spotifyAppRemote;

              }

              @Override
              public void onFailure(Throwable error) {
                  Log.d("SPOTIFY",String.format("Connection failed: %s", error));
              }
            });
  }
}