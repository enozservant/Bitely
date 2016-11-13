// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.plaidapp.R;
import io.plaidapp.ui.widget.AuthorTextView;
import io.plaidapp.ui.widget.CheckableImageButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DribbbleShot$CommentViewHolder_ViewBinding<T extends DribbbleShot.CommentViewHolder> implements Unbinder {
  protected T target;

  public DribbbleShot$CommentViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.avatar = Utils.findRequiredViewAsType(source, R.id.player_avatar, "field 'avatar'", ImageView.class);
    target.author = Utils.findRequiredViewAsType(source, R.id.comment_author, "field 'author'", AuthorTextView.class);
    target.timeAgo = Utils.findRequiredViewAsType(source, R.id.comment_time_ago, "field 'timeAgo'", TextView.class);
    target.commentBody = Utils.findRequiredViewAsType(source, R.id.comment_text, "field 'commentBody'", TextView.class);
    target.reply = Utils.findRequiredViewAsType(source, R.id.comment_reply, "field 'reply'", ImageButton.class);
    target.likeHeart = Utils.findRequiredViewAsType(source, R.id.comment_like, "field 'likeHeart'", CheckableImageButton.class);
    target.likesCount = Utils.findRequiredViewAsType(source, R.id.comment_likes_count, "field 'likesCount'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.avatar = null;
    target.author = null;
    target.timeAgo = null;
    target.commentBody = null;
    target.reply = null;
    target.likeHeart = null;
    target.likesCount = null;

    this.target = null;
  }
}
