package com.mypdfviewer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ActMain extends AppCompatActivity
{
    //private String FILE_PATH = "filepath";
    //private PdfFragment fragment;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.act_main);
        //copyReadAssets();
        showDialog("This is pdf viewer...");
    }

    private void showDialog(String _message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage(_message)

        .setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                finish();
            }
        });
        builder.show();
    }


    /*
    public void openPdfWithFragment (String pdfPath)
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

    private void copyReadAssets()
    {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;

        String strDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ File.separator + "MYPDF";
        File fileDir = new File(strDir);
        fileDir.mkdirs();
        File file = new File(fileDir, "sample.pdf");

        try
        {

            in = assetManager.open("sample.pdf");
            out = new BufferedOutputStream (new FileOutputStream (file));

            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e)
        {
            Log.e("tag", e.getMessage());
        }

        //Open pdf
        String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + File.separator + "MYPDF" + "/sample.pdf";
        openPdfWithFragment(pdfPath);
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, read);
        }
    }
    */
}
