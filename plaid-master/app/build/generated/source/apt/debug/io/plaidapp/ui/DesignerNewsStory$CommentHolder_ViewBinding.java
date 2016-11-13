// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.plaidapp.R;
import io.plaidapp.ui.widget.AuthorTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DesignerNewsStory$CommentHolder_ViewBinding<T extends DesignerNewsStory.CommentHolder> implements Unbinder {
  protected T target;

  public DesignerNewsStory$CommentHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.threadDepth = Utils.findRequiredViewAsType(source, R.id.depth, "field 'threadDepth'", ImageView.class);
    target.author = Utils.findRequiredViewAsType(source, R.id.comment_author, "field 'author'", AuthorTextView.class);
    target.timeAgo = Utils.findRequiredViewAsType(source, R.id.comment_time_ago, "field 'timeAgo'", TextView.class);
    target.comment = Utils.findRequiredViewAsType(source, R.id.comment_text, "field 'comment'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.threadDepth = null;
    target.author = null;
    target.timeAgo = null;
    target.comment = null;

    this.target = null;
  }
}
