package org.zirco2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.AdapterView.OnItemClickListener;

public class GalleryActivity extends Activity {	

	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        
        Gallery g = (Gallery) findViewById(R.id.gallery);
        g.setAdapter(new ImageAdapter(this));

        g.setOnItemClickListener(new OnItemClickListener() {

        	@Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        		doFinish(position);
            }
        });
	}

	@Override
	public void onBackPressed() {
		doFinish(-1);
	}

	private void doFinish(int index) {
		if (index != -1) {
			Intent i = new Intent();
			i.putExtra("TAB_INDEX", index);
			setResult(RESULT_OK, i);
		}
		finish();
		overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
	}
	
}