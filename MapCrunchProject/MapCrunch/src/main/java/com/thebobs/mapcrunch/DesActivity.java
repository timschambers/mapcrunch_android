

        package com.thebobs.mapcrunch;

        import android.app.AlertDialog;
        import android.app.SearchManager;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.database.Cursor;
        import android.location.Location;
        import android.os.Bundle;
        import android.support.v4.app.LoaderManager.LoaderCallbacks;
        import android.support.v4.content.CursorLoader;
        import android.support.v4.view.MenuItemCompat;
        import android.support.v7.app.ActionBarActivity;
        import android.support.v7.widget.SearchView;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuItem;

        import com.google.android.gms.common.ConnectionResult;
        import com.google.android.gms.common.GooglePlayServicesClient;
        import com.google.android.gms.location.LocationClient;
        import com.google.android.gms.maps.CameraUpdate;
        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.Marker;
        import com.google.android.gms.maps.model.MarkerOptions;


public class DesActivity extends ActionBarActivity implements LoaderCallbacks<Cursor>, GoogleMap.OnMarkerClickListener, GooglePlayServicesClient.ConnectionCallbacks,
        GooglePlayServicesClient.OnConnectionFailedListener {

    GoogleMap mGoogleMap;
    Marker marker_1;
    Location mCurrentLocation;
    LocationClient mLocationClient;
    double lat = 0;
    double lon = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_des);
System.out.print("here??%%KJHKJ%HJ%J%");
        SupportMapFragment fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mGoogleMap = fragment.getMap();
         mLocationClient = new LocationClient(this, this, this);
        mLocationClient.connect();


        mGoogleMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) this);

        handleIntent(getIntent());
    }

    private void handleIntent(Intent intent){
        if(Intent.ACTION_SEARCH.equals(intent.getAction()))
        {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doSearch(query);
        }
        else if(Intent.ACTION_VIEW.equals(intent.getAction()))
        {
            getPlace(intent.getStringExtra(SearchManager.EXTRA_DATA_KEY));
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    private void doSearch(String query){
        Bundle data = new Bundle();
        data.putString("query", query);
        getSupportLoaderManager().restartLoader(0, data, this);
    }

    private void getPlace(String query){
        Bundle data = new Bundle();
        data.putString("query", query);
        getSupportLoaderManager().restartLoader(1, data, this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);


        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public android.support.v4.content.Loader<Cursor> onCreateLoader(int arg0,
                                                                    Bundle query) {
        CursorLoader cLoader = null;

        if(arg0==0)
            cLoader = new CursorLoader(getBaseContext(), PlaceProvider.SEARCH_URI, null, null, new String[]{ query.getString("query") }, null);
        else if(arg0==1)
            cLoader = new CursorLoader(getBaseContext(), PlaceProvider.DETAILS_URI, null, null, new String[]{ query.getString("query") }, null);
        return cLoader;
    }
    @Override
    public void onLoadFinished(android.support.v4.content.Loader<Cursor> arg0,
                               Cursor c) {

        showLocations(c);
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<Cursor> arg0) {
        // TODO Auto-generated method stub
    }

    private void showLocations(Cursor c){
        MarkerOptions markerOptions = null;
        LatLng position = null;
        mGoogleMap.clear();
        while(c.moveToNext()){
            markerOptions = new MarkerOptions();
            position = new LatLng(Double.parseDouble(c.getString(1)),Double.parseDouble(c.getString(2)));
            lat = Double.parseDouble(c.getString(1));
            lon =  Double.parseDouble(c.getString(2));
            markerOptions.position(position);
            markerOptions.title(c.getString(0));
            mGoogleMap.addMarker(markerOptions);




        }
        if(position!=null){
            CameraUpdate cameraPosition = CameraUpdateFactory.newLatLng(position);
            mGoogleMap.animateCamera(cameraPosition);
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        // TODO Auto-generated method stub
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();

         return true;
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    try
                    {
                        mCurrentLocation = mLocationClient.getLastLocation();

                        Intent intMode = new Intent(DesActivity.this, GameActivity.class);
                        intMode.putExtra("latStart", mCurrentLocation.getLatitude());
                        intMode.putExtra("longStart", mCurrentLocation.getLongitude());
                        intMode.putExtra("latEnd", lat);
                        intMode.putExtra("longEnd", lon);
                        intMode.putExtra("timeLimit", 120);
                        DesActivity.this.startActivity(intMode);
                    }catch(Exception e){

                    }
                                        break;

                case DialogInterface.BUTTON_NEGATIVE:
                    mGoogleMap.clear();

                    break;
            }
        }
    };

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onDisconnected() {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
