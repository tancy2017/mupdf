package com.mypdfviewer;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Chuen on 22/04/2017.
 */

public class ActOpenPDF extends AppCompatActivity
{
    private String FILE_PATH = "filepath";
    private PdfFragment fragment;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.act_open_pdf);
        Uri uri = getIntent().getData();
        openPdfWithFragment(getPath(uri));
    }

    private String getPath(Uri uri)
    {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor == null) return null;
        int column_index =             cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String s=cursor.getString(column_index);
        cursor.close();
        return s;
    }


    private void openPdfWithFragment (String pdfPath)
    {
        try
        {
            fragment = new PdfFragment ();
            Bundle args = new Bundle ();
            args.putString (FILE_PATH, pdfPath);
            fragment.setArguments (args);
            FragmentManager fragmentManager = getSupportFragmentManager ();
            fragmentManager.beginTransaction ().replace (R.id.content_frame, fragment).commit ();
        }
        catch (Exception e)
        {
            Log.i ("", "Exception :: " + e.toString ());
        }
    }
}
