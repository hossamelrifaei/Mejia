package hossam.mejiaasociados;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import utlis.Constants;
import utlis.VimeoUrlEditor;

public class VimeoActivity extends AppCompatActivity {

    private WebView mWebView;
    private TextView locationText;
    private String videoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vimeo);
        mWebView = (WebView) findViewById(R.id.webview);
        locationText = (TextView) findViewById(R.id.location);
        locationText.setText(getIntent().getStringExtra(Constants.LOCATION_TAG));

        videoUrl = getIntent().getStringExtra(Constants.URL_TAG);

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);

        String url = VimeoUrlEditor.addVimeoPlayer(videoUrl);


        mWebView.loadData(buildHtmlString(url), "text/html", null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vimeo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String buildHtmlString(String url) {
        String html = "<iframe src=\"" + url + "\" width=\"100%\" height=\"100%\" frameborder=\"0\"></iframe>";
        return html;
    }
}
