WanaKanaJava
============

I converted WanaKana (https://github.com/wanikani/wanakana) to Java for use in Android projects. I targeted SDK 14 and up, but this'll probably work with prior versions of Android as well.

Usage
============
The methods described on WanaKana's documentation (https://github.com/WaniKani/WanaKana/blob/master/README.md#documentation) should all work in the same manner. I took some slight liberties on bind() and unbind(), though -  you don't need to pass anything along when you call them:
```java
// Create a new WanaKanaJava. Pass in an EditText and a boolean to indicate whether or not you want to use obsolete kana such as ゐ and ゑ
EditText et = (EditText) findViewById(R.id.editText);
WanaKanaJava wkj = new WanaKanaJava(et, false);

// Bind a TextWatcher to the EditText so any text input is converted
wkj.bind();

// Unbind the TextWatcher from the EditText
wkj.unbind();

// Returns false if string contains mixed characters, otherwise true if Hiragana.
wanakana.isHiragana(string)

// Returns false if string contains characters outside of the kana family, otherwise true if Hiragana and/or Katakana.
wanakana.isKana(string)

//Returns false if string contains mixed characters, otherwise true if Katakana.
wanakana.isKatakana(string)

// Convert Katakana or Romaji to Hiragana.
wanakana.toHiragana(string)

// Convert Romaji to Kana. Lowcase entries output Hiragana, while upcase entries output Katakana.
wanakana.toKana(string)

// Convert Hiragana or Romaji to Katakana.
wanakana.toKatakana(string)

// Convert Kana to Romaji.
wanakana.toRomaji(string)
```
