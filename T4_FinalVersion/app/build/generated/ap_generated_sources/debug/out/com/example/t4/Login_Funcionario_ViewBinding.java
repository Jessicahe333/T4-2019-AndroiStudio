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

public class Login_Funcionario_ViewBinding implements Unbinder {
  private Login_Funcionario target;

  private View view7f07002a;

  @UiThread
  public Login_Funcionario_ViewBinding(Login_Funcionario target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Login_Funcionario_ViewBinding(final Login_Funcionario target, View source) {
    this.target = target;

    View view;
    target.editTextNome_F = Utils.findRequiredViewAsType(source, R.id.editTextNome_F, "field 'editTextNome_F'", EditText.class);
    target.editTextSenha_F = Utils.findRequiredViewAsType(source, R.id.editTextSenha_F, "field 'editTextSenha_F'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnLogin_F, "method 'login_F'");
    view7f07002a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.login_F();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    Login_Funcionario target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.editTextNome_F = null;
    target.editTextSenha_F = null;

    view7f07002a.setOnClickListener(null);
    view7f07002a = null;
  }
}
