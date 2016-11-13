// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.content.res.Resources;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import io.plaidapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeActivity_ViewBinding<T extends HomeActivity> implements Unbinder {
  protected T target;

  private View view2131886243;

  public HomeActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.drawer = Utils.findRequiredViewAsType(source, R.id.drawer, "field 'drawer'", DrawerLayout.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.grid = Utils.findRequiredViewAsType(source, R.id.grid, "field 'grid'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.fab, "field 'fab' and method 'fabClick'");
    target.fab = Utils.castView(view, R.id.fab, "field 'fab'", ImageButton.class);
    view2131886243 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.fabClick();
      }
    });
    target.filtersList = Utils.findRequiredViewAsType(source, R.id.filters, "field 'filtersList'", RecyclerView.class);
    target.loading = Utils.findRequiredViewAsType(source, android.R.id.empty, "field 'loading'", ProgressBar.class);
    target.noConnection = Utils.findOptionalViewAsType(source, R.id.no_connection, "field 'noConnection'", ImageView.class);

    Resources res = source.getResources();
    target.columns = res.getInteger(R.integer.num_columns);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.drawer = null;
    target.toolbar = null;
    target.grid = null;
    target.fab = null;
    target.filtersList = null;
    target.loading = null;
    target.noConnection = null;

    view2131886243.setOnClickListener(null);
    view2131886243 = null;

    this.target = null;
  }
}
