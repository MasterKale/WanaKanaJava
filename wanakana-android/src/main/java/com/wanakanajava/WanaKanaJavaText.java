package com.wanakanajava;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * A Java version of the Javascript WanaKana romaji-to-kana converter library (https://github.com/WaniKani/WanaKana)
 * Version 1.1.1
 */
public class WanaKanaJavaText
{
	static final String TAG = "WanaKanaJava";

	EditText gInputWindow;

  WanaKanaJava wanaKana;

	public WanaKanaJavaText(EditText et, Boolean useObsoleteKana)
	{
    this(et, new WanaKanaJava(useObsoleteKana));
	}
  
  public WanaKanaJavaText(EditText et, WanaKanaJava wanaKana)
	{
		gInputWindow = et;
    this.wanaKana = wanaKana;
	}

	TextWatcher tw = new TextWatcher()
	{
		@Override
		public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {}

		@Override
		public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {}

		@Override
		public void afterTextChanged(Editable romaji)
		{
			unbind();
			// Convert the text
			String sKana = wanaKana.toKana(romaji.toString());
			gInputWindow.setText(sKana);
			gInputWindow.setSelection(gInputWindow.getText().length());
			bind();
		}
	};

	// Bind a listener to the EditText so we know to start converting text entered into it
	public void bind()
	{
		if(gInputWindow != null)
		{
			gInputWindow.addTextChangedListener(tw);
		}
	}

	// Stop listening to text input on the EditText
	public void unbind()
	{
		if(gInputWindow != null)
		{
			gInputWindow.removeTextChangedListener(tw);
		}
	}

}
