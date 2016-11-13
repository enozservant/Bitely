// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.plaidapp.R;
import io.plaidapp.ui.widget.ElasticDragDismissFrameLayout;
import io.plaidapp.ui.widget.FABToggle;
import io.plaidapp.ui.widget.ParallaxScrimageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DribbbleShot_ViewBinding<T extends DribbbleShot> implements Unbinder {
  protected T target;

  public DribbbleShot_ViewBinding(T target, View source) {
    this.target = target;

    target.draggableFrame = Utils.findRequiredViewAsType(source, R.id.draggable_frame, "field 'draggableFrame'", ElasticDragDismissFrameLayout.class);
    target.back = Utils.findRequiredViewAsType(source, R.id.back, "field 'back'", ImageButton.class);
    target.imageView = Utils.findRequiredViewAsType(source, R.id.shot, "field 'imageView'", ParallaxScrimageView.class);
    target.commentsList = Utils.findRequiredViewAsType(source, R.id.dribbble_comments, "field 'commentsList'", RecyclerView.class);
    target.fab = Utils.findRequiredViewAsType(source, R.id.fab_heart, "field 'fab'", FABToggle.class);

    Resources res = source.getResources();
    target.largeAvatarSize = res.getDimensionPixelSize(R.dimen.large_avatar_size);
    target.cardElevation = res.getDimensionPixelSize(R.dimen.z_card);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.draggableFrame = null;
    target.back = null;
    target.imageView = null;
    target.commentsList = null;
    target.fab = null;

    this.target = null;
  }
}
