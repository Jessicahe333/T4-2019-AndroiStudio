// Generated code from Butter Knife. Do not modify!
package com.example.t4;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Login_Usuario_ViewBinding implements Unbinder {
  private Login_Usuario target;

  private View view7f07002b;

  @UiThread
  public Login_Usuario_ViewBinding(Login_Usuario target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Login_Usuario_ViewBinding(final Login_Usuario target, View source) {
    this.target = target;

    View view;
    target.editTextNome_U = Utils.findRequiredViewAsType(source, R.id.editTextNome_U, "field 'editTextNome_U'", EditText.class);
    target.editTextSenha_U = Utils.findRequiredViewAsType(source, R.id.editTextSenha_U, "field 'editTextSenha_U'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnLogin_U, "method 'login_U'");
    view7f07002b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.login_U();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    Login_Usuario target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.editTextNome_U = null;
    target.editTextSenha_U = null;

    view7f07002b.setOnClickListener(null);
    view7f07002b = null;
  }
}
