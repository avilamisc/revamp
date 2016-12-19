package io.nlopez.revamp.sample.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.nlopez.revamp.sample.R;
import io.nlopez.revamp.sample.model.User;
import io.nlopez.revamp.sample.util.Interactions;
import io.nlopez.smartadapters.views.BindableLinearLayout;

/**
 * Created by mrm on 24/5/15.
 */
public class UserView extends BindableLinearLayout<User> {

  @InjectView(R.id.user_image)
  ImageView userImage;

  @InjectView(R.id.user_text)
  TextView userText;

  public UserView(Context context) {
    super(context);
  }

  @Override
  public int getOrientation() {
    return HORIZONTAL;
  }

  @Override
  public int getLayoutId() {
    return R.layout.view_user;
  }

  @Override
  public void onViewInflated() {
    ButterKnife.inject(this);
  }

  @Override
  public void bind(User item) {
    userText.setText(item.getFirstName() + " " + item.getLastName() + "\n" + item.getRole());
    Picasso.with(getContext()).load(item.getAvatar()).into(userImage);

    setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        notifyItemAction(Interactions.USER_CLICKED);
      }
    });
  }
}
