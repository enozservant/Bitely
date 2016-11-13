// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.plaidapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlayerSheet$PlayerViewHolder_ViewBinding<T extends PlayerSheet.PlayerViewHolder> implements Unbinder {
  protected T target;

  public PlayerSheet$PlayerViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.playerAvatar = Utils.findRequiredViewAsType(source, R.id.player_avatar, "field 'playerAvatar'", ImageView.class);
    target.playerName = Utils.findRequiredViewAsType(source, R.id.player_name, "field 'playerName'", TextView.class);
    target.playerBio = Utils.findRequiredViewAsType(source, R.id.player_bio, "field 'playerBio'", TextView.class);
    target.timeAgo = Utils.findRequiredViewAsType(source, R.id.time_ago, "field 'timeAgo'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.playerAvatar = null;
    target.playerName = null;
    target.playerBio = null;
    target.timeAgo = null;

    this.target = null;
  }
}
