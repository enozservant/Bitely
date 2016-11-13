// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.plaidapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DesignerNewsStory$CommentReplyHolder_ViewBinding<T extends DesignerNewsStory.CommentReplyHolder> implements Unbinder {
  protected T target;

  public DesignerNewsStory$CommentReplyHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.commentVotes = Utils.findRequiredViewAsType(source, R.id.comment_votes, "field 'commentVotes'", Button.class);
    target.replyLabel = Utils.findRequiredViewAsType(source, R.id.comment_reply_label, "field 'replyLabel'", TextInputLayout.class);
    target.commentReply = Utils.findRequiredViewAsType(source, R.id.comment_reply, "field 'commentReply'", EditText.class);
    target.postReply = Utils.findRequiredViewAsType(source, R.id.post_reply, "field 'postReply'", ImageButton.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.commentVotes = null;
    target.replyLabel = null;
    target.commentReply = null;
    target.postReply = null;

    this.target = null;
  }
}
