// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.plaidapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DribbbleLogin_ViewBinding<T extends DribbbleLogin> implements Unbinder {
  protected T target;

  public DribbbleLogin_ViewBinding(T target, View source) {
    this.target = target;

    target.container = Utils.findRequiredViewAsType(source, R.id.container, "field 'container'", ViewGroup.class);
    target.message = Utils.findRequiredViewAsType(source, R.id.login_message, "field 'message'", TextView.class);
    target.login = Utils.findRequiredViewAsType(source, R.id.login, "field 'login'", Button.class);
    target.loading = Utils.findRequiredViewAsType(source, R.id.loading, "field 'loading'", ProgressBar.class);
    target.loginFailed = Utils.findRequiredViewAsType(source, R.id.login_failed_message, "field 'loginFailed'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.container = null;
    target.message = null;
    target.login = null;
    target.loading = null;
    target.loginFailed = null;

    this.target = null;
  }
}
