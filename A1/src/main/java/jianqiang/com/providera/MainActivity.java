package jianqiang.com.providera;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    ContentResolver contentResolver;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uri = Uri.parse("content://baobao/");
        contentResolver = getContentResolver();
    }

    public void delete(View source) {
        int count = contentResolver.delete(uri, "delete_where", null);
        Toast.makeText(this, "delete uri:" + count, Toast.LENGTH_LONG).show();
    }

    public void insert(View source) {
        ContentValues values = new ContentValues();
        values.put("name", "jianqiang");
        Uri newUri = contentResolver.insert(uri, values);
        Toast.makeText(this, "insert uri:" + newUri, Toast.LENGTH_LONG).show();
    }

    public void update(View source) {
        ContentValues values = new ContentValues();
        values.put("name", "jianqiang2");
        int count = contentResolver.update(uri, values, "update_where", null);
        Toast.makeText(this, "update count:" + count, Toast.LENGTH_LONG).show();
    }
}
