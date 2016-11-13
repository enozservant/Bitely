// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.plaidapp.R;
import io.plaidapp.ui.widget.CollapsingTitleLayout;
import io.plaidapp.ui.widget.ElasticDragDismissFrameLayout;
import io.plaidapp.ui.widget.PinnedOffsetView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DesignerNewsStory_ViewBinding<T extends DesignerNewsStory> implements Unbinder {
  protected T target;

  public DesignerNewsStory_ViewBinding(T target, View source) {
    this.target = target;

    target.commentsList = Utils.findRequiredViewAsType(source, R.id.comments_list, "field 'commentsList'", RecyclerView.class);
    target.fab = Utils.findRequiredViewAsType(source, R.id.fab, "field 'fab'", ImageButton.class);
    target.fabExpand = Utils.findRequiredView(source, R.id.fab_expand, "field 'fabExpand'");
    target.draggableFrame = Utils.findRequiredViewAsType(source, R.id.comments_container, "field 'draggableFrame'", ElasticDragDismissFrameLayout.class);
    target.collapsingToolbar = Utils.findOptionalViewAsType(source, R.id.backdrop_toolbar, "field 'collapsingToolbar'", CollapsingTitleLayout.class);
    target.toolbarBackground = Utils.findOptionalViewAsType(source, R.id.story_title_background, "field 'toolbarBackground'", PinnedOffsetView.class);
    target.background = source.findViewById(R.id.background);

    Resources res = source.getResources();
    target.threadWidth = res.getDimensionPixelSize(R.dimen.comment_thread_width);
    target.threadGap = res.getDimensionPixelSize(R.dimen.comment_thread_gap);
    target.fabExpandDuration = res.getInteger(R.integer.fab_expand_duration);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.commentsList = null;
    target.fab = null;
    target.fabExpand = null;
    target.draggableFrame = null;
    target.collapsingToolbar = null;
    target.toolbarBackground = null;
    target.background = null;

    this.target = null;
  }
}
