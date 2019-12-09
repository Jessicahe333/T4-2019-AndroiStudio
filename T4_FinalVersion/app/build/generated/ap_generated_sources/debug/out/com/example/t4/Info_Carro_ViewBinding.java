// Generated code from Butter Knife. Do not modify!
package com.example.t4;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Info_Carro_ViewBinding implements Unbinder {
  private Info_Carro target;

  private View view7f070027;

  @UiThread
  public Info_Carro_ViewBinding(Info_Carro target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Info_Carro_ViewBinding(final Info_Carro target, View source) {
    this.target = target;

    View view;
    target.textInfoCarro = Utils.findRequiredViewAsType(source, R.id.textInfoCarro, "field 'textInfoCarro'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btnBuscarCarro, "method 'buscarCarro'");
    view7f070027 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.buscarCarro();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    Info_Carro target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textInfoCarro = null;

    view7f070027.setOnClickListener(null);
    view7f070027 = null;
  }
}
