// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import io.plaidapp.R;
import io.plaidapp.ui.widget.BottomSheet;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlayerSheet_ViewBinding<T extends PlayerSheet> implements Unbinder {
  protected T target;

  private View view2131886246;

  private View view2131886347;

  public PlayerSheet_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.bottom_sheet, "field 'bottomSheet' and method 'dismiss'");
    target.bottomSheet = Utils.castView(view, R.id.bottom_sheet, "field 'bottomSheet'", BottomSheet.class);
    view2131886246 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.dismiss(p0);
      }
    });
    target.content = Utils.findRequiredViewAsType(source, R.id.bottom_sheet_content, "field 'content'", ViewGroup.class);
    target.titleBar = Utils.findRequiredViewAsType(source, R.id.title_bar, "field 'titleBar'", ViewGroup.class);
    view = Utils.findRequiredView(source, R.id.close, "field 'close' and method 'dismiss'");
    target.close = Utils.castView(view, R.id.close, "field 'close'", ImageView.class);
    view2131886347 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.dismiss(p0);
      }
    });
    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", TextView.class);
    target.playerList = Utils.findRequiredViewAsType(source, R.id.player_list, "field 'playerList'", RecyclerView.class);

    Resources res = source.getResources();
    target.largeAvatarSize = res.getDimensionPixelSize(R.dimen.large_avatar_size);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.bottomSheet = null;
    target.content = null;
    target.titleBar = null;
    target.close = null;
    target.title = null;
    target.playerList = null;

    view2131886246.setOnClickListener(null);
    view2131886246 = null;
    view2131886347.setOnClickListener(null);
    view2131886347 = null;

    this.target = null;
  }
}
