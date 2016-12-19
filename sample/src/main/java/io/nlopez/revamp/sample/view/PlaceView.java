package io.nlopez.revamp.sample.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.nlopez.revamp.sample.R;
import io.nlopez.revamp.sample.model.Place;
import io.nlopez.revamp.sample.util.Interactions;
import io.nlopez.smartadapters.views.BindableLinearLayout;

/**
 * Created by mrm on 24/5/15.
 */
public class PlaceView extends BindableLinearLayout<Place> {

  @InjectView(R.id.place_image)
  ImageView placeImage;

  @InjectView(R.id.place_text)
  TextView placeText;

  public PlaceView(Context context) {
    super(context);
  }

  @Override
  public int getOrientation() {
    return HORIZONTAL;
  }

  @Override
  public int getLayoutId() {
    return R.layout.view_place;
  }

  @Override
  public void onViewInflated() {
    ButterKnife.inject(this);
  }

  @Override
  public void bind(Place item) {
    placeText.setText(item.getName());
    Picasso.with(getContext()).load(item.getImageUrl()).into(placeImage);

    setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        notifyItemAction(Interactions.PLACE_CLICKED);
      }
    });
  }
}
