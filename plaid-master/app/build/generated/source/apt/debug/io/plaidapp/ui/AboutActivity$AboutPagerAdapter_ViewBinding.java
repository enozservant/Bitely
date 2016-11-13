// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.plaidapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AboutActivity$AboutPagerAdapter_ViewBinding<T extends AboutActivity.AboutPagerAdapter> implements Unbinder {
  protected T target;

  public AboutActivity$AboutPagerAdapter_ViewBinding(T target, View source) {
    this.target = target;

    target.plaidDescription = Utils.findOptionalViewAsType(source, R.id.about_description, "field 'plaidDescription'", TextView.class);
    target.iconDescription = Utils.findOptionalViewAsType(source, R.id.icon_description, "field 'iconDescription'", TextView.class);
    target.libsList = Utils.findOptionalViewAsType(source, R.id.libs_list, "field 'libsList'", RecyclerView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.plaidDescription = null;
    target.iconDescription = null;
    target.libsList = null;

    this.target = null;
  }
}
