// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.plaidapp.R;
import io.plaidapp.ui.widget.ElasticDragDismissFrameLayout;
import io.plaidapp.ui.widget.InkPageIndicator;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AboutActivity_ViewBinding<T extends AboutActivity> implements Unbinder {
  protected T target;

  public AboutActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.draggableFrame = Utils.findRequiredViewAsType(source, R.id.draggable_frame, "field 'draggableFrame'", ElasticDragDismissFrameLayout.class);
    target.pager = Utils.findRequiredViewAsType(source, R.id.pager, "field 'pager'", ViewPager.class);
    target.pageIndicator = Utils.findRequiredViewAsType(source, R.id.indicator, "field 'pageIndicator'", InkPageIndicator.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.draggableFrame = null;
    target.pager = null;
    target.pageIndicator = null;

    this.target = null;
  }
}
