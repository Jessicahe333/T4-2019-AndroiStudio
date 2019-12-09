// Generated code from Butter Knife. Do not modify!

/* XIAOYING HE   RA:17.00670-8
 * FERNANDA VENEROSO DE ALMEIDA RA:17.00112-9
 * KARINA LUMI DUQUE KURODA  RA:17.00709-7*/


package com.example.t4;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view7f07002c;

  private View view7f070029;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btnUsuario, "method 'entrarUsuario'");
    view7f07002c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.entrarUsuario(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnFuncionario, "method 'entrarFuncionario'");
    view7f070029 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.entrarFuncionario(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f07002c.setOnClickListener(null);
    view7f07002c = null;
    view7f070029.setOnClickListener(null);
    view7f070029 = null;
  }
}
