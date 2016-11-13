// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.plaidapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FeedAdapter$ProductHuntStoryHolder_ViewBinding<T extends FeedAdapter.ProductHuntStoryHolder> implements Unbinder {
  protected T target;

  public FeedAdapter$ProductHuntStoryHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.title = Utils.findRequiredViewAsType(source, R.id.hunt_title, "field 'title'", TextView.class);
    target.tagline = Utils.findRequiredViewAsType(source, R.id.tagline, "field 'tagline'", TextView.class);
    target.comments = Utils.findRequiredViewAsType(source, R.id.story_comments, "field 'comments'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.title = null;
    target.tagline = null;
    target.comments = null;

    this.target = null;
  }
}
