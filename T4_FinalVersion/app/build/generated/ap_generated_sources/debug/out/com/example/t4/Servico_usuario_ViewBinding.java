// Generated code from Butter Knife. Do not modify!
package com.example.t4;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Servico_usuario_ViewBinding implements Unbinder {
  private Servico_usuario target;

  private View view7f070028;

  private View view7f070026;

  @UiThread
  public Servico_usuario_ViewBinding(Servico_usuario target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Servico_usuario_ViewBinding(final Servico_usuario target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btnDevolucao, "method 'devolver'");
    view7f070028 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.devolver(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnAlugar, "method 'Alugar'");
    view7f070026 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.Alugar(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f070028.setOnClickListener(null);
    view7f070028 = null;
    view7f070026.setOnClickListener(null);
    view7f070026 = null;
  }
}
