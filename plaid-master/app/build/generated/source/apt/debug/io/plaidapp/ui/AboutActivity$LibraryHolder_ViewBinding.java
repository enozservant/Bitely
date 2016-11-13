// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.plaidapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AboutActivity$LibraryHolder_ViewBinding<T extends AboutActivity.LibraryHolder> implements Unbinder {
  protected T target;

  public AboutActivity$LibraryHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.image = Utils.findRequiredViewAsType(source, R.id.library_image, "field 'image'", ImageView.class);
    target.name = Utils.findRequiredViewAsType(source, R.id.library_name, "field 'name'", TextView.class);
    target.description = Utils.findRequiredViewAsType(source, R.id.library_description, "field 'description'", TextView.class);
    target.link = Utils.findRequiredViewAsType(source, R.id.library_link, "field 'link'", Button.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.image = null;
    target.name = null;
    target.description = null;
    target.link = null;

    this.target = null;
  }
}
