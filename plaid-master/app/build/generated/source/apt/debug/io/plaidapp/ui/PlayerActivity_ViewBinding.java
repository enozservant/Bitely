// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import io.plaidapp.R;
import io.plaidapp.ui.widget.ElasticDragDismissFrameLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlayerActivity_ViewBinding<T extends PlayerActivity> implements Unbinder {
  protected T target;

  private View view2131886227;

  private View view2131886229;

  private View view2131886230;

  private View view2131886231;

  public PlayerActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.draggableFrame = Utils.findRequiredViewAsType(source, R.id.draggable_frame, "field 'draggableFrame'", ElasticDragDismissFrameLayout.class);
    target.container = Utils.findRequiredViewAsType(source, R.id.container, "field 'container'", ViewGroup.class);
    target.avatar = Utils.findRequiredViewAsType(source, R.id.avatar, "field 'avatar'", ImageView.class);
    target.playerName = Utils.findRequiredViewAsType(source, R.id.player_name, "field 'playerName'", TextView.class);
    view = Utils.findRequiredView(source, R.id.follow, "field 'follow' and method 'follow'");
    target.follow = Utils.castView(view, R.id.follow, "field 'follow'", Button.class);
    view2131886227 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.follow();
      }
    });
    target.bio = Utils.findRequiredViewAsType(source, R.id.player_bio, "field 'bio'", TextView.class);
    view = Utils.findRequiredView(source, R.id.shot_count, "field 'shotCount' and method 'playerActionClick'");
    target.shotCount = Utils.castView(view, R.id.shot_count, "field 'shotCount'", TextView.class);
    view2131886229 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.playerActionClick(Utils.<TextView>castParam(p0, "doClick", 0, "playerActionClick", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.followers_count, "field 'followersCount' and method 'playerActionClick'");
    target.followersCount = Utils.castView(view, R.id.followers_count, "field 'followersCount'", TextView.class);
    view2131886230 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.playerActionClick(Utils.<TextView>castParam(p0, "doClick", 0, "playerActionClick", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.likes_count, "field 'likesCount' and method 'playerActionClick'");
    target.likesCount = Utils.castView(view, R.id.likes_count, "field 'likesCount'", TextView.class);
    view2131886231 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.playerActionClick(Utils.<TextView>castParam(p0, "doClick", 0, "playerActionClick", 0));
      }
    });
    target.loading = Utils.findRequiredViewAsType(source, R.id.loading, "field 'loading'", ProgressBar.class);
    target.shots = Utils.findRequiredViewAsType(source, R.id.player_shots, "field 'shots'", RecyclerView.class);

    Resources res = source.getResources();
    target.columns = res.getInteger(R.integer.num_columns);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.draggableFrame = null;
    target.container = null;
    target.avatar = null;
    target.playerName = null;
    target.follow = null;
    target.bio = null;
    target.shotCount = null;
    target.followersCount = null;
    target.likesCount = null;
    target.loading = null;
    target.shots = null;

    view2131886227.setOnClickListener(null);
    view2131886227 = null;
    view2131886229.setOnClickListener(null);
    view2131886229 = null;
    view2131886230.setOnClickListener(null);
    view2131886230 = null;
    view2131886231.setOnClickListener(null);
    view2131886231 = null;

    this.target = null;
  }
}
