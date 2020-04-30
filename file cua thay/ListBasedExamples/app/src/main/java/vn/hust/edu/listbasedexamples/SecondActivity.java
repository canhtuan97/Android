package vn.hust.edu.listbasedexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    List<ItemModel> items;
    ImageView imageLarge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        items = new ArrayList<>();
        items.add(new ItemModel("Data 1", R.drawable.thumb1, R.drawable.wall1));
        items.add(new ItemModel("Data 2", R.drawable.thumb2, R.drawable.wall2));
        items.add(new ItemModel("Data 3", R.drawable.thumb3, R.drawable.wall3));
        items.add(new ItemModel("Data 4", R.drawable.thumb4, R.drawable.wall4));
        items.add(new ItemModel("Data 5", R.drawable.thumb5, R.drawable.wall5));
        items.add(new ItemModel("Data 6", R.drawable.thumb6, R.drawable.wall6));
        items.add(new ItemModel("Data 7", R.drawable.thumb7, R.drawable.wall7));
        items.add(new ItemModel("Data 8", R.drawable.thumb8, R.drawable.wall8));
        items.add(new ItemModel("Data 9", R.drawable.thumb9, R.drawable.wall9));
        items.add(new ItemModel("Data 10", R.drawable.thumb10, R.drawable.wall10));

        imageLarge = findViewById(R.id.image_large);

        LinearLayout layoutList = findViewById(R.id.layout_list);
        for (int i = 0; i < items.size(); i++) {
            View itemView = LayoutInflater.from(this).inflate(R.layout.layout_item_image, null);
            itemView.setId(i);

            ImageView imageThumb = itemView.findViewById(R.id.image_thumb);
            TextView textCaption = itemView.findViewById(R.id.text_caption);
            imageThumb.setImageResource(items.get(i).getThumbnailResource());
            textCaption.setText(items.get(i).getCaption());
            layoutList.addView(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = view.getId();
                    imageLarge.setImageResource(items.get(id).getImageResource());
                }
            });
        }
    }
}
