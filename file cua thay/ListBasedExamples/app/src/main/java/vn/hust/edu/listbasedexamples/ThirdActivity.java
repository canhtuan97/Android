package vn.hust.edu.listbasedexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class ThirdActivity extends AppCompatActivity {

    Integer[] items = { R.drawable.thumb1, R.drawable.thumb2, R.drawable.thumb3,
            R.drawable.thumb4, R.drawable.thumb5, R.drawable.thumb6,
            R.drawable.thumb7, R.drawable.thumb8, R.drawable.thumb9,
            R.drawable.thumb10, R.drawable.thumb11, R.drawable.thumb12,
            R.drawable.thumb13, R.drawable.thumb14, R.drawable.thumb15,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        GridView gridView = findViewById(R.id.grid_view);
        ImageAdapter adapter = new ImageAdapter(items, this);
        gridView.setAdapter(adapter);
    }
}
