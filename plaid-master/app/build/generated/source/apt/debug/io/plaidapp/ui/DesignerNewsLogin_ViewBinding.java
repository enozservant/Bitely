// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.plaidapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DesignerNewsLogin_ViewBinding<T extends DesignerNewsLogin> implements Unbinder {
  protected T target;

  public DesignerNewsLogin_ViewBinding(T target, View source) {
    this.target = target;

    target.container = Utils.findRequiredViewAsType(source, R.id.container, "field 'container'", ViewGroup.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.dialog_title, "field 'title'", TextView.class);
    target.usernameLabel = Utils.findRequiredViewAsType(source, R.id.username_float_label, "field 'usernameLabel'", TextInputLayout.class);
    target.username = Utils.findRequiredViewAsType(source, R.id.username, "field 'username'", AutoCompleteTextView.class);
    target.permissionPrimer = Utils.findRequiredViewAsType(source, R.id.permission_primer, "field 'permissionPrimer'", CheckBox.class);
    target.passwordLabel = Utils.findRequiredViewAsType(source, R.id.password_float_label, "field 'passwordLabel'", TextInputLayout.class);
    target.password = Utils.findRequiredViewAsType(source, R.id.password, "field 'password'", EditText.class);
    target.actionsContainer = Utils.findRequiredViewAsType(source, R.id.actions_container, "field 'actionsContainer'", FrameLayout.class);
    target.signup = Utils.findRequiredViewAsType(source, R.id.signup, "field 'signup'", Button.class);
    target.login = Utils.findRequiredViewAsType(source, R.id.login, "field 'login'", Button.class);
    target.loading = Utils.findRequiredViewAsType(source, R.id.loading, "field 'loading'", ProgressBar.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.container = null;
    target.title = null;
    target.usernameLabel = null;
    target.username = null;
    target.permissionPrimer = null;
    target.passwordLabel = null;
    target.password = null;
    target.actionsContainer = null;
    target.signup = null;
    target.login = null;
    target.loading = null;

    this.target = null;
  }
}
