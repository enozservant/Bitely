// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SearchView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import io.plaidapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchActivity_ViewBinding<T extends SearchActivity> implements Unbinder {
  protected T target;

  private View view2131886261;

  private View view2131886243;

  private View view2131886267;

  private View view2131886268;

  private View view2131886256;

  private View view2131886265;

  private View view2131886269;

  public SearchActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.searchback, "field 'searchBack' and method 'dismiss'");
    target.searchBack = Utils.castView(view, R.id.searchback, "field 'searchBack'", ImageButton.class);
    view2131886261 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.dismiss();
      }
    });
    target.searchBackContainer = Utils.findRequiredViewAsType(source, R.id.searchback_container, "field 'searchBackContainer'", ViewGroup.class);
    target.searchView = Utils.findRequiredViewAsType(source, R.id.search_view, "field 'searchView'", SearchView.class);
    target.searchBackground = Utils.findRequiredView(source, R.id.search_background, "field 'searchBackground'");
    target.progress = Utils.findRequiredViewAsType(source, android.R.id.empty, "field 'progress'", ProgressBar.class);
    target.results = Utils.findRequiredViewAsType(source, R.id.search_results, "field 'results'", RecyclerView.class);
    target.container = Utils.findRequiredViewAsType(source, R.id.container, "field 'container'", ViewGroup.class);
    target.searchToolbar = Utils.findRequiredViewAsType(source, R.id.search_toolbar, "field 'searchToolbar'", ViewGroup.class);
    target.resultsContainer = Utils.findRequiredViewAsType(source, R.id.results_container, "field 'resultsContainer'", ViewGroup.class);
    view = Utils.findRequiredView(source, R.id.fab, "field 'fab' and method 'save'");
    target.fab = Utils.castView(view, R.id.fab, "field 'fab'", ImageButton.class);
    view2131886243 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.save();
      }
    });
    target.confirmSaveContainer = Utils.findRequiredViewAsType(source, R.id.confirm_save_container, "field 'confirmSaveContainer'", ViewGroup.class);
    view = Utils.findRequiredView(source, R.id.save_dribbble, "field 'saveDribbble' and method 'toggleSaveCheck'");
    target.saveDribbble = Utils.castView(view, R.id.save_dribbble, "field 'saveDribbble'", CheckedTextView.class);
    view2131886267 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toggleSaveCheck(Utils.<CheckedTextView>castParam(p0, "doClick", 0, "toggleSaveCheck", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.save_designer_news, "field 'saveDesignerNews' and method 'toggleSaveCheck'");
    target.saveDesignerNews = Utils.castView(view, R.id.save_designer_news, "field 'saveDesignerNews'", CheckedTextView.class);
    view2131886268 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toggleSaveCheck(Utils.<CheckedTextView>castParam(p0, "doClick", 0, "toggleSaveCheck", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.scrim, "field 'scrim' and method 'dismiss'");
    target.scrim = view;
    view2131886256 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.dismiss();
      }
    });
    view = Utils.findRequiredView(source, R.id.results_scrim, "field 'resultsScrim' and method 'hideSaveConfirmation'");
    target.resultsScrim = view;
    view2131886265 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.hideSaveConfirmation();
      }
    });
    view = Utils.findRequiredView(source, R.id.save_confirmed, "method 'doSave'");
    view2131886269 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.doSave();
      }
    });

    Resources res = source.getResources();
    target.appBarElevation = res.getDimension(R.dimen.z_app_bar);
    target.columns = res.getInteger(R.integer.num_columns);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.searchBack = null;
    target.searchBackContainer = null;
    target.searchView = null;
    target.searchBackground = null;
    target.progress = null;
    target.results = null;
    target.container = null;
    target.searchToolbar = null;
    target.resultsContainer = null;
    target.fab = null;
    target.confirmSaveContainer = null;
    target.saveDribbble = null;
    target.saveDesignerNews = null;
    target.scrim = null;
    target.resultsScrim = null;

    view2131886261.setOnClickListener(null);
    view2131886261 = null;
    view2131886243.setOnClickListener(null);
    view2131886243 = null;
    view2131886267.setOnClickListener(null);
    view2131886267 = null;
    view2131886268.setOnClickListener(null);
    view2131886268 = null;
    view2131886256.setOnClickListener(null);
    view2131886256 = null;
    view2131886265.setOnClickListener(null);
    view2131886265 = null;
    view2131886269.setOnClickListener(null);
    view2131886269 = null;

    this.target = null;
  }
}
