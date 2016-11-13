// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.plaidapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FeedAdapter$DesignerNewsStoryHolder_ViewBinding<T extends FeedAdapter.DesignerNewsStoryHolder> implements Unbinder {
  protected T target;

  public FeedAdapter$DesignerNewsStoryHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.title = Utils.findRequiredViewAsType(source, R.id.story_title, "field 'title'", TextView.class);
    target.comments = Utils.findRequiredViewAsType(source, R.id.story_comments, "field 'comments'", TextView.class);
    target.pocket = Utils.findRequiredViewAsType(source, R.id.pocket, "field 'pocket'", ImageButton.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.title = null;
    target.comments = null;
    target.pocket = null;

    this.target = null;
  }
}
