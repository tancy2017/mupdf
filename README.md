# mupdf
A PDF view statement Android app.

MuPDF is product from Artifex Software, Inc. For more info, please visit https://mupdf.com/

The original of source code can be found at http://git.ghostscript.com/?p=mupdf.git;a=summary

Fixes:

1. Issue: On certain Android marshmallow, MuPDF crashes.
2. Solution: In com.artifex.mupdflib\ReadView.java, line 856, comment out an unsupported exception as below:

<pre>
@Override
public View getSelectedView() {
//throw new UnsupportedOperationException(getContext().getString(R.string.not_supported));
return null;
}
</pre>
