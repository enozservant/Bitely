// Generated code from Butter Knife. Do not modify!
package io.plaidapp.ui;

import android.content.res.Resources;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import io.plaidapp.R;
import io.plaidapp.ui.widget.BottomSheet;
import io.plaidapp.ui.widget.ObservableScrollView;
import java.lang.CharSequence;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PostNewDesignerNewsStory_ViewBinding<T extends PostNewDesignerNewsStory> implements Unbinder {
  protected T target;

  private View view2131886246;

  private View view2131886250;

  private TextWatcher view2131886250TextWatcher;

  private View view2131886252;

  private TextWatcher view2131886252TextWatcher;

  private View view2131886254;

  private TextWatcher view2131886254TextWatcher;

  private View view2131886255;

  public PostNewDesignerNewsStory_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.bottom_sheet, "field 'bottomSheet' and method 'dismiss'");
    target.bottomSheet = Utils.castView(view, R.id.bottom_sheet, "field 'bottomSheet'", BottomSheet.class);
    view2131886246 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.dismiss();
      }
    });
    target.bottomSheetContent = Utils.findRequiredViewAsType(source, R.id.bottom_sheet_content, "field 'bottomSheetContent'", ViewGroup.class);
    target.sheetTitle = Utils.findRequiredViewAsType(source, R.id.title, "field 'sheetTitle'", TextView.class);
    target.scrollContainer = Utils.findRequiredViewAsType(source, R.id.scroll_container, "field 'scrollContainer'", ObservableScrollView.class);
    view = Utils.findRequiredView(source, R.id.new_story_title, "field 'title' and method 'titleTextChanged'");
    target.title = Utils.castView(view, R.id.new_story_title, "field 'title'", EditText.class);
    view2131886250 = view;
    view2131886250TextWatcher = new TextWatcher() {
      @Override
      public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
        target.titleTextChanged(p0);
      }

      @Override
      public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
      }

      @Override
      public void afterTextChanged(Editable p0) {
      }
    };
    ((TextView) view).addTextChangedListener(view2131886250TextWatcher);
    target.urlLabel = Utils.findRequiredViewAsType(source, R.id.new_story_url_label, "field 'urlLabel'", TextInputLayout.class);
    view = Utils.findRequiredView(source, R.id.new_story_url, "field 'url', method 'onEditorAction', and method 'urlTextChanged'");
    target.url = Utils.castView(view, R.id.new_story_url, "field 'url'", EditText.class);
    view2131886252 = view;
    ((TextView) view).setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView p0, int p1, KeyEvent p2) {
        return target.onEditorAction(p0, p1, p2);
      }
    });
    view2131886252TextWatcher = new TextWatcher() {
      @Override
      public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
        target.urlTextChanged(p0);
      }

      @Override
      public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
      }

      @Override
      public void afterTextChanged(Editable p0) {
      }
    };
    ((TextView) view).addTextChangedListener(view2131886252TextWatcher);
    target.commentLabel = Utils.findRequiredViewAsType(source, R.id.new_story_comment_label, "field 'commentLabel'", TextInputLayout.class);
    view = Utils.findRequiredView(source, R.id.new_story_comment, "field 'comment', method 'onEditorAction', and method 'commentTextChanged'");
    target.comment = Utils.castView(view, R.id.new_story_comment, "field 'comment'", EditText.class);
    view2131886254 = view;
    ((TextView) view).setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView p0, int p1, KeyEvent p2) {
        return target.onEditorAction(p0, p1, p2);
      }
    });
    view2131886254TextWatcher = new TextWatcher() {
      @Override
      public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
        target.commentTextChanged(p0);
      }

      @Override
      public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
      }

      @Override
      public void afterTextChanged(Editable p0) {
      }
    };
    ((TextView) view).addTextChangedListener(view2131886254TextWatcher);
    view = Utils.findRequiredView(source, R.id.new_story_post, "field 'post' and method 'postNewStory'");
    target.post = Utils.castView(view, R.id.new_story_post, "field 'post'", Button.class);
    view2131886255 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.postNewStory();
      }
    });

    Resources res = source.getResources();
    target.appBarElevation = res.getDimension(R.dimen.z_app_bar);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.bottomSheet = null;
    target.bottomSheetContent = null;
    target.sheetTitle = null;
    target.scrollContainer = null;
    target.title = null;
    target.urlLabel = null;
    target.url = null;
    target.commentLabel = null;
    target.comment = null;
    target.post = null;

    view2131886246.setOnClickListener(null);
    view2131886246 = null;
    ((TextView) view2131886250).removeTextChangedListener(view2131886250TextWatcher);
    view2131886250TextWatcher = null;
    view2131886250 = null;
    ((TextView) view2131886252).setOnEditorActionListener(null);
    ((TextView) view2131886252).removeTextChangedListener(view2131886252TextWatcher);
    view2131886252TextWatcher = null;
    view2131886252 = null;
    ((TextView) view2131886254).setOnEditorActionListener(null);
    ((TextView) view2131886254).removeTextChangedListener(view2131886254TextWatcher);
    view2131886254TextWatcher = null;
    view2131886254 = null;
    view2131886255.setOnClickListener(null);
    view2131886255 = null;

    this.target = null;
  }
}
