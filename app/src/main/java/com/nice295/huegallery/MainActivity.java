package com.nice295.huegallery;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.nice295.huegallery.enums.PaletteColorType;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by etiennelawlor on 8/20/15.
 */
public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "NiceGallery-Main";

    private static final int REQUEST_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Bind(R.id.llRoot)
    LinearLayout llRoot;

    // region Listeners
    @OnClick(R.id.view_gallery_btn)
    public void onViewGalleryButtonClicked() {

        /*
        images.add("https://images.unsplash.com/photo-1437422061949-f6efbde0a471?q=80&fm=jpg&s=e23055c9ba7686b8fe583fb8318a1f88");
        images.add("https://images.unsplash.com/photo-1434139240289-56c519f77cb0?q=80&fm=jpg&s=13f8a0d1c2f96b5f311dedeb17cddb60");
        images.add("https://images.unsplash.com/photo-1429152937938-07b5f2828cdd?q=80&fm=jpg&s=a4f424db0ae5a398297df5ae5e0520d6");
        images.add("https://images.unsplash.com/photo-1430866880825-336a7d7814eb?q=80&fm=jpg&s=450de8563ac041f48b1563b499f56895");
        images.add("https://images.unsplash.com/photo-1429547584745-d8bec594c82e?q=80&fm=jpg&s=e9a7d9973088122a3e453cb2af541201");
        images.add("https://images.unsplash.com/photo-1429277158984-614d155e0017?q=80&fm=jpg&s=138f154e17a304b296c953323862633b");
        images.add("https://images.unsplash.com/photo-1429042007245-890c9e2603af?q=80&fm=jpg&s=8b76d20174cf46bffe32ea18f05551d3");
        images.add("https://images.unsplash.com/photo-1429091967365-492aaa5accfe?q=80&fm=jpg&s=b7430cfe5508430aea39fcf3b0645878");
        images.add("https://images.unsplash.com/photo-1430132594682-16e1185b17c5?q=80&fm=jpg&s=a70abbfff85382d11b03b9bbc71649c3");
        images.add("https://images.unsplash.com/photo-1436891620584-47fd0e565afb?q=80&fm=jpg&s=33cf5b0ee9fbd292475a0c03bee481c9");

        images.add("https://images.unsplash.com/photo-1415871989540-61fe9268d3c8?q=80&fm=jpg&s=061a03a7abe860a6c165cc3994feaba2");
        images.add("https://images.unsplash.com/photo-1415033523948-6c31d010530d?q=80&fm=jpg&s=ebe77e93f095b1a21ff6f090d332a815");
        images.add("https://images.unsplash.com/photo-1415201179613-bd037ff5eb29?q=80&fm=jpg&s=46a25087049ca6bdcff8390a342b9c59");
        images.add("https://images.unsplash.com/photo-1418227165283-1595d13726cd?q=80&fm=jpg&s=45b1869e9cd4fce23510ded9370e3966");
        images.add("https://images.unsplash.com/photo-1416949929422-a1d9c8fe84af?q=80&fm=jpg&s=ba414d9605af43b67d974182756cfb1d");
        images.add("https://images.unsplash.com/reserve/JaI1BywIT5Or8Jfmci1E_zakopane.jpg?q=80&fm=jpg&s=57142c70a82dc560fc67ce09c12a6052");
        images.add("https://images.unsplash.com/uploads/141362941583982a7e0fc/abcfbca1?q=80&fm=jpg&s=4f36891ccddbd86ed034d5943fb0eccb");
        images.add("https://images.unsplash.com/uploads/14116941824817ba1f28e/78c8dff1?q=80&fm=jpg&s=5600be7f06b56681c56f55c787128538");
        images.add("https://images.unsplash.com/photo-1413977886085-3bbbf9a7cf6e?q=80&fm=jpg&s=bc09d3becea6f665b39290475f3467c8");
        images.add("https://images.unsplash.com/photo-1415226194219-638f50c5d25f?q=80&fm=jpg&s=4f3f71caf6caeb5d4f508a001111e480");

        images.add("https://images.unsplash.com/photo-1416934625760-d56f5e79f6fe?q=80&fm=jpg&s=4c526b15bda8434c6f9e7eefe12b29be");
        images.add("https://images.unsplash.com/uploads/141220211075617c40312/e2ddba22?q=80&fm=jpg&s=394885b1c8da6776e79815e961118c81");
        images.add("https://images.unsplash.com/uploads/1412238370909393b4a19/79f023f1?q=80&fm=jpg&s=95844dfcd1993f4f0b10eab82c183631");
        images.add("https://images.unsplash.com/reserve/OQx70jjBSLOMI5ackhxm_urbex-ppc-030.jpg?q=80&fm=jpg&s=821aacb41fc9d3a94e5263d58dccce80");
        images.add("https://images.unsplash.com/39/yvDPJ8ZSmSVob7pRxIvU_IMG_40322.jpg?q=80&fm=jpg&s=30b5834ad1c403bcfd7fa5c4dfaba625");
        images.add("https://images.unsplash.com/22/one-scene.JPG?q=80&fm=jpg&s=b8b57577424cdf5545bb11bdf6f4b5a7");
        images.add("https://images.unsplash.com/36/e6mVuK2jQlWxKt3eAnQT_image.jpg?q=80&fm=jpg&s=0a3d8da572b0ed5e0cb963f6fa13588a");
        images.add("https://images.unsplash.com/41/pHyYeNZMRFOIRpYeW7X3_manacloseup%20copy.jpg?q=80&fm=jpg&s=99f2dbdf1526488a93d3cf307dea43d6");
        images.add("https://images.unsplash.com/44/MIbCzcvxQdahamZSNQ26_12082014-IMG_3526.jpg?q=80&fm=jpg&s=9f2b7926c5c13f719c57536392d78b49");
        images.add("https://images.unsplash.com/photo-1415226556993-1404e0c6e727?q=80&fm=jpg&s=334b8b5271cdbd8cbd4990a3aef89074");
        */

        // Verify that all required contact permissions have been granted.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Contacts permissions have not been granted.
            Log.i(LOG_TAG, "Storage permissions has NOT been granted. Requesting permissions.");
            requestStoragePermissions();

        } else {
            // Contact permissions have been granted. Show the contacts fragment.
            Log.i(LOG_TAG, "Storage permissions have already been granted. Displaying contact details.");

            Intent intent = new Intent(MainActivity.this, ImageGalleryActivity.class);
            ArrayList<String> images = new ArrayList<>();
            images = getDeviceImages();
            intent.putStringArrayListExtra("images", images);
            // optionally set background color using Palette
            intent.putExtra("palette_color_type", PaletteColorType.VIBRANT);
            startActivity(intent);
        }
    }
    // endregion

    // region Lifecycle Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private ArrayList<String> getDeviceImages() {
        Log.d(LOG_TAG, "Starting image query...");

        ArrayList<String> images = new ArrayList<>();

        String pPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
        String projection = "";
        String photoPath = "(1==1)";
        if (pPath.length() > 0) {
            photoPath = " (" + MediaStore.Images.ImageColumns.DATA + " LIKE \'%" + pPath + "%\' )";
        }
        //String groupBy = ") GROUP BY (" + YEAR;
        projection = projection + photoPath; // + grouBy;

        Cursor cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[] {
                        MediaStore.Images.ImageColumns.TITLE,
                        MediaStore.Images.ImageColumns.DISPLAY_NAME,
                        MediaStore.Images.ImageColumns.DATE_TAKEN,
                        MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME,
                        MediaStore.Images.ImageColumns.DATA,
                        MediaStore.Images.ImageColumns.LATITUDE,
                        MediaStore.Images.ImageColumns.LONGITUDE
                },
                projection,
                null,
                MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC");

        if (cursor != null) {
            Log.d(LOG_TAG, "Count of images: " + cursor.getCount());
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                //Log.d(LOG_TAG, "File path: " + cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATA)));
                images.add(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATA)));

                cursor.moveToNext();
            }
            cursor.close();
        }
        else {
            Log.d(LOG_TAG, "No images");
        }

        return images;
    }
    // endregion

    private void requestStoragePermissions() {
        // BEGIN_INCLUDE(contacts_permission_request)
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                || ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // For example, if the request has been denied previously.
            Log.i(LOG_TAG, "Displaying storage permission rationale to provide additional context.");

            // Display a SnackBar with an explanation and a button to trigger the request.
            Snackbar.make(llRoot, R.string.permission_storage_rationale,
                    Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.ok, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ActivityCompat
                                    .requestPermissions(MainActivity.this, PERMISSIONS_STORAGE,
                                            REQUEST_STORAGE);
                        }
                    })
                    .show();
        } else {
            // Contact permissions have not been granted yet. Request them directly.
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_STORAGE);
        }
        // END_INCLUDE(contacts_permission_request)
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if (requestCode == REQUEST_STORAGE) {
        Log.i(LOG_TAG, "Received response for storage permissions request.");

        // We have requested multiple permissions for contacts, so all of them need to be
        // checked.
        if (PermissionUtil.verifyPermissions(grantResults)) {
            /*
            // All required permissions have been granted, display contacts fragment.
            Snackbar.make(llRoot, R.string.permission_available_storage,
                    Snackbar.LENGTH_SHORT)
                    .show();
            */

            Intent intent = new Intent(MainActivity.this, ImageGalleryActivity.class);
            ArrayList<String> images = new ArrayList<>();
            images = getDeviceImages();
            intent.putStringArrayListExtra("images", images);
            // optionally set background color using Palette
            intent.putExtra("palette_color_type", PaletteColorType.VIBRANT);
            startActivity(intent);

        } else {
            Log.i(LOG_TAG, "Storage permissions were NOT granted.");
            Snackbar.make(llRoot, R.string.permissions_not_granted,
                    Snackbar.LENGTH_SHORT)
                    .show();
        }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
